package patterns.factory;

public class EasyEnemyFactory implements IEnemyFactory {
    @Override
    public IEnemy createEnemy() {
        System.out.println("создал простого монстра");
        return new EasyEnemy();
    }
}
