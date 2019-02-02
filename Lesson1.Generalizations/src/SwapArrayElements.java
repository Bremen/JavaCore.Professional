/* Основное домашнее задание.
1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
 */

/**
 * Класс демонстрирующий работу функции замены элементов в массиве с использованием обобщения
 */
public class SwapArrayElements {

    /**
     * Функция меняющая местами два задаваемых элемента массива с соответствующими индексами
     * @param array - массив в котором происходит замена
     * @param firstElementIndex - индекс первого элемента для обмена
     * @param secondElementIndex - индекс второго элемента для обмена
     * @param <T> - тип элементов передаваемого массива
     */
    public static <T> void  swapElements(T[] array, int firstElementIndex, int secondElementIndex){
        T buffer = array[firstElementIndex];
        array[firstElementIndex] = array[secondElementIndex];
        array[secondElementIndex] = buffer;
    }

    /**
     * Метод распечатывающий содерщимое массива в консоль в строчку
     * @param array - передаваемый массив для распечатки
     * @param <T> - тип элементов передаваемого массива (обобщение)
     */
    public static <T> void printArray(T[] array){
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * Запуск тестового примера
     * @param args
     */
    public static void main(String[] args) {
        //Тестируем массив с целочисленными
        Integer[] intArray = {1, 2, 3, 4, 5};
        printArray(intArray);
        swapElements(intArray, 0, 1);
        printArray(intArray);

        //Тестируем массив с десятичными числами
        Double[] doubleArray = {1.0, 2.0, 3.0, 4.0, 5.0};
        printArray(doubleArray);
        swapElements(doubleArray, 0, 1);
        printArray(doubleArray);

        //Тестируем массив со строками
        String[] stringArray = {"str1", "str2", "str3", "str4", "str5"};
        printArray(stringArray);
        swapElements(stringArray, 0, 1);
        printArray(stringArray);
    }
}
