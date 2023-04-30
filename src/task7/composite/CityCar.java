package task7.composite;

public class CityCar implements Car{
    @Override
    public void paint(String color) {
        System.out.println("CityCar color: " + color);
    }
}
