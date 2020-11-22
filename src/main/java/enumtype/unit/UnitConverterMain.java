package enumtype.unit;

import java.math.BigDecimal;

public class UnitConverterMain {

    public static void main(String[] args) {

        UnitConverter unitConverter = new UnitConverter();
        System.out.println(unitConverter.convert(BigDecimal.valueOf(100), LengthUnit.INCH, LengthUnit.CENTIMETER));
    }
}
