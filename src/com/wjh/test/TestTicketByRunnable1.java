package com.wjh.test;

class Window1 implements Runnable {

    //余票
    int tickets = 100;

    @Override
    public void run() {
        while (true) {
            sellTicket();
            if (tickets == 0) {
                break;
            }
        }
    }

    public synchronized void sellTicket() {
        if (tickets > 0) {
            /*人为创造阻塞*/
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "：卖出一张票，号码为：" + tickets);
            tickets--;
        }
    }
}

public class TestTicketByRunnable1 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();

        Thread thread1 = new Thread(window1);
        Thread thread2 = new Thread(window1);
        Thread thread3 = new Thread(window1);
        thread1.setName("一号窗口");
        thread2.setName("二号窗口");
        thread3.setName("三号窗口");
        //设置优先级
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
