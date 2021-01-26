package week13d02.senior;

public class Answer {

    private String id;

    private String answer;

    public Answer(String id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return id + " " + answer;
    }
}
