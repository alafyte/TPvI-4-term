package by.belstu.Lab04.task01;

public class Retiree extends Thread {
    Rental rental;

    Retiree(Rental rental) {
        this.rental = rental;
    }

    public void run() {
        rental.getRetiree();
    }
}
