package task6.abstructfactory;

public class ClassicVehicleFactory implements VehicleAbstractFactory{
    @Override
    public Plane createPlane() {
        return new JetPlane();
    }

    @Override
    public Car createCar() {
        return new DvsCar();
    }
}
