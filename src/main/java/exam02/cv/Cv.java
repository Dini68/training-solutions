package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private String name;

    private List<Skill> skills = new ArrayList<>() ;

    public Cv(String name) {
        this.name = name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addSkills(String... skills) {
        String level;
        String name;
        for (int i = 0; i < skills.length; i++) {
            name = skills[i].substring(0, skills[i].length() - 4);
            level = skills[i].substring(skills[i].length() - 2, skills[i].length() - 1);
            Skill sk = new Skill(name, Integer.parseInt(level));
            this.skills.add(sk);
        }
    }

    public String getName() {
        return name;
    }

    public int findSkillLevelByName(String skillName) {
        if (skillName == null || skillName.isBlank()) {
            throw new IllegalArgumentException("Nincs név.");
        }
        int skillLevel = 0;
        for (Skill sk: skills) {
            if (sk.getName().equals(skillName)) {
                skillLevel = sk.getLevel();
            }
        }

        return skillLevel;
    }
}
