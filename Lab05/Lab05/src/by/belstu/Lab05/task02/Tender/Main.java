package by.belstu.Lab05.task02.Tender;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Tender tender = new Tender();

        for (int i = 1; i <= tender.SELLERS_NUMBER; i++) {
            Seller thread = new Seller(i, tender.getBarrier());
            tender.addSeller(thread);
            thread.start();
            Thread.sleep(new Random().nextInt(1000) + 2000);
        }
    }
}
