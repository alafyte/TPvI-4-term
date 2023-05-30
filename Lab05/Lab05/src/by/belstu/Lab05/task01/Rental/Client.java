package by.belstu.Lab05.task01.Rental;

public class Client extends Thread {
    Rental rental;

    Client(Rental rental){
        this.rental = rental;
    }
    @Override
    public void run() {
        rental.get(this);
    }
}
