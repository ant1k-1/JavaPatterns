package task6.abstructfactory;

public class Application {
    public static void main(String[] args) {
        VehicleAbstractFactory electricVehicleFactory = new ElectricVehicleFactory();
        Car tesla = electricVehicleFactory.createCar();
        tesla.move();

        Plane electricPlane = electricVehicleFactory.createPlane();
        electricPlane.move();

        VehicleAbstractFactory classicVehicleFactory = new ClassicVehicleFactory();
        Car lada = classicVehicleFactory.createCar();
        lada.move();

        Plane airbus = classicVehicleFactory.createPlane();
        airbus.move();

    }
}
