package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String name;
    private List<String> connections = new ArrayList<>();

    public Member (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


/*    public List<Member> getConnections() {
        return ;
    }*/
}
