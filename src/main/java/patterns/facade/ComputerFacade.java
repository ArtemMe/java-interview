package patterns.facade;

public class ComputerFacade {
    Power power = new Power();
    HDD hdd = new HDD();
    DVD dvd = new DVD();

    public void copy(){
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}
