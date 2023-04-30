package task6.factorymethod;

public class PlaneCreator extends Creator{
    @Override
    public Product factoryMethod() {
        return new Plane();
    }
}
