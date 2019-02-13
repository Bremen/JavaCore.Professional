/*
4. Написать консольное приложение, которое умеет постранично читать текстовые файлы
(размером > 10 mb). Вводим страницу (за страницу можно принять 1800 символов), программа
выводит ее в консоль. Контролируем время выполнения: программа не должна загружаться
дольше 10 секунд, а чтение – занимать свыше 5 секунд.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadingBigFileAndPaginatedOutput {
    static final int PAGE_SYMBOLS_COUNT = 1800;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int pageNum;

        byte[] byteArray = readFile("txt-files/task4.txt");
        int pageCount = byteArray.length/PAGE_SYMBOLS_COUNT + 1;

        do{
            System.out.println("Для выхода введите 0 или отрицательное целое число.");
            System.out.println(String.format("Введите номер страницы для вывода в консоль, max %d: ", pageCount));
            pageNum = sc.nextInt();

            if (pageNum < 1 || pageNum > pageCount){
                System.out.println("Введен не корректный номер страницы. Программа завершается.");
                break;
            }

            System.out.println(String.format("Вывод страницы %d:", pageNum));
            int firstSymbol = (pageNum - 1)*PAGE_SYMBOLS_COUNT;
            for (int i = firstSymbol; i < firstSymbol+PAGE_SYMBOLS_COUNT && i < byteArray.length; i++) {
                System.out.print((char)byteArray[i]);
            }
            System.out.println("\n");
        }while(true);
    }

    static byte[] readFile(String filename){
        File file = new File(filename);

        System.out.println("Размер файла " + filename + ": " + (int) file.length() + " байт.");

        byte[] b = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(b);
        } catch (
                FileNotFoundException e) {
            System.out.println("Файл " + filename + " не найден.");
            e.printStackTrace();
        }
        catch (
                IOException e1) {
            System.out.println("Ошибка чтения файла. " + filename);
            e1.printStackTrace();
        }

        return b;
    }
}
