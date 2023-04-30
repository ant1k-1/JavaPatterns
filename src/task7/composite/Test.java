package task7.composite;

public class Test {
    public static void main(String[] args) {
        Car sportcar = new SportCar();
        Car citycar = new CityCar();
        CompositeCars compositeCars = new CompositeCars();
        compositeCars.add(sportcar);
        compositeCars.add(citycar);
        compositeCars.paint("white");
        compositeCars.remove(citycar);
        compositeCars.paint("black");
    }
}
