package drugstore.ukraine.service.impl;

import drugstore.ukraine.config.EncrytedPasswordUtils;
import drugstore.ukraine.dao.UserRepository;
import drugstore.ukraine.enums.EducationType;
import drugstore.ukraine.enums.MaritalStatus;
import drugstore.ukraine.enums.Role;
import drugstore.ukraine.entity.User;
import drugstore.ukraine.enums.Status;
import drugstore.ukraine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        String encryptedPassword = EncrytedPasswordUtils.encrytePassword(user.getPassword());
        user.setPassword(encryptedPassword);
        user.setUserRole(Role.CUSTOMER);
        user.setStatus(Status.REGULAR);
        user.setFamily(null);
        if (user.getEducationType() == null) {
            user.setEducationType(EducationType.HIGH_SCHOOL);
        }
        if (user.getMaritalStatus() == null) {
            user.setMaritalStatus(MaritalStatus.SINGLE);
        }
        userRepository.save(user);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUser(Long id, User newUser) {
        Optional<User> oldUser = userRepository.findById(id);
        if (oldUser.isPresent()) {
            oldUser.get().setFamily(newUser.getFamily());
            oldUser.get().setStatus(newUser.getStatus());
            oldUser.get().setEducationType(newUser.getEducationType());
            oldUser.get().setMaritalStatus(newUser.getMaritalStatus());
            oldUser.get().setFamily(newUser.getFamily());
            oldUser.get().setFirstName(newUser.getFirstName());
            oldUser.get().setSecondName(newUser.getSecondName());
            oldUser.get().setMiddleName(newUser.getMiddleName());
            oldUser.get().setItNumber(newUser.getItNumber());
            userRepository.save(oldUser.get());

        }
    }

    @Override
    public String getUsernameFromSession(Object principal) {
        principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }



}
