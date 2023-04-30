package task8.templatemethod;

public class Test {
    public static void main(String[] args) {
        Car sportCar = new SportCar();
        Car cityCar = new CityCar();
        cityCar.start();
        System.out.println();
        sportCar.start();
    }
}
