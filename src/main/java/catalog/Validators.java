package catalog;

import java.util.List;

public class Validators {

    public boolean isBlank(String str) {

        return str == null || str.equals("");//?
    }

    public boolean isEmpty(List list) {

        return list == null || list.size() == 0;//?
    }
}
