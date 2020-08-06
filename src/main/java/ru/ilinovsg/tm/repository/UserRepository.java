package ru.ilinovsg.tm.repository;

import ru.ilinovsg.tm.constant.TerminalConst;
import ru.ilinovsg.tm.entity.User;
import ru.ilinovsg.tm.enumerated.Role;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public User create(final String login, final String password, final String firstName, final String lastName, final Role role) {
        final User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRole(role);
        users.add(user);
        return user;
    }

    public User update(final Long id, final String login, final String password, final String firstName, final String lastName, final Role role) {
        final User user = findById(id);
        if (user == null) return null;
        user.setId(id);
        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRole(role);
        return user;
    }

    public User findById(final Long id) {
        for (final User user : users) {
            if (user.getId().equals(id)) return user;
        }
        return null;
    }

    public User findByLogin(final String login) {
        for (final User user : users) {
            if (user.getLogin().equals(login)) return user;
        }
        return null;
    }

    public User removeById(final Long id) {
        final User user = findById(id);
        if (user == null) return null;
        users.remove(user);
        return user;
    }

    public User removeByLogin(final String login) {
        final User user = findByLogin(login);
        if (user == null) return null;
        users.remove(user);
        return user;
    }

    public void clear() { users.clear(); }

    public List<User> findAll() { return users; }

}
