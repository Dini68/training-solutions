package stringbasic.stringbasic;

public class StringCreator {

    private String st;

    public StringCreator(String st) {
        this.st = st;
    }

    public String createStringForHeap() {
        this.st = new String(st);
        return st;
    }

    public String createStringForPool() {
        this.st = st.intern();
        return st;
    }

    public static void main(String[] args) {

        StringCreator stringCreator = new StringCreator("Hello World!");

        stringCreator.createStringForHeap();
        stringCreator.createStringForPool();
    }
}
