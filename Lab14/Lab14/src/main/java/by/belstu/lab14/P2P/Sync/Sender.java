package by.belstu.lab14.P2P.Sync;

import javax.jms.*;

import by.belstu.lab14.P2P.Weather;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.ConnectionConfiguration;



public class Sender {
    public static void main(String[] args){
        ConnectionFactory factory;
        factory = new ConnectionFactory();
        try( JMSContext context = factory.createContext("admin","admin")){
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
            Destination weatherQueue = context.createQueue("P2PSync");
            JMSProducer producer = context.createProducer();
            Weather message = new Weather("Minsk", 16.6, 60, 3.4);
            ObjectMessage objMsg = context.createObjectMessage(message);
            producer.send(weatherQueue,objMsg);
            System.out.println("Placed an information about weather to queue");
        } catch (JMSException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}
