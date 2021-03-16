package com.xpcf.test2;

/**
 * @author XPCF
 * @version 1.0
 * @date 3/17/2021 12:42 AM
 */
public class Service {

    public static void main(String[] args) throws InterruptedException {
        Service service=new Service();
        ThreadA threadA=new ThreadA(service);
        threadA.start();
        Thread.sleep(1000);
        ThreadB threadB=new ThreadB(service);
        threadB.start();
        System.out.println("命令已经停止");
    }

    //private boolean isContinueRun=true;
    private boolean isContinueRun=true;  //使用volatile体现出可见性
    public void runMethod(){
        while (isContinueRun==true){}
        System.out.println("停止下来");
    }
    public void stopMethod(){
        isContinueRun=false;
    }
}

class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.runMethod();
    }
}


class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.stopMethod();
    }
}
