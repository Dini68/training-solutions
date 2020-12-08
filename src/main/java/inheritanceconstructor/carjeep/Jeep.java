package inheritanceconstructor.carjeep;

public class Jeep extends Car{

    private double extraCapacity;

    private double extraFuel;

    public double getExtraCapacity() {
        return extraCapacity;
    }

    public double getExtraFuel() {
        return extraFuel;
    }

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        if (fuel > tankCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    @Override
    public void modifyFuelAmount(double fuel) {
        super.modifyFuelAmount(fuel);
    }

    @Override
    public void drive(int km) {
        super.drive(km);
    }

    @Override
    public double calculateRefillAmount() {
        return super.calculateRefillAmount() + extraFuel + extraCapacity;
    }
}
