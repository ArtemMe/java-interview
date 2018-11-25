package patterns.facade;

/**
 * Урезает инерфаейс упрощает сложную систему.
 *
 * */

public class Client {
    public static void main(String[] args) {
//        т.е клиент вместо вот этого
//        Power power = new Power();
//        HDD hdd = new HDD();
//        DVD dvd = new DVD();
//        hdd.copyFromDVD(dvd);

//        пишет вот это
        ComputerFacade facade = new ComputerFacade();
        facade.copy();
    }
}
