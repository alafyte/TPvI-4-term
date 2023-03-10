package by.belstu.Lab04.task02;

public class Parking extends Thread{
    private final int parkingId;
    private final int size;

    public Parking(int id, int size) {
        this.parkingId = id;
        this.size = size;
    }

    public int getParkingId() {
        return parkingId;
    }

    public int getSize() {
        return size;
    }
}
