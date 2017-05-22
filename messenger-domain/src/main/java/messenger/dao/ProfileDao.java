package messenger.dao;

import messenger.entity.Profile;

public interface ProfileDao {
    Profile findById(Long id);
    Profile persist(Profile profile);
    Profile update(Profile profile);
    Long delete(Long profileId);
}
