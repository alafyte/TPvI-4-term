package by.belstu.Lab05.task01.Rental;

public class Retiree extends Thread {
    Rental rental;

    Retiree(Rental rental) {
        this.rental = rental;
    }
    @Override
    public void run() {
        rental.getRetiree();
    }
}
