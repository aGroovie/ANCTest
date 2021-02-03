package drugstore.ukraine.service;

import drugstore.ukraine.entity.User;


import java.util.Optional;

public interface UserService {

    void saveUser(User user);

    Iterable<User> getAllUsers();

    void deleteUserById(Long id);

    User findByUsername(String username);

    Optional<User> getUserById(Long id);

    void updateUser(Long id, User user);

    String getUsernameFromSession(Object principal);
}
