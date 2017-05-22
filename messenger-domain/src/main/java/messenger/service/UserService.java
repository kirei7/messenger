package messenger.service;

import messenger.entity.Profile;
import messenger.entity.User;

public interface UserService {
    User registerUser(User user, Profile profile);
}
