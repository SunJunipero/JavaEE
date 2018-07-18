import com.musicblog.dao.daoimpl.CategoryDAO;
import com.musicblog.model.Category;
import org.junit.Test;

import java.util.List;

public class CategoryDAOTest {
    @Test
    public void insertCategoryTest(){
        CategoryDAO categoryDAO = new CategoryDAO();
        Category springJDBC_insert = categoryDAO.create(new Category("SpringJDBC insert"));
    }

    @Test
    public void updateCategoryTest(){
        CategoryDAO categoryDAO = new CategoryDAO();
        categoryDAO.update(new Category(9,"Updated by SpringJDBC"));
    }

    @Test
    public void deleteCategoryTest(){
        CategoryDAO categoryDAO = new CategoryDAO();
        Category byId = categoryDAO.getById(3);
        System.out.println(byId);
        categoryDAO.delete(byId);
    }

    @Test
    public void getAllCategoryTest(){
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> all = categoryDAO.getAll();
        System.out.println(all);
    }
}
