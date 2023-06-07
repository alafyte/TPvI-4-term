package by.belstu.Lab05.task02.RoadRepair;

public class Car extends Thread {
    private int carId;
    private Direction direction;
    private Road road;
    public Car(int carId, Direction direction, Road road) {
        this.carId = carId;
        this.direction = direction;
        this.road = road;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void run() {
        try {
            road.carArrived(getCarId(), getDirection());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
