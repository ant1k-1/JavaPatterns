package task6.abstructfactory;

public class ElectricVehicleFactory implements VehicleAbstractFactory{

    @Override
    public Plane createPlane() {
        return new ElectricPlane();
    }

    @Override
    public Car createCar() {
        return new ElectricCar();
    }
}
