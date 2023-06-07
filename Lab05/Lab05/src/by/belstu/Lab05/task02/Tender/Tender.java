package by.belstu.Lab05.task02.Tender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CyclicBarrier;

public class Tender {

    private ArrayList<Seller> asks;
    private CyclicBarrier barrier;
    public final int SELLERS_NUMBER = 5;

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public Tender() {
        asks = new ArrayList<>();
        barrier = new CyclicBarrier(SELLERS_NUMBER, new Runnable() {
            @Override
            public void run() {
                Seller winner = defineWinner();
                System.out.println("Участник #" + winner.getIdSeller() + " победил, цена: " + winner.getPrice());
            }
        });
    }
    public Seller defineWinner() {
        return Collections.min(asks, new Comparator<Seller>() {
            @Override
            public int compare(Seller o1, Seller o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }
    public void addSeller(Seller ask) {
        asks.add(ask);
    }
}

