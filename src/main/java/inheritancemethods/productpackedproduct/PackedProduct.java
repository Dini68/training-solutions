package inheritancemethods.productpackedproduct;

import java.math.BigDecimal;

public class PackedProduct extends Product{

    private int packingUnit;

    private BigDecimal weightOfBox;

    public int getPackingUnit() {
        return packingUnit;
    }

    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }

    public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    @Override
    public BigDecimal totalWeight(int pieces) {
        return super.totalWeight(pieces).add(weightOfBox.multiply(BigDecimal.valueOf((pieces - 1) / packingUnit + 1))) ;
    }
}
