/*
3. Большая задача:
Есть классы Fruit -> Apple, Orange (больше фруктов не надо);
Класс Box, в который можно складывать фрукты.

Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
Для хранения фруктов внутри коробки можно использовать ArrayList;

Сделать метод getWeight(), который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
(вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);

Внутри класса Коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
которую подадут в compare в качестве параметра, true – если она равны по весу, false – в противном случае
(коробки с яблоками мы можем сравнивать с коробками с апельсинами);

Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую
(помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами).
Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;

Не забываем про метод добавления фрукта в коробку.
 */
package fruitBox;

import java.util.ArrayList;
import java.util.Arrays;

public class FruitBoxTest {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        ArrayList<Apple> apples = new ArrayList<>(Arrays.asList(new Apple(1.2), new Apple(1.1)));
        appleBox.addFruitAll(apples);

        FruitBox<Apple> appleBox2 = new FruitBox<>();
        ArrayList<Apple> apples2 = new ArrayList<>(Arrays.asList(new Apple(1.3), new Apple(1.0)));
        appleBox2.addFruitAll(apples2);

        FruitBox<Orange> orangeBox = new FruitBox<>();
        ArrayList<Orange> oranges = new ArrayList<>(Arrays.asList(new Orange(2.3), new Orange(2.3)));
        orangeBox.addFruitAll(oranges);

        System.out.println("Weight appleBox: " + appleBox.getWeight());
        System.out.println("Weight appleBox2: " + appleBox2.getWeight());
        appleBox.pourFruit(appleBox2); //Пересыпаем яблоки из одной коробки в другую
        System.out.println("After pouring:");
        System.out.println("Weight appleBox: " + appleBox.getWeight());
        System.out.println("Weight appleBox2: " + appleBox2.getWeight());

        boolean isBoxesWeightEqual = appleBox.compare(orangeBox);
        System.out.println("compare boxes with apples and oranges: " + isBoxesWeightEqual);

        //ВОПРОС!!!
        //boolean isBoxesWeightEqual = appleBox.compare(new FruitBox<>()); С каким типом коробка передастся в функцию?
    }

    //ВОПРОС!!
    //Метод описывающий ситацию по которой следующий вопрос: можно ли как-то сделать так,
    // чтобы коробка с фруктами определялась только потомками класса Fruit? И вообще нужно ли это?
    public static void questoin(){
        FruitBox<Fruit> appleBox = new FruitBox<>();
        ArrayList<Fruit> apples = new ArrayList<>(Arrays.asList(new Apple(1.2), new Orange(1.1)));
        appleBox.addFruitAll(apples);

        FruitBox<Fruit> appleBox2 = new FruitBox<>();
        ArrayList<Fruit> apples2 = new ArrayList<>(Arrays.asList(new Orange(1.3), new Apple(1.0)));
        appleBox2.addFruitAll(apples2);

        FruitBox<Orange> orangeBox = new FruitBox<>();
        ArrayList<Orange> oranges = new ArrayList<>(Arrays.asList(new Orange(2.3), new Orange(2.3)));
        orangeBox.addFruitAll(oranges);

        System.out.println("Weight appleBox: " + appleBox.getWeight());
        System.out.println("Weight appleBox2: " + appleBox2.getWeight());
        appleBox.pourFruit(appleBox2); //Пересыпаем яблоки из одной коробки в другую
        System.out.println("After pouring:");
        System.out.println("Weight appleBox: " + appleBox.getWeight());
        System.out.println("Weight appleBox2: " + appleBox2.getWeight());

        boolean isBoxesWeightEqual = appleBox.compare(orangeBox);
        System.out.println("compare boxes with apples and oranges: " + isBoxesWeightEqual);
    }
}
