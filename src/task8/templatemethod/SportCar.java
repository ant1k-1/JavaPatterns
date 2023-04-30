package task8.templatemethod;

public class SportCar extends Car{
    @Override
    void startEngine() {
        System.out.println("SportCar start engine");
    }

    @Override
    void turnOffEngine() {
        System.out.println("SportCar stop engine");
    }
}
