package by.belstu.Lab04.task01;

public class Client extends Thread {
    Rental rental;

    Client(Rental rental){
        this.rental = rental;
    }
    public void run() {
        rental.get();
    }
}
