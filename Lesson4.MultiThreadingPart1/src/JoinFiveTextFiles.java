/*
3. Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
 */

import java.io.*;

public class JoinFiveTextFiles {
    public static void main(String[] args) {
        File fileResult = new File("txt-files/task3.result.txt");

        try {
            fileResult.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 5; i++) {
            String strFilePath = String.format("txt-files/task3.text%d.txt", i);
            try {
                FileOutputStream fos = new FileOutputStream(fileResult, i!=1);
                byte[] byteArray = readFile(strFilePath);
                fos.write(byteArray);
                fos.close();
            } catch (FileNotFoundException ex) {
                System.out.println("FileNotFoundException : " + ex);
            } catch (IOException ioe) {
                System.out.println("IOException : " + ioe);
            }
        }
    }

    public static byte[] readFile(String filename){
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
