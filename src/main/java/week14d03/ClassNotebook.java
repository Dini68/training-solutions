package week14d03;

import java.util.*;

public class ClassNotebook {


    private List<Student> students;

    public ClassNotebook(List<Student> students) {
        this.students = students;
    }

    public List<Student> sortNotebook () {
        List<Student> sortStudent = new ArrayList<>();
        for (Student s: students) {
            sortStudent.add(new Student(s));
        }
        Collections.sort(sortStudent);
        return sortStudent;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void addStudent(String name) {
        students.add(new Student(name));
    }

    public void addMarkByName(String name, String subject, int mark) {
        for (Student st: students) {
            if (st.getName().equals(name)) {
                st.addMark(subject, mark);
            }
        }
    }


    public static void main(String[] args) {
        ClassNotebook cn = new ClassNotebook(new ArrayList<>(List.of(new Student("Kovács"))));
        cn.addStudent("Kovács");
        cn.addMarkByName("Kovács","Fizika" , 5);
        cn.addMarkByName("Kovács","Fizika" , 4);
        cn.addMarkByName("Kovács","Fizika" , 3);
        cn.addMarkByName("Kovács","Fizika" , 2);
        cn.addMarkByName("Kovács","Matematika" , 5);
        cn.addMarkByName("Kovács","Matematika" , 4);
        cn.addMarkByName("Kovács","Matematika" , 3);
        cn.addMarkByName("Kovács","Matematika" , 2);
        cn.addMarkByName("Kovács","Ének" , 5);
        cn.addMarkByName("Kovács","Ének" , 4);
        cn.addMarkByName("Kovács","Ének" , 3);
        cn.addMarkByName("Kovács","Ének" , 2);
        cn.addStudent("Simon");
        cn.addMarkByName("Simon","Fizika" , 5);
        cn.addMarkByName("Simon","Fizika" , 4);
        cn.addMarkByName("Simon","Fizika" , 3);
        cn.addMarkByName("Simon","Fizika" , 2);
        cn.addMarkByName("Simon","Matematika" , 5);
        cn.addMarkByName("Simon","Matematika" , 4);
        cn.addMarkByName("Simon","Matematika" , 3);
        cn.addMarkByName("Simon","Matematika" , 2);
        cn.addMarkByName("Simon","Ének" , 5);
        cn.addMarkByName("Simon","Ének" , 4);
        cn.addMarkByName("Simon","Ének" , 3);
        cn.addMarkByName("Simon","Ének" , 2);
        cn.addStudent("Hunor");
        cn.addMarkByName("Hunor","Fizika" , 5);
        cn.addMarkByName("Hunor","Fizika" , 4);
        cn.addMarkByName("Hunor","Fizika" , 3);
        cn.addMarkByName("Hunor","Fizika" , 2);
        cn.addMarkByName("Hunor","Matematika" , 5);
        cn.addMarkByName("Hunor","Matematika" , 4);
        cn.addMarkByName("Hunor","Matematika" , 3);
        cn.addMarkByName("Hunor","Matematika" , 2);
        cn.addMarkByName("Hunor","Ének" , 5);
        cn.addMarkByName("Hunor","Ének" , 4);
        cn.addMarkByName("Hunor","Ének" , 3);
        cn.addMarkByName("Hunor","Ének" , 2);
        System.out.println(cn.getStudents());
        System.out.println(cn.sortNotebook());
    }
}
