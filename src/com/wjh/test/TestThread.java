package com.wjh.test;

class MyThread extends Thread {
    @Override
    public void run() {
        this.setName("线程一");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}


public class TestThread {
    public static void main(String[] args) {
//        MyThread myThread1 = new MyThread();
//        myThread1.start();

//        new Thread(){
//            @Override
//            public void run() {
//                this.setName("线程二");
//                for (int i = 0; i < 100; i++) {
//                    if (i % 10 == 0) {
//                        System.out.println(Thread.currentThread().getName() + ":" + i);
//                    }
//
//                    if (i == 50) {
//                        try {
//                            myThread1.join();
//                            System.out.println(myThread1.isAlive());
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//
//            }
//        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 10; i > 0; i--) {
                    System.out.println(i);
                    try {
                        this.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("新年快乐！");
            }
        }.start();

    }

}


