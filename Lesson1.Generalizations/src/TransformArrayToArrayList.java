/* Основное домашнее задание
2. Написать метод, который преобразует массив в ArrayList;
 */

import java.util.ArrayList;

public class TransformArrayToArrayList {
    /**
     * Метод преобразующий массив в ArrayList
     * @param array - массив который нужно преобразовать
     * @param <T> - обобщенный тип элементов массива
     * @return - объект типа ArrayList полученный после преобразования
     */
    public static <T> ArrayList<T> transformArrayToArrayList(T[] array){
        ArrayList<T> arrayList = new ArrayList<>();
        for (T element : array) {
            arrayList.add(element);
        }
        return  arrayList;
    }

    /**
     * Метод распечатывающий содерщимое массива в консоль в строчку
     * @param array - передаваемый массив для распечатки
     * @param <T> - тип элементов передаваемого массива (обобщение)
     */
    public static <T> void printArray(ArrayList<T> array){
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //Тестируем массив с целочисленным массивом
        Integer[] intArray = {1, 2, 3, 4, 5};
        ArrayList<Integer> intArrayList = transformArrayToArrayList(intArray);
        printArray(intArrayList);

        //Тестируем массив с массивом с десятичными числами
        Double[] doubleArray = {1.0, 2.0, 3.0, 4.0, 5.0};
        ArrayList<Double> doubleArrayList =transformArrayToArrayList(doubleArray);
        printArray(doubleArrayList);

        //Тестируем массив с массивом строк
        String[] stringArray = {"str1", "str2", "str3", "str4", "str5"};
        ArrayList<String> stringArrayList =transformArrayToArrayList(stringArray);
        printArray(stringArrayList);
    }
}
