package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    private List<Member> members = new ArrayList<>();

    public void addMember(String name){
        Member newMember = new Member(name);
        members.add(newMember);
    }

    public void connect(String name, String otherName){
        Member first = findByName(name);
        first.connectMember(findByName(otherName));
    }

    private Member findByName (String name){
        for (Member member: members
             ) {
            if (member.getName().equals(name)){
                return member;
            }
        }
        return null;
    }

    public List<String> bidirectionalConnections() {
        List<String> connections = new ArrayList<>();
        for (Member member: members
             ) {
            for (Member member2: member.getConnections()
                 ) {
                if (member2.getConnections().contains(member)) {
                    connections.add(member.getName() + " - " + member2.getName());

                }
            }
        }
        return connections;
    }
}
