package task6.builder;

public class Car {
    private String color;
    private String engine;
    private String name;

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return color + " " + name + " with " + engine;
    }
}
