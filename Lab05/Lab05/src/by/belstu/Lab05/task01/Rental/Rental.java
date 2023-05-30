package by.belstu.Lab05.task01.Rental;

import static java.lang.Thread.currentThread;

public class Rental {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    private int product = 0;
    long start = System.currentTimeMillis();

    public void get(Client client) {
        System.out.println("Клиент подошел");
        synchronized (this) {
            while (product < 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            long end = start + 3000;

            try {
                if (System.currentTimeMillis() <= end) {
                    System.out.println("Клиент ждет");
                    currentThread().sleep(1000);
                    product--;
                    System.out.println(GREEN + "Клиент взял 1 лыжи" + RESET);
                    System.out.println("Лыж на складе: " + product);
                    notify();
                    return;
                }
                notify();
                System.out.println(RED + "Клиент ушел" + RESET);

            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }


    public void getRetiree(Retiree retiree) {
        System.out.println("Пенсионер подошел");

        synchronized (this) {
            while (product < 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }
            try {
                retiree.sleep(500);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }

            product--;
            System.out.println(BLUE + "Пенсионер взял 1 лыжи" + RESET);
            System.out.println("Лыж на складе: " + product);
            notify();
        }
    }


    public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Работник добавил 1 пару лыж");
        System.out.println("Лыж на складе: " + product);
        notify();
    }

}
