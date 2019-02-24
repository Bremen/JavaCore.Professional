import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore semaphore;

    /**
     * Конструктор туннеля
     * @param permittedCarsNumber - разрешенное количество машин для одновременного нахождения в туннеле
     */
    public Tunnel(int permittedCarsNumber) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        semaphore = new Semaphore(permittedCarsNumber);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
