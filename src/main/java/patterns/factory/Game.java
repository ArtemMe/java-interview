package patterns.factory;

public class Game {

    IEnemyFactory factory;

    public Game(IEnemyFactory factory) {
        this.factory = factory;
    }

    private static IEnemy[] enemies = new IEnemy[3];

    public void start(){
        System.out.println("Загрузка локации");
        System.out.println("Загрузка монстров");

        for (int i=0; i<enemies.length;i++){
            enemies[i] = factory.createEnemy();
            enemies[i].fight();
            enemies[i].walk();
        }


    }
}
