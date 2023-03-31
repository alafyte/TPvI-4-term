package by.belstu.Lab08.task02.Client;

public class Client {
    private static final String IPAddress = "localhost";
    private static final int PORT = 4000;

    public static void main(String[] args) {
        new ClientThread(IPAddress, PORT);
    }

}
