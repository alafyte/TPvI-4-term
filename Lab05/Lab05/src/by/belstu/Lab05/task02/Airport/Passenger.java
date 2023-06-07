package by.belstu.Lab05.task02.Airport;

public class Passenger extends Thread {
    private int passengerId;
    private int planeId;
    private Airport airport;

    public Passenger(int passengerId, int planeId, Airport airport) {
        this.passengerId = passengerId;
        this.planeId = planeId;
        this.airport = airport;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    @Override
    public void run() {
        try {
            airport.boardingPassenger(planeId, passengerId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
