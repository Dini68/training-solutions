package week13d04;

public class ObjectUnit {

    private Object someThing1;
    private Object someThing2;
    private Object someThing3;
    private Object someThing4;

    public ObjectUnit(Object someThing1, Object someThing2, Object someThing3, Object someThing4) {
        this.someThing1 = someThing1;
        this.someThing2 = someThing2;
        this.someThing3 = someThing3;
        this.someThing4 = someThing4;
    }

    public Object getSomeThing1() {
        return someThing1;
    }

    public Object getSomeThing2() {
        return someThing2;
    }

    public Object getSomeThing3() {
        return someThing3;
    }

    public Object getSomeThing4() {
        return someThing4;
    }

    @Override
    public String toString() {
        return "ObjectUnit{" +
                "someThing1=" + someThing1 +
                ", someThing2=" + someThing2 +
                ", someThing3=" + someThing3 +
                ", someThing4=" + someThing4 +
                '}';
    }
}
