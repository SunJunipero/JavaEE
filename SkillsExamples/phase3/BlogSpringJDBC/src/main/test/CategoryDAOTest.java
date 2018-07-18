import com.musicblog.dao.daoimpl.CategoryDAO;
import com.musicblog.model.Category;
import org.junit.Test;

public class CategoryDAOTest {
    @Test
    public void insertCategoryTest(){
        CategoryDAO categoryDAO = new CategoryDAO();
        Category springJDBC_insert = categoryDAO.create(new Category("SpringJDBC insert"));

    }
}
