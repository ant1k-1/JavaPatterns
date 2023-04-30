package task7.facade;

public class Test {
    public static void main(String[] args) {
        CarFacade carFacade = new CarFacade();
        carFacade.getReadyCar();
        System.out.println("");
        carFacade.turnOffCar();
    }
}
