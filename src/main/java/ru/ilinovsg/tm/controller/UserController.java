package ru.ilinovsg.tm.controller;

import ru.ilinovsg.tm.constant.TerminalConst;
import ru.ilinovsg.tm.entity.Task;
import ru.ilinovsg.tm.entity.User;
import ru.ilinovsg.tm.enumerated.Role;
import ru.ilinovsg.tm.service.UserService;

import java.util.List;

public class UserController extends AbstractController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public int createUser() {
        System.out.println("[Create user]");
        System.out.println("[Please, enter login]");
        final String login = scanner.nextLine();
        System.out.println("[Please, enter password]");
        final String password = scanner.nextLine();
        System.out.println("[Please, enter firstName]");
        final String firstName = scanner.nextLine();
        System.out.println("[Please, enter lastName]");
        final String lastName = scanner.nextLine();
        System.out.println("[Please, enter access role: Admin or User]");
        final String role = scanner.nextLine();
        userService.create(login, password, firstName, lastName, Role.valueOf(role));
        System.out.println("[OK]");
        return 0;
    }

    public int clearUser() {
        System.out.println("[Clear user]");
        userService.clear();
        System.out.println("[OK]");
        return 0;
    }

    public void viewUser(final User user) {
        if (user == null) return;
        System.out.println("[View user]");
        System.out.println("ID: " + user.getId());
        System.out.println("LOGIN: " + user.getLogin());
        System.out.println("FIRST NAME: " + user.getFirstName());
        System.out.println("LAST NAME: " + user.getLastName());
        System.out.println("ROLE: " + user.getRole());
        System.out.println("[OK]");
    }

    public int viewUserById() {
        System.out.println("Enter user id");
        final Long id = scanner.nextLong();
        final User user = userService.findById(id);
        viewUser(user);
        return 0;
    }

    public int viewUserByLogin() {
        System.out.println("Enter user login");
        final String login = scanner.nextLine();
        final User user = userService.findByLogin(login);
        viewUser(user);
        return 0;
    }

    public int listUser() {
        System.out.println("[List user]");
        viewUsers(userService.findAll());
        System.out.println("[OK]");
        return 0;
    }

    public void viewUsers(final List<User> users) {
        if (users == null || users.isEmpty()) return;
        int index = 1;
        for (final User user : users) {
            System.out.println(index + "." + user.getId() + " " + user.getLogin() + " role: " + user.getRole());
            index++;
        }
    }

    public int updateUserById() {
        System.out.println("[Update user]");
        System.out.println("[Please, enter user id]");
        final Long id = Long.parseLong(scanner.nextLine());
        final User user = userService.findById(id);
        if (user == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter user login]");
        final String login = scanner.nextLine();
        System.out.println("[Please, enter user password]");
        final String password = scanner.nextLine();
        System.out.println("[Please, enter user first name]");
        final String firstName = scanner.nextLine();
        System.out.println("[Please, enter user last name]");
        final String lastName = scanner.nextLine();
        System.out.println("[Please, enter user role (Admin or User)]");
        final String role = scanner.nextLine();
        userService.update(user.getId(), login, password, firstName, lastName, Role.valueOf(role));
        System.out.println("[OK]");
        return 0;
    }

    public int updateUserByLogin() {
        System.out.println("[Update user]");
        System.out.println("[Please, enter user login]");
        final String login = scanner.nextLine();
        final User user = userService.findByLogin(login);
        if (user == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter user password]");
        final String password = scanner.nextLine();
        System.out.println("[Please, enter user first name]");
        final String firstName = scanner.nextLine();
        System.out.println("[Please, enter user last name]");
        final String lastName = scanner.nextLine();
        System.out.println("[Please, enter user role (Admin or User)]");
        final String role = scanner.nextLine();
        userService.update(user.getId(), login, password, firstName, lastName, Role.valueOf(role));
        System.out.println("[OK]");
        return 0;
    }

    public int removeUserById() {
        System.out.println("[Please, enter user id]");
        final Long id = scanner.nextLong();
        final User user = userService.removeById(id);
        if (user == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int removeUserByLogin() {
        System.out.println("[Please, enter user login]");
        final String login = scanner.nextLine();
        final User user = userService.removeByLogin(login);
        if (user == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

}
