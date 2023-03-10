package by.belstu.Lab04.task01;

public class Main {
    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
            long end = start + 1000;

            Rental rental = new Rental();
            Worker worker = new Worker(rental);
            worker.start();

            for (int i = 0; i < 2; i++)
                new Client(rental).start();


            Retiree retireeThread = new Retiree(rental);
            retireeThread.setPriority(1);
            retireeThread.start();


            if (System.currentTimeMillis() > end)
                Thread.currentThread().interrupt();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
