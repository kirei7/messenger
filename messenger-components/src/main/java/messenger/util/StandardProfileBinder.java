package messenger.util;

import messenger.entity.ProfileEntity;
import messenger.entity.UserEntity;

public class StandardProfileBinder implements ProfileBinder<UserEntity, ProfileEntity> {
    @Override
    public ProfileEntity bind(UserEntity user, ProfileEntity profile) {
        profile.setId(user.getId());
        return profile;
    }
}
