package com.wjh.test;

public class TestThread01{
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                this.setName("线程一");
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        try {
                            this.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }

//                    if (i % 20 == 0){
//                        this.yield();
//                    }

                }
            }
        }.start();


        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
