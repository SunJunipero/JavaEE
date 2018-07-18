import com.musicblog.dao.daoimpl.CategoryDAO;
import com.musicblog.dao.daoimpl.PostDAO;
import com.musicblog.model.Category;
import com.musicblog.model.Post;
import org.junit.Test;

public class PostDAOTest {
    @Test
    public void insertPostTest(){
        PostDAO postDAO = new PostDAO();
        Category test = new Category(1, "test");

        postDAO.create(new Post("testSpringJDBCTitle", "testSpringJDBCSummary","testSpringJDBCBody", test));
    }
}
