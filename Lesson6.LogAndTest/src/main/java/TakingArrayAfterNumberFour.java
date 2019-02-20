/*
Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
иначе в методе необходимо выбросить RuntimeException. Написать набор тестов для этого метода
(по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 */

public class TakingArrayAfterNumberFour {

    /**
     * Метод возвращает массив, удущий после последней четверки в исходном массиве.
     * @param array -  не пустой одномерный целочисленный массив.
     * @return - новый массив, который получен путем вытаскивания из исходного массива элементов,
     * идущих после последней четверки.
     */
    public Integer[] takeArrayAfterNumberFour(Integer[] array) throws RuntimeException{
        if(array == null || array.length == 0){
            throw new RuntimeException("В переданный массив пустой.");
        }

        boolean hasFourNumber = false;
        int indexAfterLastFourNumber = -1;

        for (int i = array.length - 1; i >= 0; i--) {
            if(array[i] == 4){
                hasFourNumber = true;
                indexAfterLastFourNumber = ++i; //Увеличиваем на единицу чтобы перейти к предыдущему элементу
                break;
            }
        }

        if(!hasFourNumber){
            throw new RuntimeException("В переданном массиве нет ни одной четверки.");
        }

        Integer[] result = new Integer[array.length - indexAfterLastFourNumber];
        System.arraycopy(array, indexAfterLastFourNumber, result, 0, result.length);

        return result;
    }
}
