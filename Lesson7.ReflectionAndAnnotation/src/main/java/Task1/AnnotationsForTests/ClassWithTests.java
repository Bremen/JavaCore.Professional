package Task1.AnnotationsForTests;

import Task1.AnnotationsForTests.annotations.AfterSuite;
import Task1.AnnotationsForTests.annotations.BeforeSuite;
import Task1.AnnotationsForTests.annotations.Test;

public class ClassWithTests {
    @Test(priority = 10)
    static void test1(){
        System.out.println("Запущен тест 1. С приоритетом 10.");
    }
    @Test(priority = 8)
    static void test2(){
        System.out.println("Запущен тест 2. С приоритетом 8.");
    }
    @Test(priority = 9)
    static void test3(){
        System.out.println("Запущен тест 3. С приоритетом 9.");
    }
    @Test(priority = 7)
    static void test4(){
        System.out.println("Запущен тест 4. С приоритетом 7.");
    }
    @Test(priority = 4)
    static void test5(){
        System.out.println("Запущен тест 5. С приоритетом 4.");
    }
    @Test(priority = 5)
    static void test6(){
        System.out.println("Запущен тест 6. С приоритетом 5.");
    }
    @Test(priority = 7)
    static void test7(){
        System.out.println("Запущен тест 7. С приоритетом 7.");
    }
    @Test(priority = 5)
    static void test8(){
        System.out.println("Запущен тест 8. С приоритетом 5.");
    }
    @Test(priority = 1)
    static void test9(){
        System.out.println("Запущен тест 9. С приоритетом 1.");
    }
    @Test(priority = 7)
    static void test10(){
        System.out.println("Запущен тест 10. С приоритетом 7.");
    }

    static void notTest(){
        System.out.println("Сообщение из метода не являющегося тестом.");
    }

    @AfterSuite
    static void finish(){
        System.out.println("Завершающие операции тестов из блока с аннотацией @AfterSuit");
    }

//    @AfterSuite
//    static void finish2(){
//        System.out.println("Завершающие операции тестов из блока с аннотацией @AfterSuit");
//    }

    @BeforeSuite
    static void init(){
        System.out.println("Инициализация из метода с аннотацией @BeforeSuite");
    }

//    @BeforeSuite
//    static void init2(){
//        System.out.println("Инициализация из метода с аннотацией @BeforeSuite");
//    }
}
