package com.wjh.test;

class Window implements Runnable{

    //余票
    private int tickets = 100;

    @Override
    public void run() {
        while (true){
            synchronized (this){
                if (tickets > 0){
                    /*人为创造阻塞*/
                    try {
                        Thread.currentThread().sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "：卖出一张票，号码为：" + tickets);
                    tickets--;
                }else {
                    break;
                }
            }

        }

    }
}

public class TestTicketByRunnable {
    public static void main(String[] args) {
        Window window = new Window();
        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        Thread thread3 = new Thread(window);
        thread1.setName("一号窗口");
        thread2.setName("二号窗口");
        thread3.setName("三号窗口");
        //设置优先级
        /*thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);*/

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
