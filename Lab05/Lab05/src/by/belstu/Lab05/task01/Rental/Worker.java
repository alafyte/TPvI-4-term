package by.belstu.Lab05.task01.Rental;

public class Worker extends Thread{
    Rental rental;
    Worker(Rental rental) {
        this.rental = rental;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            rental.put();
        }

    }
}
