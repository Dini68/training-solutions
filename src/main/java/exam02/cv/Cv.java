package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private String name;

    private List<Skill> skills = new ArrayList<>();

    public Cv(String name, List<Skill> skills) {
        this.name = name;
        this.skills = skills;
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
