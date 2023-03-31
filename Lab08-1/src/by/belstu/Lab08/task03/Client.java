package by.belstu.Lab08.task03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {
    private final DatagramSocket socket;


    public Client(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }


    public void sendMessages(String messages, int port) throws IOException {
        DatagramPacket message = new DatagramPacket(messages.getBytes(), messages.getBytes().length, InetAddress.getLocalHost(), port);
        socket.send(message);
    }


    public static void main(String[] args) throws IOException {
        Client udp = new Client(1234);
        udp.sendMessages("Hello UDP1", 4321);
        udp.sendMessages("Hello UDP2", 4321);
        udp.sendMessages("Hello UDP3", 4321);
        udp.sendMessages("", 4321);
    }
}
