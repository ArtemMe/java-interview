package draft.multithreading;

public class Test2 {
    public static void main(String[] args){
        CommonResource commonResource= new CommonResource();
        CommonResource2 commonResource2 = new CommonResource2();
        for (int i = 1; i < 6; i++){

            Thread t = new Thread(new CountThread(commonResource, commonResource2));
            t.setName("Thread "+ i);
            t.start();
        }
    }
}

class CommonResource{
    int x;
    synchronized void increment(){
        x=1;
        for (int i = 1; i < 5; i++){
            System.out.printf("%s %d \n", Thread.currentThread().getName(), x);
            x++;
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){}
        }
    }
}

class CommonResource2{
    int x;
    void increment(){
        x=1;
        for (int i = 1; i < 5; i++){
            System.out.printf("%s %d \n", Thread.currentThread().getName(), x);
            x++;
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){}
        }
    }
}

class CountThread implements Runnable{

    CommonResource res;
    CommonResource2 res2;

    CountThread(CommonResource res, CommonResource2 res2){
        this.res=res;
        this.res2=res2;
    }
    public void run(){
        res.increment();

//        synchronized (res2) {
//            res2.increment();
//        }
    }
}
