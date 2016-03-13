import java.io.IOException;
import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class PrimSubscriber {
	// URL of the JMS server
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args) throws JMSException {
		/**
		 * creates and starts the connection, creates the current session, the
		 * topic and the subscriber
		 */
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		// topic must be the same as the publisher's
		Topic topic = session.createTopic("Primzahlen");
		MessageConsumer consumer = session.createConsumer(topic);
		// create the MessageListener and define the onMessage method
		MessageListener listner = new MessageListener() {
			public void onMessage(Message message) {
				try {
					/**
					 * if the received message is a MapMessage, then print out
					 * all the attributes
					 */
					if (message instanceof MapMessage) {
						MapMessage mapMessage = (MapMessage) message;
						System.out.println("Timestamp "
								+ mapMessage.getJMSTimestamp());
						System.out.println("Laufende Nummer "
								+ mapMessage.getIntProperty("Laufende_Nummer"));
						System.out.println("Die Primzahl ist "
								+ mapMessage.getIntProperty("Primzahl") + "!");
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
		// set the MessageListener for the current subscriber
		consumer.setMessageListener(listner);

		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// connection.close();

	}
}