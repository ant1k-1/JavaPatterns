package task6.builder;

public class Application {
    public static void main(String[] args) {
        CarDirector director = new CarDirector();
        Builder builder = new CarBuilder();
        director.constructCityCar(builder);
        Car car = builder.getResult();
        System.out.println(car);
    }
}
