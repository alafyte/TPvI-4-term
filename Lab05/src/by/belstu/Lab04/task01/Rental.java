package by.belstu.Lab04.task01;

import static java.lang.Thread.currentThread;

public class Rental {
    private int product = 0;
    long start = System.currentTimeMillis();

    public void get() {
        System.out.println("Клиент подошел");
        synchronized (this) {
            while (product < 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            long end = start + 10000;

            try {
                while (System.currentTimeMillis() < end) {
                    System.out.println("Клиент ждет");
                    currentThread().sleep(1000);
                    while (product < 1) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    product--;
                    System.out.println("Клиент взял 1 лыжи");
                    System.out.println("Лыж на складе: " + product);
                    notify();
                }
                if (System.currentTimeMillis() > end) {
                    currentThread().interrupt();
                    throw new InterruptedException();
                }

            } catch (InterruptedException e) {
                System.out.println("Клиент ушел");
            }
        }
    }


    public void getRetiree() {
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
                currentThread().sleep(500);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }

            product--;
            System.out.println("Пенсионер взял 1 лыжи");
            System.out.println("Лыж на складе: " + product);
            notify();

            try {
                throw new InterruptedException();
            } catch (InterruptedException e) {
                currentThread().interrupt();
            }
        }
    }


    public synchronized void put() {
        long start = System.currentTimeMillis();
        long end = start + 6000;

        while (product >= 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }

        product++;
        System.out.println("Работник добавил 1 пару лыж");
        System.out.println("Лыж на складе: " + product);
        notify();

        if (System.currentTimeMillis() > end)
            currentThread().interrupt();
    }

}
