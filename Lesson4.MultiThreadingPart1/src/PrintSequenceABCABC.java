/*
 * Основная часть ДЗ:
 * 1. Создать три потока,
 * каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
 * Используйте wait/notify/notifyAll.
 */

public class PrintSequenceABCABC {
    static Character A = 'A';
    static Character B = 'B';
    static Character C = 'C';

    public static void main(String[] args) {
        PrintLetterThread threadA = new PrintLetterThread(A,B,C);
        PrintLetterThread threadB = new PrintLetterThread(B,C,A);
        PrintLetterThread threadC = new PrintLetterThread(C,A,B);

        threadA.start();
        try {
            Thread.sleep(100); // необходимая задержка гарантирующая вывод буквы А первой
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
        try {
            Thread.sleep(100); // необходимая задержка гарантирующая вывод буквы В второй
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadC.start();
    }
}

/**
 * Класс предназначен для печати одной буквы COUNT раз в синхронизации с другими буквами в последовательности
 */
class PrintLetterThread extends Thread{
    private static final int COUNTS = 5; //Количество повторений последовательности букв
    private Character cPrint;  //Буква печати в текущем объекте
    private Character cNotify; //Буква синхронизации. Предыдущая в последовательности перед предыдущей
    private Character cWait;   //Буква синхронизации. Следующая в последовательности за текущей

    /**
     * Конструктор потока. Все параметры обязательны.
     * @param print - определяет букву, печатуемую в данном потоке
     * @param wait - следующая буква в последовательности
     * @param notify - предыдущая буква в последовательности
     */
    public PrintLetterThread(Character print, Character wait, Character notify){
        super();
        cPrint = print;
        cNotify = notify;
        cWait = wait;
    }

    @Override
    public void run() {
        super.run();

        //цикл повторения печати буквы
        for (int i = 0; i < COUNTS; i++) {
            System.out.print(cPrint); //печать буквы в последовательности при закрытых выводах сообщений
//            System.out.println(i + "  " + cPrint); //печать буквы в последовательности при открытых выводах сообщений

//            System.out.println(getName() + ": Ждем возможности зайти в блок синхронизации буквы - " + cWait);
            synchronized (cWait) {
//                System.out.println(getName() + ": Ждем возможности зайти в блок синхронизации буквы - " + cNotify);
                synchronized (cNotify){
//                    System.out.println(getName() + ": Уведомляем блок ожидания буквы - " + cNotify);
                    cNotify.notify();
                }

                try {
//                    System.out.println(getName() + ": Переход в ожидание блок буквы - " + cWait);
                    cWait.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}