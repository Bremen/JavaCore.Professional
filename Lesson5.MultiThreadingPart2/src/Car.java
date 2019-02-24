import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static int CARS_COUNT;
    public static CountDownLatch cdStart; //Задвижка для одновременного старта
    public static CountDownLatch cdWin ;  //Задвижка для первого финишировавшего
    public static CountDownLatch cdFinish;//Задвижка для завершения гонки
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }
        cdStart.countDown();
        try {
            cdStart.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        if (cdWin.getCount() > 0){ // Если еще не было финишировавшего, то объявляем победителя!
            cdWin.countDown();
            System.out.println(this.name + " WIN");
        }

        cdFinish.countDown();
    }
}
