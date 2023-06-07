package by.belstu.Lab05.task02.Tender;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Seller extends Thread {
    private int idSeller;
    private int price;
    private CyclicBarrier barrier;

    public Seller(int idSeller, CyclicBarrier barrier) {
        this.idSeller = idSeller;
        this.barrier = barrier;
    }

    public int getIdSeller() {
        return idSeller;
    }
    public int getPrice() {
        return price;
    }

    @Override
    public void run() {
        try {
            price = new Random().nextInt(100) + 50;
            System.out.println("Участник " + this.getIdSeller() + " определил цену: " + price);

            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
