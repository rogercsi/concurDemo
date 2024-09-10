package org.example;

public class P12APrinter {
    private int num = 1;
    private char c = 'A';
    private int flag = 0;
    public synchronized void printNum() {
        while (num <= 52) {
            while (flag != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            flag = 1;
            System.out.print(num++);
            System.out.print(num++);
            notify();
        }
    }

    public synchronized void printChar() {
        while (c <= 'Z') {
            while (flag != 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            flag = 0;
            System.out.print(c++);
            notify();
        }
    }

    public static void main(String[] args) {
        P12APrinter p12APrinter = new P12APrinter();
        new Thread(p12APrinter::printNum).start();
        new Thread(p12APrinter::printChar).start();
        System.out.printf("main");
    }
}
