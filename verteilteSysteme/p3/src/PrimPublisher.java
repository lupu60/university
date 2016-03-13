import java.util.*;
import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class PrimPublisher {
	// URL of the JMS server
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	// array that stores the time of determination (Rechenzeit) of each prime
	// number
	static ArrayList<Long> difference = new ArrayList<Long>();

	/**
	 * @param a
	 *            exact time before a prime number is being determined
	 * @param b
	 *            exact time at which a prime number has been determined
	 * @return the time of determination of a prime number, b-a
	 */
	public static long executionTime(long a, long b) {
		return b - a;
	}

	/**
	 * @param max
	 *            number up to which prime numbers will be determined
	 * @return a list that includes all prime numbers up to max
	 */
	public static List<Integer> generatePrimes(int max) {
		// list in which the prime numbers will be stored
		List<Integer> primes = new ArrayList<Integer>();
		// time at which the execution starts
		long before = System.currentTimeMillis();
		// start from 2
		OUTERLOOP: for (int i = 2; i <= max; i++) {
			// try to divide it by all known primes
			for (Integer p : primes)
				if (i % p == 0)
					// i is not prime
					continue OUTERLOOP;
			// time at which a new prime number has been determined
			long after = System.currentTimeMillis();
			// i is prime
			primes.add(i);
			difference.add(executionTime(before, after));
		}
		return primes;
	}

	public static void main(String[] args) throws JMSException,
			InterruptedException {
		/**
		 * creates and starts the connection, creates the current session, the
		 * topic and the producer
		 */
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("Primzahlen");
		MessageProducer producer = session.createProducer(topic);

		ArrayList<Integer> p = new ArrayList<Integer>();
		// list p will include all prime numbers up to 1000
		p = (ArrayList<Integer>) generatePrimes(1000);
		MapMessage mmessage = session.createMapMessage();
		// loop in which all elements from p will be put into the MapMessage and
		// sent along with other info
		Iterator<Integer> i = p.iterator();
		while (i.hasNext()) {
			Integer s = (Integer) i.next();
			mmessage.setJMSTimestamp((int) mmessage.getJMSTimestamp());
			// index of current prime number
			mmessage.setIntProperty("Laufende_Nummer", p.indexOf(s));
			// current prime number
			mmessage.setIntProperty("Primzahl", (int) s);
			// time of determination of current prime number
			mmessage.setLongProperty("Rechenzeit", difference.get(p.indexOf(s)));
			producer.send(mmessage);
			// Thread sleeps for 1 second (1000 ms)
			Thread.sleep(1000);
			System.out.println(s);
		}
		System.out.println("Sent message " + "!");
		TextMessage textm = session.createTextMessage();
		textm.setText("End");
		producer.send(textm);
		// connection.close();
	}
}
