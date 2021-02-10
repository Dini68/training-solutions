package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostFinder {

    private List<Post> posts = new ArrayList<>();

    public List<Post> getPosts() {
        return new ArrayList<>(posts);
    }

    public PostFinder(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> findPostsFor(String user) {
        List<Post> result = new ArrayList<>();
        for (Post p: getPosts()) {
            if (p.getOwner().isEmpty() || p.getTitle().isEmpty()) {
                // throw empty;
            }
            else if (p.getPublishedAt().isAfter(LocalDate.now())) {
                    // throw no isBefore
                }
                else  if (p.getOwner().equals(user)) {
                    result.add(p);
                }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("kl", LocalDate.of(2021,10,20),"hjhh", "John"));
        posts.add(new Post("kh", LocalDate.of(2020,1,20),"hjkh", "Jack"));
        posts.add(new Post("kf", LocalDate.of(2021,11,20),"hhkh", "Jane"));
        posts.add(new Post("", LocalDate.of(2020,2,20),"hjhk", "John"));
        posts.add(new Post("ke", LocalDate.of(2020,8,20),"hjh", "Jack"));
        posts.add(new Post("kw", LocalDate.of(2020,7,20),"hjhh", "John"));
        PostFinder pf = new PostFinder(posts);
        System.out.println(pf.findPostsFor("John"));
        System.out.println(pf.findPostsFor("Jack"));
    }
}
