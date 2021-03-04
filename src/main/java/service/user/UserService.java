package service.user;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService{

    private static List<User> userList = new ArrayList<>();

    static {
        User u1 = new User();
        u1.setAge(10);
        u1.setName("John");
        u1.setAccount("john");
        u1.setEmail("john@codegym.vn");
        u1.setPassword("123456");
        userList.add(u1);

        User u2 = new User();
        u2.setAge(15);
        u2.setName("Bill");
        u2.setAccount("bill");
        u2.setEmail("bill@codegym.vn");
        u2.setPassword("123456");
        userList.add(u2);

        User u3 = new User();
        u3.setAge(16);
        u3.setName("Mike");
        u3.setAccount("mike");
        u3.setEmail("mike@codegym.vn");
        u3.setPassword("123456");
        userList.add(u3);
    }

    @Override
    public List<User> findAll() {
        return userList;
    }
}
