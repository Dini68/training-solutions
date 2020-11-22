package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    private List<Member> members = new ArrayList<>();

    public void addMember(String name){
        Member newMember = new Member(name);
        members.add(newMember);
    }


}
