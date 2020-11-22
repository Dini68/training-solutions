package typeconversion.whichtype;

import java.util.ArrayList;
import java.util.List;

public class WhichType {

    public List<Type> whichType(String s){
        List<Type> types = new ArrayList<>();
        long number = Long.parseLong(s);
        for (Type type: Type.values()
             ) {
            if (number >= type.getMin() && number <= type.getMax()) {
                types.add(type);
            }

        }
//        types.add(types.get(0));
/*        for (int i = 0; i < 3; i++) {
            if ((number > typeList.get(i).getMin()) && (number < typeList.get(i).getMax())) {
                typeList.add(typeList.get(i));
            }
        }
  */      return types;
    }
}
