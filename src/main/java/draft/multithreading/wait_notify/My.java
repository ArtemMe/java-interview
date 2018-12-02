package draft.multithreading.wait_notify;

import patterns.facade.ComputerFacade;

public class My {
    public static void main(String[] args) {
        Common common = new Common();
        Thread t1 = new Thread(new Thread1(common));
        Thread t2 = new Thread(new Thread2(common));
        Thread t3 = new Thread(new Thread3(common));

        t1.start();
        t3.start();

        t2.start();
    }
}

class Common{
    int x;
    public synchronized void get() throws InterruptedException {
        wait();
        System.out.println("get");
    }

    public synchronized void put() throws InterruptedException {
        System.out.println("put");
        notify();
    }
}

class Thread3 implements Runnable{
    Common common;
    public Thread3(Common common) {
        this.common = common;
    }

    @Override
    public void run() {
        try {
            common.get();
            System.out.println("thread3 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread1 implements Runnable{
    Common common;
    public Thread1(Common common) {
        this.common = common;
    }

    @Override
    public void run() {
        try {
            //Thread.sleep(1000);
            common.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread2 implements Runnable{
    Common common;
    public Thread2(Common common) {
        this.common = common;
    }
    @Override
    public void run() {
        try {
            common.put();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
