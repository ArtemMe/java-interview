package patterns.factory;

public class HardEnemy implements IEnemy {
    @Override
    public void fight() {
        System.out.println("сложный враг дерется");
    }

    @Override
    public void walk() {
        System.out.println("сложный враг гуляет");
    }
}
