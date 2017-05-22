package messenger.dao;

import messenger.entity.User;

public interface UserDao {
    User findById(Long id);
    User persist(User user);
    User update(User user);
    Long delete(Long userId);
}
