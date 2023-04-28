package by.belstu.lab14.task04;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
public class ConsoleReceiver
{
    @Resource(mappedName = "jms/GlassFishConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(mappedName ="jms/GlassFishTopic")
    private static Topic topic;
    public void getMessages()
    {
        Connection connection;
        MessageConsumer messageConsumer;
        TextMessage textMessage;
        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            messageConsumer = session.createConsumer(topic);
            connection.start();
            System.out.println("Waiting for messages...");
            textMessage = (TextMessage) messageConsumer.receive();
            System.out.println(textMessage.toString());
            messageConsumer.close();
            session.close();
            connection.close();
        }
        catch (JMSException e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        new ConsoleReceiver().getMessages();
    }
}