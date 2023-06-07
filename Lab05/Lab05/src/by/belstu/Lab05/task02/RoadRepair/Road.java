package by.belstu.Lab05.task02.RoadRepair;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Road {
    private Semaphore semaphore = new Semaphore(3);
    private AtomicInteger carsOnRoad = new AtomicInteger(0);
    private boolean carsOnOppositeDirection;

    public void carArrived(int carId, Direction direction) throws InterruptedException {
        System.out.println("Машина " + carId + " прибыла, движется в направлении " + direction);
        carsOnOppositeDirection = carsOnRoad.get() > 0 &&
                (direction == Direction.LEFT && carsOnRoad.get() % 2 == 1 || direction == Direction.RIGHT && carsOnRoad.get() % 2 == 0);
        while (carsOnOppositeDirection) {
            Thread.sleep(100);
        }
        semaphore.acquire();
        carsOnRoad.incrementAndGet();
        System.out.println("Машина " + carId + " проезжает в направлении " + direction);
        carsOnRoad.decrementAndGet();
        semaphore.release();
        carsOnOppositeDirection = carsOnRoad.get() > 0 &&
                (direction == Direction.LEFT && carsOnRoad.get() % 2 == 1 || direction == Direction.RIGHT && carsOnRoad.get() % 2 == 0);
    }
}