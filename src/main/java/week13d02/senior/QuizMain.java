package week13d02.senior;

public class QuizMain {
    public static void main(String[] args) {
        Quiz q = new Quiz();
        q.readResultFromFile("result.txt");
        System.out.println(q.isCorrectAnswer("AB123", 5));
        System.out.println(q.codeOfMostAnswersX());
        System.out.println(q.codeOfMostPoints());
    }

}
