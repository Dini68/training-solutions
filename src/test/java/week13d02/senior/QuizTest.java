package week13d02.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    Quiz q = new Quiz();

    @Test
    void readResultFromFileTest() {
        q.readResultFromFile("result.txt");
    }

    @Test
    void isCorrectAnswerTest() {
        q.readResultFromFile("result.txt");
        assertEquals(false,q.isCorrectAnswer("AB123", 4));
    }

    @Test
    void codeOfMostAnswersXTest() {
        q.readResultFromFile("result.txt");
        assertEquals("BD452",q.codeOfMostAnswersX());
    }

    @Test
    void codeOfMostPointsTest() {
        q.readResultFromFile("result.txt");
        assertEquals("GH1234",q.codeOfMostPoints());
    }
}
