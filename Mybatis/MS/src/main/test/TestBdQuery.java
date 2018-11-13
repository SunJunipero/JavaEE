import com.petshop.project.mapper.UserMapper;
import com.petshop.project.model.User;

import java.util.Date;
import java.util.List;

public class TestBdQuery {

    static void  getUserTest(){
        UserMapper userMapper = new UserMapper();
        User user = userMapper.getUserById(1);
        System.out.println(user);
    }

    static void getAllUsersTest(){
        UserMapper userMapper = new UserMapper();
        List<User> users = userMapper.getAllUsers();
        users.forEach(user -> {
            System.out.println(user);
            System.out.println("=======");
        });
    }

    static void insertUserTest(){
        User user = new User();

        user.setUser_first_name("John");
        user.setUser_last_name("Talabot");
        user.setUser_name("JB");
        user.setPassword("qwerty");
        user.setEmail("jb@mail.ru");

        System.out.println(user);

        UserMapper userMapper = new UserMapper();
        userMapper.addUser(user);
    }

    static void updateUserTest(){
        UserMapper userMapper = new UserMapper();
        User user = userMapper.getUserById(2);
        user.setEmail("updatedEmail@gmail.com");
        userMapper.updateUser(user);

    }

    static void deleteUserTest(){
        UserMapper userMapper = new UserMapper();
        userMapper.deleteUser(4);
    }

    public static void main(String[] args) {
        getAllUsersTest();
        System.out.println("======");
        deleteUserTest();
        System.out.println("======");
        getAllUsersTest();
    }
}
