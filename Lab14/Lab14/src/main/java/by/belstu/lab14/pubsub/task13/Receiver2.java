package by.belstu.lab14.pubsub.task13;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.*;

public class Receiver2 implements MessageListener{
    private ConnectionFactory factory = new ConnectionFactory();
    private JMSConsumer consumer;

    Receiver2() {
        try (JMSContext context = factory.createContext("admin", "admin", JMSContext.CLIENT_ACKNOWLEDGE )) {
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676, mq://127.0.0.1:7676");
            Destination weatherInfo = context.createTopic("PubSubTopic");
            consumer = context.createConsumer(weatherInfo);
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
            System.out.println("Receiver 2: "+ message.getBody(String.class));
        } catch (Exception e) {
            System.err.println("JMSException: " + e.toString());
        }
    }

    public static void main (String[] args){
        new Receiver2();
    }
}
