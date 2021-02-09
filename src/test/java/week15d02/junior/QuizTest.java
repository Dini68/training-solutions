package week15d02.junior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    @Test
    void getQuestions() {
        Quiz qu = new Quiz();
        qu.readFromFileToLines("src/main/java/week15d02/junior/kerdesek.txt");
        assertEquals(57, qu.getQuestions().size()); // általános lista
        assertEquals(1, qu.questionsByTopic("magyar").size()); // 1.
//        System.out.println(qu.selectRandomQuestion());   // 2.
        assertEquals(5, qu.mapOfTopics().keySet().size());   // 3.
        assertEquals(15, qu.mapOfTopics().get("tortenelem").size());   // 3.
        assertEquals("matematika", qu.maxSumOfPoints());   // 4.

    }
}