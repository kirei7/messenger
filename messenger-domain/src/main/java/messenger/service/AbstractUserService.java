package messenger.service;

import messenger.dao.ProfileDao;
import messenger.dao.UserDao;
import messenger.entity.Profile;
import messenger.entity.User;
import messenger.util.ProfileBinder;

/**
 * Service contains User-related logic and is totally functional
 * by itself. The reason why it's declared as abstract - it should
 * be transactional, which can't be implemented without framework.
 * So to use a service it's necessary to extend this class and
 * make a derivative transactional(i.e. mark with proper annotation)
 * */
public abstract class AbstractUserService implements UserService {
    private UserDao userDao;
    private ProfileDao profileDao;
    private ProfileBinder binder;

    public AbstractUserService(
            UserDao userDao,
            ProfileDao profileDao,
            ProfileBinder binder
    ) {
        this.userDao = userDao;
        this.profileDao = profileDao;
        this.binder = binder;
    }

    public User registerUser(User user, Profile profile) {
        User persistedUser = persistUser(user);
        Profile boundedProfile = bind(persistedUser, profile);
        persistProfile(boundedProfile);
        return persistedUser;
    }
    private User persistUser(User user) {
        return userDao.persist(user);
    }
    private Profile bind(User user, Profile profile) {
        return binder.bind(user, profile);
    }
    private Profile persistProfile(Profile profile) {
        return profileDao.persist(profile);
    }

}
