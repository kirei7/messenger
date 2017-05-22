package messenger.service;

import messenger.dao.ProfileDao;
import messenger.dao.UserDao;
import messenger.entity.Profile;
import messenger.entity.User;
import messenger.util.ProfileBinder;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class AbstractUserServiceTest {

    private AbstractUserService service;
    private UserDao userDao;
    private ProfileDao profileDao;
    private ProfileBinder binder;

    @Before
    public void prepareTests() {
        userDao = createUserDao();
        profileDao = createProfileDao();
        binder = createProfileBinder();
        service = createTestService();
    }
    private UserDao createUserDao() {
        return mock(UserDao.class);
    }
    private ProfileDao createProfileDao() {
        return mock(ProfileDao.class);
    }
    private ProfileBinder createProfileBinder() {
        return mock(ProfileBinder.class);
    }
    private AbstractUserService createTestService() {
        return new ConcreteTestUserService(userDao, profileDao, binder);
    }


    @Test
    public void registerShouldCallAllMethodsForPersisting() {
        User user = createUserMock();
        Profile profile = createProfileMock();

        service.registerUser(user, profile);

        verify(userDao).persist(any(User.class));
        verify(profileDao).persist(any(Profile.class));
        verify(binder).bind(any(User.class), any(Profile.class));

    }
    private User createUserMock() {
        return mock(User.class);
    }
    private Profile createProfileMock(){
        return mock(Profile.class);
    }

}

class ConcreteTestUserService extends AbstractUserService {
    ConcreteTestUserService(UserDao userDao, ProfileDao profileDao, ProfileBinder binder) {
        super(userDao, profileDao, binder);
    }
}