package task6.factorymethod;

public class Test {
    public static void main(String[] args) {
        Creator creator = new HelicopterCreator();
        Product helicopter = creator.factoryMethod();
        helicopter.foo();

        Creator creator1 = new PlaneCreator();
        Product plane = creator1.factoryMethod();
        plane.foo();
    }
}
