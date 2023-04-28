package by.belstu.lab14.pubsub.task13;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.*;

public class Receiver1 implements MessageListener {
    private ConnectionFactory factory = new ConnectionFactory();
    private JMSConsumer consumer;
    private int Client_Id = 0;

    Receiver1() {
        try (JMSContext context = factory.createContext("admin", "admin", JMSContext.AUTO_ACKNOWLEDGE )) {
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676, mq://127.0.0.1:7676");
            context.setClientID(String.valueOf((Client_Id++)));
            Destination weatherInfo = context.createTopic("PubSubTopic");
            consumer = context.createDurableConsumer((Topic)weatherInfo, "DurableConsumer");
            consumer.setMessageListener(this);
            System.out.println("Listening to queue...");
            Thread.sleep(100000);
        } catch (JMSException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Receiver 1: "+ message.getBody(String.class));
        } catch (Exception e) {
            System.err.println("JMSException: " + e.toString());
        }
    }

    public static void main (String[] args){
        new Receiver1();
    }
}
