package task8.templatemethod;

public abstract class Car {
    abstract void startEngine();
    abstract void turnOffEngine();
    public final void start(){
        startEngine();
        turnOffEngine();
    }
}
