package task6.builder;

public class CarDirector {
    public void constructSportCar(Builder builder){
        builder.buildColor("Red");
        builder.buildEngine("600hp");
        builder.buildName("BMW");
    }
    public void constructCityCar(Builder builder){
        builder.buildColor("White");
        builder.buildEngine("120hp");
        builder.buildName("Hyundai");
    }
}
