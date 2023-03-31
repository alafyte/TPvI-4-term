package by.belstu.Lab08.task03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    private final DatagramSocket socket;


    public Server(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public String getMessages() throws IOException {
        byte[] messageUDP = new byte[13];
        socket.receive(new DatagramPacket(messageUDP, 13));
        StringBuilder message = new StringBuilder();
        for (var b: messageUDP) {
            if (b != 0)
                message.append(((char)b));
        }
        return message.toString();
    }


    public static void main(String[] args) throws IOException {
        Server getUDP = new Server(4321);
        while (true) {
            System.out.println(getUDP.getMessages());
        }
    }
}
