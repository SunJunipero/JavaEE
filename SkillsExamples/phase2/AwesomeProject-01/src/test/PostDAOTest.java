import com.musicblog.dao.impl.CategoryDAO;
import com.musicblog.dao.impl.PostDAO;
import com.musicblog.model.Category;
import com.musicblog.model.Post;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class PostDAOTest {
    @Test
    public void postDAOgetbyIdTest(){
        PostDAO postDAO = new PostDAO();

        Post byId = postDAO.getById(2);

        Category category = new Category();
        category.setName("testValue1");

        Post post = new Post("Test title2","Test summary2","Test body2", category);

        assertEquals(byId, post);
    }

    @Test
    public void postDAOgetAllTest(){
        PostDAO postDAO = new PostDAO();
        List<Post> all = postDAO.getAll();
        assertEquals(3, all.size());
    }

    @Test
    public void postDAODeleteTest(){
        PostDAO postDAO = new PostDAO();
        Post byId = postDAO.getById(3);
        postDAO.delete(byId);
        Post byId1 = postDAO.getById(3);
        assertNull(byId1);
    }

    @Test
    public void postDAOCreateTest(){
        PostDAO postDAO = new PostDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        Post post = new Post("insert title", "insert summary", "insert body", categoryDAO.getById(2));
        postDAO.create(post);
        assertEquals(Integer.valueOf(7), postDAO.getById(7).getId());
    }

    @Test
    public void postDAOUpdateTest(){
        PostDAO postDAO = new PostDAO();
        Post byId = postDAO.getById(2);
        byId.setBody("update body");
        byId.setSummary("update summary");
        postDAO.edit(byId);
        assertEquals("update body", postDAO.getById(2).getBody());
        assertEquals("update summary", postDAO.getById(2).getSummary());
    }
}

