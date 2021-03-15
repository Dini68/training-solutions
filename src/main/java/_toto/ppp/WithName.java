package _toto.ppp;

import java.util.ArrayList;
import java.util.List;

public class WithName {
    private String name;


    public WithName(String name) {
        this.name = name;
    }
    public String modifyName(String name) {
        return this.name = name;
    }

    public String getName() {
        return name;
    }


    public List<Course> createCourses(String... names) {
        List<Course> courses = new ArrayList<>();
        for (String name: names) {
            courses.add(new Course(name));
        }
        return courses;
    }

    public List<Course> createCourses2(String... names) {
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            courses.add(new Course(names[i]));
        }
        return courses;
    }


    public static void main(String[] args) {
        WithName wn = new WithName("John Doe");
        System.out.println(wn.getName());
        System.out.println(wn.modifyName("Jack Doe"));
        System.out.println(wn.getName());
        System.out.println(wn. createCourses("kk", "gg", "RR"));
        System.out.println(wn. createCourses2("kk2", "gg2", "RR2"));

    }
}