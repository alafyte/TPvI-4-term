package by.belstu.Lab05.task01.CallCenter;


import java.util.Random;

public class CallCenter {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    private final int NUMBER_OF_OPERATORS = 5;
    private int currentNumberOfClients = 0;
    private final Client[] clients = new Client[NUMBER_OF_OPERATORS];

    public void acceptClient(Client client) {
        long start = System.currentTimeMillis();
        long end = start + 4000;
        synchronized (this) {
            while (currentNumberOfClients >= NUMBER_OF_OPERATORS) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (System.currentTimeMillis() > end) {
            int option = new Random().nextInt(2) + 1;
            switch (option) {
                case 1 -> {
                    System.out.println(RED + "Клиент " + client.getClientName() + " отключился" + RESET);
                    return;
                }
                case 2 -> {
                    System.out.println(RED + "Клиент " + client.getClientName() + " отключился" + RESET);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(GREEN + "Клиент " + client.getClientName() + " перезванивает");
                }
            }
        }

        synchronized (this) {
            currentNumberOfClients++;
            int operatorId = getFreeOperator();
            clients[operatorId] = client;
            System.out.println(GREEN + "Клиент " + client.getClientName() + " обслуживается у оператора "
                    + (operatorId + 1) + ". Текущее кол-во клиентов: " + currentNumberOfClients + RESET);
        }
        try {
            long timeForPerson = (long) 1000 * (new Random().nextInt(1, 6) + 1);
            Thread.sleep(timeForPerson);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (this) {
            clientLeaves(client);
            currentNumberOfClients--;
            notifyAll();
            System.out.println(BLUE + "Клиент " + client.getClientName() +
                    " покидает колл-центр. Текущее кол-во клиентов: " + currentNumberOfClients + RESET);
            client.interrupt();
        }
    }

    private int getFreeOperator() {
        for (int i = 0; i < NUMBER_OF_OPERATORS; i++) {
            if (clients[i] == null)
                return i;
        }
        return -1;
    }

    public void clientLeaves(Client client) {
        for (int i = 0; i < NUMBER_OF_OPERATORS; i++) {
            if (clients[i] == client) {
                clients[i] = null;
            }
        }
    }
}
