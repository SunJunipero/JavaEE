import com.musicblog.dao.impl.PostDAO;
import com.musicblog.model.Category;
import com.musicblog.model.Post;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class PostDAOTest {
    @Test
    public void postDAOgetbyId(){
        PostDAO postDAO = new PostDAO();

        Post byId = postDAO.getById(2);

        Category category = new Category();
        category.setName("testValue1");

        Post post = new Post("Test title2","Test summary2","Test body2", category);

        assertEquals(byId, post);

    }
}
