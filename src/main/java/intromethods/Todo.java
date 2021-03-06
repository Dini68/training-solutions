package intromethods;

public class Todo {

    private String caption;
    private boolean finished;

    public Todo(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public boolean isFinished() {
        return finished;
    }

    public void finish() {
        finished = true;
    }

    public String toString() {
        return this.getCaption() + "(" + this.isFinished() + ")";
    }
}
