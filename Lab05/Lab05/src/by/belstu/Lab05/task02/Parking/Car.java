package by.belstu.Lab05.task02.Parking;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Car extends Thread {
    private final Semaphore slot;
    private final Parking parking;
    private final int id;

    public Car(Parking parking, Semaphore slot, int id) {
        this.parking = parking;
        this.slot = slot;
        this.id = id;
    }

    private void parking() {
        System.out.println("Машина №" + id + " припаркована на стоянке №" + parking.getParkingId());
    }

    private void leaving() {
        System.out.println("Машина №" + id + " уехала со стоянки №" + parking.getParkingId());
    }

    @Override
    public void run() {
        try {
            slot.acquire();
            parking();
            Thread.sleep(new Random().nextInt(300) + 300);
            slot.release();
            leaving();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
