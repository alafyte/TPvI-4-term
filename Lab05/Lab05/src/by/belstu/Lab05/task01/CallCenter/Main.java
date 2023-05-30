package by.belstu.Lab05.task01.CallCenter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Иван", callCenter));
        clients.add(new Client("Мария", callCenter));
        clients.add(new Client("Владислав", callCenter));
        clients.add(new Client("Арсений", callCenter));
        clients.add(new Client("Юлия", callCenter));
        clients.add(new Client("Маргарита", callCenter));
        clients.add(new Client("Дмитрий", callCenter));
        clients.add(new Client("Илья", callCenter));
        clients.add(new Client("Олег", callCenter));
        clients.add(new Client("Никита", callCenter));

        for(var client : clients) {
            client.start();
        }
    }
}
