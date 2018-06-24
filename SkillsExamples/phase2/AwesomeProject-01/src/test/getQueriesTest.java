import com.musicblog.util.DatabaseUtil;
import org.junit.Test;


import static org.junit.Assert.*;
public class getQueriesTest {

    @Test
    public void queriesTest(){
        DatabaseUtil databaseUtil = new DatabaseUtil();
        assertEquals("select * from posts;", databaseUtil.getQuery("get.all.posts"));
        assertEquals("insert into categories (`name`) values (?)", databaseUtil.getQuery("create.category"));





    }
}
