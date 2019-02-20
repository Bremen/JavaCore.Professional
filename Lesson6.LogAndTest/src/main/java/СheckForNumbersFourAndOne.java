/*
Написать метод, который проверяет состав массива из чисел 1 и 4.
Если в нем нет хоть одной четверки или единицы, то метод вернет false;
Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 */

public class СheckForNumbersFourAndOne {
    /**
     * Метод проверяет наличие в массиве чисел 1 и 4
     * @param array - массив целлых чисел
     * @return - признак наличия чисел 1 и 4
     */
    public static boolean checkForNumbersFourAndOne(int[] array){
        for (int a : array) {
            if(a == 1 || a == 4){
                return true;
            }
        }
        return false;
    }
}
