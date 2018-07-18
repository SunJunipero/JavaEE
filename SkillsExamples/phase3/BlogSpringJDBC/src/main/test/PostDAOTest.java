import com.musicblog.dao.daoimpl.CategoryDAO;
import com.musicblog.dao.daoimpl.PostDAO;
import com.musicblog.model.Category;
import com.musicblog.model.Post;
import org.junit.Test;

import java.sql.SQLException;

public class PostDAOTest {
    @Test
    public void insertPostTest(){
        PostDAO postDAO = new PostDAO();
        Category test = new Category(1, "test");

        postDAO.create(new Post("testSpringJDBCTitle", "testSpringJDBCSummary","testSpringJDBCBody", test));
    }

    @Test
    public void updatePostTest()  {
        PostDAO postDAO = new PostDAO();
        Post byId = postDAO.getById(13);
        byId.setTitle("Update by SpringJDBC");
        postDAO.update(byId);

    }

    @Test
    public void deletePostTest(){
        PostDAO postDAO = new PostDAO();
        Post byId = postDAO.getById(13);
        postDAO.delete(byId);
    }

    @Test
    public void getAllPostsTest(){
        PostDAO postDAO = new PostDAO();
        System.out.println(postDAO.getAll());
    }

    @Test
    public void getAllPostByCategoryTest(){
        PostDAO postDAO = new PostDAO();
        System.out.println(postDAO.getPostsByCategoryId(8));
    }
}
