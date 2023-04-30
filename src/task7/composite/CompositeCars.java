package task7.composite;

import java.util.ArrayList;

public class CompositeCars implements Car{
    private ArrayList<Car> cars = new ArrayList<>();
    @Override
    public void paint(String color) {
        for (Car car :
                cars) {
            car.paint(color);
        }
    }
    public void add(Car car){
        cars.add(car);
    }
    public void remove(Car car){
        cars.remove(car);
    }

    public Car getCar(int index){
        return cars.get(index);
    }
}
