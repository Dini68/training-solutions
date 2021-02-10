package week15d03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostFinderTest {

    @Test
    void getPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("kl", LocalDate.of(2021,10,20),"hjhh", "John"));
        posts.add(new Post("kh", LocalDate.of(2020,1,20),"hjkh", "Jack"));
        posts.add(new Post("kf", LocalDate.of(2021,11,20),"hhkh", "Jane"));
        posts.add(new Post("", LocalDate.of(2020,2,20),"hjhk", "John"));
        posts.add(new Post("ke", LocalDate.of(2020,8,20),"hjh", "Jack"));
        posts.add(new Post("kw", LocalDate.of(2020,7,20),"hjhh", "John"));
        PostFinder pf = new PostFinder(posts);
        assertEquals("hjhh", pf.findPostsFor("John"). get(0).getContent());
        System.out.println(pf.findPostsFor("Jack"));

    }
}