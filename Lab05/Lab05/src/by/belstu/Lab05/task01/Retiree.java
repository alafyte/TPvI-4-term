package by.belstu.Lab05.task01;

public class Retiree extends Thread {
    Rental rental;

    Retiree(Rental rental) {
        this.rental = rental;
    }

    public void run() {
        rental.getRetiree();
    }
}
