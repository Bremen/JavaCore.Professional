/*
Организуем гонки:
Все участники должны стартовать одновременно, несмотря на то, что на подготовку у каждого их них уходит разное время.
В тоннель не может заехать одновременно больше половины участников (условность).
Попробуйте все это синхронизировать.
Только после того, как все завершат гонку, нужно выдать объявление об окончании.
Можете корректировать классы (в т.ч. конструктор машин) и добавлять объекты классов из пакета util.concurrent.
 */

import java.util.concurrent.CountDownLatch;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT / 2), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        Car.cdStart  = new CountDownLatch(CARS_COUNT);
        Car.cdWin  = new CountDownLatch(1);
        Car.cdFinish = new CountDownLatch(CARS_COUNT);

        for (Car car : cars) {
            new Thread(car).start();
        }

        //Ждем пока все участники приготовятся и будут готовы стартовать
        try {
            Car.cdStart.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        //Ждем пока все участники финишируют
        try {
            Car.cdFinish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
