package patterns.facade;

public class DVD {
    public boolean isLoad = false;

    public void load(){
        isLoad = true;
        System.out.println("вставили диск");
    }
    public void unLoad(){
        isLoad = false;
        System.out.println("достали диск");
    }

}
