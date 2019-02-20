/*
Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
иначе в методе необходимо выбросить RuntimeException. Написать набор тестов для этого метода
(по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayAlterLastFourNumberTest {
    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Integer[][][] {
                {{1,4,1,2}, {1,2}},   // четверка в серидине
                {{4,2,2,2}, {2,2,2}}, // четверка в начале
                {{1,2,3,4}, {}} // четверка в конце
        });
    }

    private Integer[] in;
    private Integer[] out;

    public ArrayAlterLastFourNumberTest(Integer[] in, Integer[] out) {
        this.in = in;
        this.out = out;
    }

    TakingArrayAfterNumberFour takingArray;

    @Before
    public void init() {
        System.out.println("init");
        takingArray = new TakingArrayAfterNumberFour();
    }

    @Test
    public void correctDataTet() {
        System.out.println("in: " + Arrays.toString(in));
        Assert.assertEquals(out, takingArray.takeArrayAfterNumberFour(in));
        System.out.println("out: " + Arrays.toString(out));
    }

    @Test(expected = RuntimeException.class)
    public void emptyArrayTest() {
        Integer[] in = {};
        System.out.println("in: " + Arrays.toString(in));
        Assert.assertEquals(out, takingArray.takeArrayAfterNumberFour(in));
    }

    @Test(expected = RuntimeException.class)
    public void nullArrayTest() {
        Integer[] in = null;
        System.out.println("in: " + Arrays.toString(in));
        Assert.assertEquals(out, takingArray.takeArrayAfterNumberFour(in));
    }

    @Test(expected = RuntimeException.class)
    public void arrayWithoutFour() {
        Integer[] in = {1,2,3,5,6};
        System.out.println("in: " + Arrays.toString(in));
        Assert.assertEquals(out, takingArray.takeArrayAfterNumberFour(in));
    }
}
