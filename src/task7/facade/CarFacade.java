package task7.facade;

public class CarFacade {
    public void getReadyCar(){
        Lock.unlock();
        Engine.start();
        ClimateControl.on();
    }
    public void turnOffCar(){
        Engine.stop();
        ClimateControl.off();
        Lock.lock();
    }
}
