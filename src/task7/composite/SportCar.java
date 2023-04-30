package task7.composite;

public class SportCar implements Car{

    @Override
    public void paint(String color) {
        System.out.println("SportCar color: " + color);
    }
}
