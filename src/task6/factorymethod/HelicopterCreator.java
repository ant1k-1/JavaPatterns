package task6.factorymethod;

public class HelicopterCreator extends Creator {

    @Override
    public Product factoryMethod() {
        return new Helicopter();
    }
}
