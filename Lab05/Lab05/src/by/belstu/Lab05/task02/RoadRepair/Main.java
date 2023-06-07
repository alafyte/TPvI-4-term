package by.belstu.Lab05.task02.RoadRepair;

public class Main {
    public static void main(String[] args) {
        Road road = new Road();

        for (int i = 1; i <= 10; i++) {
            Direction direction = i % 2 == 0 ? Direction.LEFT : Direction.RIGHT;
            new Car(i, direction, road).start();
        }
    }
}
