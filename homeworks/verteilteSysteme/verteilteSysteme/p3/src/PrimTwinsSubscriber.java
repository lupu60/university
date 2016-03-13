import java.io.IOException;
import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;


public class PrimTwinsSubscriber {
	// URL of the JMS server
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args) throws JMSException {
		// create connection and session
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		// create topic and subscriber for PrimTwinsPublisher
		Topic topic = session.createTopic("Primzahlzwillinge");
		MessageConsumer consumer = session.createConsumer(topic);
		// define the onMessage method inside the MessageListener
		MessageListener listner = new MessageListener() {
			public void onMessage(Message message) {
				try {
					if (message instanceof MapMessage) {
						MapMessage mapMessage = (MapMessage) message;
						System.out.println("Timestamp "
								+ mapMessage.getJMSTimestamp());
						System.out.println("Laufende Nummer "
								+ mapMessage.getIntProperty("Laufende_Nummer"));
						System.out.println("Die erste Primzahl ist "
								+ mapMessage.getIntProperty("ErstePrimzahl")
								+ "!");
						System.out.println("Die zweite Primzahl ist "
								+ mapMessage.getIntProperty("ZweitePrimzahl")
								+ "!");
						System.out.println("Rechenzeit "
								+ mapMessage.getLongProperty("Rechenzeit"));
						System.out.println();
					}
				} catch (JMSException e) {
					System.out.println("Caught:" + e);
					e.printStackTrace();
				}
			}
		};
		consumer.setMessageListener(listner);
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// connection.close();
	}
}