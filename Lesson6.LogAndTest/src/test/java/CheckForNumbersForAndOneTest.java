/*
Написать метод, который проверяет состав массива из чисел 1 и 4.
Если в нем нет хоть одной четверки или единицы, то метод вернет false;
Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 */

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckForNumbersForAndOneTest {
    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
                { new Integer[]{1, 2, 3, 4}, true },
                { new Integer[]{1, 2, 3, 5}, true },
                { new Integer[]{0, 2, 3, 4}, true },
                { new Integer[]{4, 2, 3, 4}, true },
                { new Integer[]{1,4}, true },
                { new Integer[]{4,1}, true },
                { new Integer[]{1,1}, true },
                { new Integer[]{4,4}, true },
                { new Integer[]{}, false },
                { new Integer[]{5, 6, 7, 8}, false}
        });
    }

    private int[] in;
    private boolean isThereNumbers;

    public CheckForNumbersForAndOneTest(Integer[] in_array, Boolean isThereNumbers) {
        this.in = Arrays.stream(in_array).mapToInt(Integer::intValue).toArray();
        this.isThereNumbers = isThereNumbers;
    }

    @Test
    public void correctDataTet() {
        System.out.println("array: " + Arrays.toString(in));
        Assert.assertEquals(isThereNumbers, СheckForNumbersFourAndOne.checkForNumbersFourAndOne(in));
        System.out.println("check: " + isThereNumbers);
    }
}
