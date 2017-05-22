package messenger.util;

import messenger.entity.Profile;
import messenger.entity.User;

/**
 * Binds a profile entity to user entity
 * (i.e. by setting profile's id the same as
 * user's id)
 **/
public interface ProfileBinder<T extends User, P extends Profile> {
    P bind(T user, P profile);
}
