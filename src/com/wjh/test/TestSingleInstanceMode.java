package com.wjh.test;

class Bank {
    private Bank(){}

    private static Bank instance = null;

    public static Bank getInstance(){
        if (instance == null) {

            synchronized (Bank.class){
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}

public class TestSingleInstanceMode {
    public static void main(String[] args) {
        Bank instance1 = Bank.getInstance();
        Bank instance2 = Bank.getInstance();

        System.out.println(instance1);
        System.out.println(instance2);
    }
}
