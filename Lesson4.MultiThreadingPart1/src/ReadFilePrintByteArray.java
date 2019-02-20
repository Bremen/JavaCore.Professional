/*
2. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFilePrintByteArray {
    public static void main(String[] args) {
        File file = new File("txt-files/task2.txt");

        System.out.println("Размер файла: " + (int) file.length() + " байт.");

        byte[] b = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(b);
            for (int i = 0; i < b.length; i++) {
                System.out.print((char)b[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            e.printStackTrace();
        }
        catch (IOException e1) {
            System.out.println("Ошибка чтения файла.");
            e1.printStackTrace();
        }
    }
}
