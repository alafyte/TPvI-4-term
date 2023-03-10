package by.belstu.Lab04.task02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Parking first_parking = new Parking(1, 4);
        Parking second_parking = new Parking(2, 5);
        Semaphore first = new Semaphore(first_parking.getSize(), true);
        Semaphore second = new Semaphore(second_parking.getSize(), true);
        ExecutorService service = Executors.newCachedThreadPool();

        for (int number = 1; number <= 30; ) {
            service.execute(new Car(first_parking, first, number++));
            service.execute(new Car(second_parking, second, number++));
        }

        service.shutdown();

    }
}
