package task6.builder;

public class CarBuilder implements Builder{
    Car car = new Car();
    @Override
    public void buildEngine(String engine) {
        car.setEngine(engine);
    }

    @Override
    public void buildColor(String color) {
        car.setColor(color);
    }

    @Override
    public void buildName(String name) {
        car.setName(name);
    }

    @Override
    public Car getResult() {
        return car;
    }
}
