package by.belstu.Lab05.task01;

public class Worker extends Thread{
    Rental rental;
    Worker(Rental rental) {
        this.rental = rental;
    }
    public void run() {
        for (int i = 1; i < 6; i++) {
            rental.put();
        }
    }
}
