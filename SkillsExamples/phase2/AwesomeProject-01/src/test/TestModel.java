import com.musicblog.model.Category;
import com.musicblog.model.Post;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class TestModel {
    Category indie = new Category("indie");
    Category rock = new Category("rock");

    Post am6 = new Post("six album AM", "good album", "bla-bla-bla good album6", indie);
    Post am5 = new Post("fifth album AM", "excellent album", "om-nom-nom awesome album6", indie);
    Post ff = new Post("ff album", "norm album", "frnzzzz", indie);

    List<Post> indiePosts = Arrays.asList(am6, am5, ff);

    Post metallica = new Post("Metallica album", "mega album", "mmmmmeTAAAAAAL", rock);
    Post AA = new Post("Asking Alexandria", "goood !!!!", "AA is back", rock);

    List<Post> rockList = Arrays.asList(metallica, AA);

    @Test
    public void checkPostTitle(){
        indie.setPosts(indiePosts);

        List<String> strings = Arrays.asList("six album AM", "fifth album AM", "ff album");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(am6.getTitle());
        arrayList.add(am5.getTitle());
        arrayList.add(ff.getTitle());

        ArrayList<String> expected = new ArrayList<>();

        for (Post post : indie.getPosts()) {
            expected.add(post.getTitle());
        }

        assertEquals(expected, arrayList);
    }

}
