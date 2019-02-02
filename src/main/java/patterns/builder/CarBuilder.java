package patterns.builder;

public class CarBuilder {
    private String mark;
    private int wheel;
    private int speed;

    public CarBuilder createMark(String mark){
        this.mark = mark;
        return this;
    }
    public CarBuilder createWheel(int wheel){
        this.wheel = wheel;
        return this;
    }
    public CarBuilder createSpeed(int speed){
        this.speed = speed;
        return this;
    }

    public Car build(){
        Car car = new Car();
        car.setMark(mark);
        car.setSpeed(speed);
        car.setWheel(wheel);
        return car;
    }
}
