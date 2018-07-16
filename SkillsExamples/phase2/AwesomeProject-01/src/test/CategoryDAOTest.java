import com.musicblog.dao.impl.CategoryDAO;
import com.musicblog.Category;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CategoryDAOTest {
    @Test
    public void categoryDAOGetAllTest(){

        CategoryDAO categoryDAO = new CategoryDAO();
        ArrayList<String> actualList = new ArrayList<>(Arrays.asList("testValue1", "testValue2","testValue3"));

        ArrayList<String> expectingReturn = new ArrayList<>();
        for (Category category: categoryDAO.getAll()) {
            expectingReturn.add(category.getName());
        }

        assertEquals(actualList, expectingReturn);
    }

    @Test
    public void categoryDAOGetByIdTest(){
        CategoryDAO categoryDAO = new CategoryDAO();
        Category byId = categoryDAO.getById(3);
        //Category byIdbySpring = categoryDAO.getByIdbySpring(3);
        assertEquals("Edit Category", byId.getName());
    }

    @Test
    public void categoryDAOGetBySpringIdTest(){
        CategoryDAO categoryDAO = new CategoryDAO();
        Category byIdbySpring = categoryDAO.getByIdbySpring(3);
        assertEquals("Edit Category", byIdbySpring.getName());
    }

    @Test
    public void categoryDAODeleteTest(){
        CategoryDAO categoryDAO = new CategoryDAO();
        Category byId = categoryDAO.getById(4);
        categoryDAO.delete(byId);
        Category byId1 = categoryDAO.getById(4);
        assertNull(byId1);

    }

    @Test
    public void categoryDAOCreateTest(){
        CategoryDAO categoryDAO = new CategoryDAO();
        Category insert_cat = new Category("Insert cat");

        categoryDAO.create(insert_cat);
        assertEquals(insert_cat.getName(), categoryDAO.getById(8).getName());
    }

    @Test
    public void categoryDAOUpdateTest(){
        CategoryDAO categoryDAO = new CategoryDAO();
        Category editCat = new Category(3, "Edit Category");
        categoryDAO.edit(editCat);
        assertEquals("Edit Category", categoryDAO.getById(3).getName());
    }
}
