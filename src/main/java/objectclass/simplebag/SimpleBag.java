package objectclass.simplebag;

import java.util.ArrayList;
import java.util.List;

public class SimpleBag {

    private List<Object> items = new ArrayList<>();

    public SimpleBag(){

    }
    public void putItem(Object item) {

    }
    public boolean isEmpty() {
        return false;
    }
    public int size() {
        return 1;
    }
    public void beforeFirst() {

    }
    public boolean hasNext() {
        return false;
    }
//    public Object next() {

//    }
    public boolean contains(Object item) {
        return false;
    }
    public int getCursor() {
        return 1;
    }
}
