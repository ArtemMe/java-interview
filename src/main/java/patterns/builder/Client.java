package patterns.builder;

public class Client {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .createMark("lada")
                .createSpeed(100)
                .createWheel(4)
                .build();

    }
}
