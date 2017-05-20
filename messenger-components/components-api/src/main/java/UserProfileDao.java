import messenger.entity.UserProfile;

public interface UserProfileDao {
    UserProfile findById(Long id);
    UserProfile persist(UserProfile profile);
    UserProfile update(UserProfile profile);
    Long delete(Long profileId);
}
