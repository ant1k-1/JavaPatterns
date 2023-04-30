package task8.templatemethod;

public class CityCar extends Car{

    @Override
    void startEngine() {
        System.out.println("CityCar start engine");
    }

    @Override
    void turnOffEngine() {
        System.out.println("CityCar stop engine");
    }
}
