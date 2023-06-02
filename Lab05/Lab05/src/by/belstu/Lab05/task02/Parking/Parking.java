package by.belstu.Lab05.task02.Parking;

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
