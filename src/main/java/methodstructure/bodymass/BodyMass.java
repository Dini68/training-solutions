package methodstructure.bodymass;

public class BodyMass {

    private double weight;

    private double height;

    public BodyMass(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double bodyMassIndex() {
        return weight / height / height;
    }

    public BmiCategory body() {
        if (bodyMassIndex() < 18.5) {
            return BmiCategory.UNDERWEIGHT;
        }
        if (bodyMassIndex() > 25) {
            return BmiCategory.OVERWEIGHT;
        }
        return BmiCategory.NORMAL;
    }

    public boolean isThinnerThan(BodyMass bodyMass) {
        return this.bodyMassIndex() < bodyMass.bodyMassIndex();
    }

    public static void main(String[] args) {
        BodyMass bodyMass = new BodyMass(93,1.83);
        System.out.println(bodyMass.bodyMassIndex());
        System.out.println(bodyMass.body());
    }
}
