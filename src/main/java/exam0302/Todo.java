package exam0302;

public class Todo {

    private String text;
    private State state;
    private int priority;

    public Todo(String text, int priority) {
        if (priority < 1 || priority > 5) {
            throw new IllegalArgumentException("1 és 5 között kell lennie");
        }
        this.text = text;
        this.priority = priority;
        this.state = State.NON_COMPLETED;
    }

    public String getText() {
        return text;
    }

    public State getState() {
        return state;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "text='" + text + '\'' +
                ", state=" + state +
                ", priority=" + priority +
                '}';
    }

    public void complete() {
        this.state = State.COMPLETED;
    }
}
