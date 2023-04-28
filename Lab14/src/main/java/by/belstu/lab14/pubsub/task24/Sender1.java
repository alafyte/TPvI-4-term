package by.belstu.lab14.pubsub.task24;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.*;

public class Sender1 {
    public static void main(String[] args){
        ConnectionFactory factory= new ConnectionFactory();
        try(JMSContext context = factory.createContext("admin", "admin")){
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
            Destination priceInfo  = context.createTopic("PubSubTopic");
            TextMessage outMsg = context.createTextMessage();
            outMsg.setText("Message with priority 2");
            outMsg.setStringProperty("symbol", "BSTU");
            while (true) {
                System.out.println("message has been sent");
                context.createProducer().setPriority(2).send(priceInfo, outMsg);
                Thread.sleep(1000);
            }
        } catch (JMSException | InterruptedException e) {
            System.out.println("ConnectionConfigurationError: " + e.getMessage());
        }
    }
}
