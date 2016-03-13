import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class PrimTwinsPublisher {
	// URL of the JMS server
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	static ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
			url);
	static Session pubSession = null;
	static int n = 1000;
	// stores the time of determination of each prime number
	static ArrayList<Long> rechenzeit = new ArrayList<Long>();
	// stores each prime number received
	static ArrayList<Integer> prime = new ArrayList<Integer>();
	//counts the numbers of prime twin numbers
	static int count = 1;
	// create the MessageListener and define the onMessage method
	static MessageListener listner = new MessageListener() {
		public void onMessage(Message message) {
			try {

				if (message instanceof MapMessage) {
					MapMessage mapMessage = (MapMessage) message;
					System.out.println("Timestamp "
							+ mapMessage.getJMSTimestamp());
					// index of prime number
					int aux = mapMessage.getIntProperty("Laufende_Nummer");
					System.out.println("Laufende Nummer " + aux);
					System.out.println("Die Primzahl ist "
							+ mapMessage.getIntProperty("Primzahl") + "!");
					// store the received prime number
					prime.add(mapMessage.getIntProperty("Primzahl"));
					System.out.println("Rechenzeit "
							+ mapMessage.getLongProperty("Rechenzeit"));
					// store the time of determination of received prime nr
					rechenzeit.add(mapMessage.getLongProperty("Rechenzeit"));
					System.out.println();
					// test to see if there are at least 2 prime numbers stored
					if (prime.size() > 1) {
						try {
							//create a new connection, publisher and topic
							Connection conn = connectionFactory
									.createConnection();
							conn.start();
							pubSession = conn.createSession(false,
									Session.AUTO_ACKNOWLEDGE);
							Topic topic2 = pubSession
									.createTopic("Primzahlzwillinge");
							MessageProducer producer = pubSession
									.createProducer(topic2);
							MapMessage mapmessage = pubSession
									.createMapMessage();
							// get the prime number using its index aux
							Integer s = prime.get(aux);
							int index = prime.indexOf(s);
							// get the prime number with index-1
							Integer r = prime.get(index - 1);
							// difference of 2 consecutive prime numbers
							if ((s - r) == 2) {
								// s and r are prime twins, they will be published
								mapmessage.setJMSTimestamp((int) mapmessage
										.getJMSTimestamp());
								mapmessage.setIntProperty("Laufende_Nummer",
										count);
								mapmessage.setIntProperty("ErstePrimzahl", (int) r);
								mapmessage.setIntProperty("ZweitePrimzahl",
										(int) s);
								mapmessage.setLongProperty(
										"Rechenzeit",
										rechenzeit.get(prime.indexOf(s))
												+ rechenzeit.get(prime
														.indexOf(r)));
								producer.send(mapmessage);
								// sleep for 1 second
								Thread.sleep(1000);
								System.out.println(s + " " + r);
								count++;
							}

							System.out.println("Sent message " + "!");
						} catch (Exception e) {
							System.out.println("Caught:" + e);
							e.printStackTrace();
						}

					}
				}
			} catch (Exception e) {
				System.out.println("Caught:" + e);
				e.printStackTrace();
			}
		}
	};

	public static void main(String[] args) throws JMSException,
			InterruptedException {
		// create connection and session for subscriber
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session subSession = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);

		// subscriber to PrimPublisher
		Topic topic1 = subSession.createTopic("Primzahlen");
		MessageConsumer consumer = subSession.createConsumer(topic1);

		consumer.setMessageListener(listner);

		try {
			System.in.read();
			subSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// connection.close();
	}
}