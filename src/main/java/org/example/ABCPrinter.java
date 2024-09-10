package org.example;

/**
 * 启动三个线程，id分别是ABC，分别打印id5遍，ABCABC...
 */
public class ABCPrinter {
    private int flag = 0;
    public synchronized void printA() {
        while (true) {
            while (flag != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.printf(Thread.currentThread().getName());
            flag = 1;
            notifyAll();
        }
    }

    public synchronized void printB() {
        while (true) {
            while (flag != 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.printf(Thread.currentThread().getName());
            flag = 2;
            notifyAll();
        }
    }

    public synchronized void printC() {
        while (true) {
            while (flag != 2) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.printf(Thread.currentThread().getName());
            flag = 0;
            notifyAll();
        }
    }
    public static void main(String[] args) {
        ABCPrinter printer = new ABCPrinter();
        Thread a = new Thread(printer::printA);
        a.setName("A");
        a.start();
        Thread b = new Thread(printer::printB);
        b.setName("B");
        b.start();
        Thread c = new Thread(printer::printC);
        c.setName("C");
        c.start();
    }
}
