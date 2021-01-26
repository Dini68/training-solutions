package week13d02.senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private final static int NUMBER_OF_QUESTIONS = 5;

    private final static int NUMBER_OF_ANSWERS = 4;

    private List<String> correctAnswers = new ArrayList<>();

    private List<Answer> answers = new ArrayList<>();

    private List<String> playerCodes = new ArrayList<>();

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<String> getPlayerCodes() {
        return playerCodes;
    }

    private void addCorrectAnswers(String headerLine) {
        for (int i = 0; i < headerLine.length(); i++) {
            correctAnswers.add(String.valueOf(headerLine.charAt(i)));
        }
    }

    private void addAnswers (BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String id = line.split(" ")[0];
            String answer = line.split(" ")[1];
            answers.add(new Answer(id, answer));
            if (!playerCodes.contains(id)) {
                playerCodes.add(id);
            }
        }
    }

    public void readResultFromFile(String fileName) {
        Path path = Path.of(fileName);
        try (BufferedReader br = Files.newBufferedReader(path)){
            addCorrectAnswers(br.readLine());
            addAnswers(br);
        } catch (IOException e) {
            throw new IllegalStateException("can not file", e);
        }
    }

    public boolean isCorrectAnswer (String code, int questionNumber) {
        int count = 0;
        for (Answer a: answers) {
            if (a.getId().equals(code)) {
                count ++;
                if (count == questionNumber) {
                    return a.getAnswer().equals(correctAnswers.get(count-1));
                    }
                }
            }
        throw new IllegalArgumentException("Wrong param.");
    }

    public String codeOfMostAnswersX() {
        String code = "0";
        int[] counts = new int[playerCodes.size()];
        for (Answer a: answers) {
            if (a.getAnswer().equals("X")) {
                counts[playerCodes.indexOf(a.getId())] ++;
            }
        }
        int max = 0;
        for (int i = 0; i < counts.length; i++) {
            if(max < counts[i]) {
                max = counts[i];
                code = playerCodes.get(i);
            }
        }
        return code;
    }

    public String codeOfMostPoints() {
        String code = "";
        int maxPoint = 0;
        int[] points = new int[playerCodes.size()];
        for (int i = 0; i < playerCodes.size(); i++ ) {
            for (int j = 1; j <= NUMBER_OF_QUESTIONS; j++) {
                if (isCorrectAnswer(playerCodes.get(i), j)) {
                    points[i] += j;
                }
            }
            if (maxPoint < points[i]) {
                maxPoint = points[i];
                code = playerCodes.get(i);
            }
        }
        return code;
    }

}
