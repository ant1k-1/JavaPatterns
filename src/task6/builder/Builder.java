package task6.builder;

public interface Builder {
    void buildEngine(String engine);
    void buildColor(String color);
    void buildName(String name);
    Car getResult();
}
