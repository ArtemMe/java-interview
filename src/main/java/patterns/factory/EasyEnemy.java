package patterns.factory;

public class EasyEnemy implements IEnemy {
    @Override
    public void fight() {
        System.out.println("enemy fighting");
    }

    @Override
    public void walk() {
        System.out.println("enemy walking");
    }
}
