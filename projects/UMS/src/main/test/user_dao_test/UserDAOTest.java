//package user_dao_test;
//
//import com.project.ums.rest.UserController;
//import com.project.ums.model.User;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import static org.junit.Assert.*;
//
//public class UserDAOTest {
//    ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"testappcontext.xml"});
//    UserController userController = (UserController) context.getBean("userController");
//
//
//    @Test
//    public void getUserByIdTest(){
//        assertEquals("jreexp", userController.getUser("4").getUser_name());
//    }
//
//    @Test
//    public void getAll(){
//        assertEquals(4, userController.getAll().size());
//    }
//
//    @Test
//     public void deleteUser(){
//         userController.delete("10");
//         assertNull(userController.getUser("10"));
//     }
//
//     @Test
//     public void createUser(){
//         User test_user = (User) context.getBean("test_user");
//         userController.add(test_user);
//         assertTrue(true);
//     }
//
//     @Test
//     public void updateUser(){
//         User user1 = userController.getUser("10");
//         user1.setEmail("another123@email.com");
//         userController.update(user1, "10");
//         assertEquals("another123@email.com", userController.getUser("10").getEmail());
//     }
//}
