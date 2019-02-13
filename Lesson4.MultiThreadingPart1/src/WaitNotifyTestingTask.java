/*
 * Основная часть ДЗ:
 * 1. Создать три потока,
 * каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
 * Используйте wait/notify/notifyAll.
 */

public class WaitNotifyTestingTask {
    static Character A = 'A';
    static Character B = 'B';
    static Character C = 'C';
    static final int COUNTS = 25;

    public static void main(String[] args) {
        PrintLetterThread threadA = new PrintLetterThread(A,B,);
        PrintLetterThread threadB = new PrintLetterThread(B,A);
//        PrintLetterThread threadC = new PrintLetterThread(C,A);

        threadA.start();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        threadC.start();
    }
}

class PrintLetterThread extends Thread{
    private final int COUNTS = 5;
    private Character cPrint;
    private Character cNotify;
    private Character cWait;

    public PrintLetterThread(Character print, Character wait, Character notify){
        super();
        cPrint = print;
        cNotify = notify;
        cWait = wait;
    }

    @Override
    public void run() {
        super.run();

        for (int i = 0; i < COUNTS; i++) {
            System.out.println(i + "  " + cPrint);

            synchronized (cNotify){
                System.out.println(this.getName() +": entered in notify blok. Synchronized letter: " + cNotify);
                cNotify.notify();
            }
            synchronized (cPrint) {
                try {
                    System.out.println(this.getName() + ": wait blok. Synchronized letter: " + cPrint);
                    cPrint.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}