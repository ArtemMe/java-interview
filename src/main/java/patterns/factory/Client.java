package patterns.factory;

/**
 * Это скорее всего абстрактная фабрика потому что мы создаем семейство фабрик
 *
 * */


public class Client {
    public static void main(String[] args) {
        //выбор игрока какой уровень сложности нужен
        IEnemyFactory enemyFactory = new EasyEnemyFactory();
//        IEnemyFactory enemyFactory = new HardEnemyFactory();

        Game game = new Game(enemyFactory);
        game.start();
    }
}
