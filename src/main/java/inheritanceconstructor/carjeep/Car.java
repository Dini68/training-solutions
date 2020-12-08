package inheritanceconstructor.carjeep;

public class Car {

    private double fuelRate;

    private double fuel;

    private double tankCapacity;

    public double getFuelRate() {
        return fuelRate;
    }

    public double getFuel() {
        return fuel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public Car(double fuelRate, double fuel, double tankCapacity) {
        if (fuel > tankCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }
    public void modifyFuelAmount(double fuel) {
        this.fuel += fuel;
    }
    public void drive(int km) {
        fuel -= km * fuelRate / 100;
    }
    public double calculateRefillAmount() {
        return tankCapacity - fuel;
    }
}
