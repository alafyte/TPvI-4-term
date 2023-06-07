package by.belstu.Lab05.task02.Airport;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Airport {
    private Semaphore terminalsSemaphore;
    private Semaphore trapesSemaphore;
    private CyclicBarrier boardingBarrier;

    public Airport(int capacity, int numTerminals, int numTrapes) {
        terminalsSemaphore = new Semaphore(numTerminals);
        trapesSemaphore = new Semaphore(numTrapes);
        boardingBarrier = new CyclicBarrier(capacity);
    }
    public void boardingPassenger(int planeId, int passengerId) throws InterruptedException {
        System.out.println("Пассажир " + passengerId + " подошел");

        terminalsSemaphore.acquire();
        System.out.println("Пассажир " + passengerId + " вошел в терминал ");
        terminalsSemaphore.release();


        trapesSemaphore.acquire();
        System.out.println("Пассажир " + passengerId + " вошел на трап к самолету " + planeId);
        trapesSemaphore.release();

        Thread.sleep(1000);

        try {
            boardingBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("Пассажир " + passengerId + " сел в самолет " + planeId);

    }
}
