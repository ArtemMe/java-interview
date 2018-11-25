package patterns.facade;

public class HDD {
    public void copyFromDVD(DVD dvd){
        if(dvd.isLoad)
            System.out.println("диск занят");
        else
            System.out.println("копируем данные");
    }
}
