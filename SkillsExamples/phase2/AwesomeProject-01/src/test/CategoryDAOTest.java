import com.musicblog.dao.impl.CategoryDAO;
import com.musicblog.model.Category;
import static org.junit.Assert.*;
import org.junit.Test;

import java.sql.Connection;
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
    public void categoryDAOGetById(){
        CategoryDAO categoryDAO = new CategoryDAO();
        Category byId = categoryDAO.getById(3);
        assertEquals("testValue3", byId.getName());
    }
}
