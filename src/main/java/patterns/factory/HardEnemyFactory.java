package patterns.factory;

public class HardEnemyFactory implements IEnemyFactory {
    @Override
    public IEnemy createEnemy() {
        System.out.println("создал сложного монстра");
        return new HardEnemy();
    }
}
