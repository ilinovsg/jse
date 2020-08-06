package ru.ilinovsg.tm.service;

import ru.ilinovsg.tm.constant.TerminalConst;
import ru.ilinovsg.tm.entity.User;
import ru.ilinovsg.tm.enumerated.Role;
import ru.ilinovsg.tm.repository.UserRepository;
import ru.ilinovsg.tm.utils.hashMD5;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(String login, String password, String firstName, String lastName, Role role) {
        if (login == null || login.isEmpty()) return null;
        if (password == null || password.isEmpty()) return null;
        if (firstName == null || firstName.isEmpty()) return null;
        if (lastName == null || lastName.isEmpty()) return null;
        if (role == null) return null;
        return userRepository.create(login, hashMD5.md5(password), firstName, lastName, role);
    }

    public User update(Long id, String login, String password, String firstName, String lastName, Role role) {
        if (id == null) return null;
        if (login == null || login.isEmpty()) return null;
        if (password == null || password.isEmpty()) return null;
        if (firstName == null || firstName.isEmpty()) return null;
        if (lastName == null || lastName.isEmpty()) return null;
        if (role == null) return null;
        return userRepository.update(id, login, hashMD5.md5(password), firstName, lastName, role);
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User removeById(Long id) {
        return userRepository.removeById(id);
    }

    public User removeByLogin(String login) {
        return userRepository.removeByLogin(login);
    }

    public void clear() {
        userRepository.clear();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
