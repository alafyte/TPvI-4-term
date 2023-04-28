package by.belstu.lab14.P2P.Async;

import by.belstu.lab14.P2P.Weather;
import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.*;

public class Sender {
    public static void main(String[] args){
        ConnectionFactory factory = new ConnectionFactory();
        try( JMSContext context = factory.createContext("admin","admin")){
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
            Destination weatherQueue = context.createQueue("P2PAsync");
            JMSProducer producer = context.createProducer();
            Weather message = new Weather("Brest", 18.2, 30, 1.8);
            ObjectMessage objMsg = context.createObjectMessage(message);
            producer.send(weatherQueue,objMsg);
            System.out.println("Placed an information about weather to queue");
        } catch (JMSException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
