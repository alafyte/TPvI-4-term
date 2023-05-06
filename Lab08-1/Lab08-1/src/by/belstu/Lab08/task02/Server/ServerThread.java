package by.belstu.Lab08.task02.Server;

import java.io.*;
import java.net.Socket;

class ServerThread extends Thread {

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Server.messageStory.printStory(writer);
        start();
    }

    @Override
    public void run() {
        try {
            var message = reader.readLine();
            try {
                writer.write(message + "\n");
                writer.flush();
            } catch (IOException ignored) {}
            try {
                while (true) {
                    message = reader.readLine();
                    if(message.equals("end")) {
                        this.downService();
                        break;
                    }
                    System.out.println(message);
                    Server.messageStory.addStoryElement(message);
                    for (ServerThread vr : Server.serverThreads) {
                        vr.send(message);
                    }
                }
            } catch (NullPointerException ignored) {}
        } catch (IOException e) {
            this.downService();
        }
    }

    private void send(String message) {
        try {
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException ignored) {}
    }

    private void downService() {
        try {
            if(!socket.isClosed()) {
                socket.close();
                reader.close();
                writer.close();
                for (ServerThread  vr : Server.serverThreads) {
                    if(vr.equals(this)) vr.interrupt();
                    Server.serverThreads.remove(this);
                }
            }
        } catch (IOException ignored) {}
    }
}
