package by.belstu.lab14.P2P.Sync;

import by.belstu.lab14.P2P.Weather;
import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.*;

public class Receiver {
    ConnectionFactory factory = new com.sun.messaging.ConnectionFactory();
    JMSConsumer consumer;

    Receiver() {
        try (JMSContext context = factory.createContext("admin", "admin")) {
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
            Destination weatherQueue = context.createQueue("P2PSync");
            Weather message = context.createConsumer(weatherQueue).receiveBody(by.belstu.lab14.P2P.Weather.class);
            System.out.println(message.toString());
            System.out.println("Listening to queue...");
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (JMSException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args){
        new Receiver();
    }

}
