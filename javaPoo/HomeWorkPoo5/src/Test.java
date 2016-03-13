import java.util.Scanner;

public class Test {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out
				.println("Introduceti pe ce fel de sri vreti sa operati? int/double/default");
		String read = sc.next();
		if (read.equals("int")) {
			System.out.println("Spuneti lungimea sirului");
			OperationsForInreger integer = new OperationsForInreger(
					sc.nextInt());
			
			
			do {
				System.out
				.println("Spuneti ce operatii doriti sa faceti asupra sirului add/remove/find/cout/modify/findAll/findRange");
				read = sc.next();
				switch (read) {
				case "add": {
					System.out
							.println("Introduceti numarul ce vreti sa il adaugati");
					try {
						integer.add(sc.nextInt());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case "remove":
					System.out
							.println("Introduceti numarul ce vreti sa il stergeti");
					try {
						integer.remove(sc.nextInt());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "find":
					System.out
							.println("Introduceti numarul ce vreti sa il cautati");
					try {
						System.out.println("Elementul gasit este------------"
								+ integer.find(sc.nextInt()));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "cout":
					System.out.println("Numarul elementelor este------------"
							+ integer.count());
					break;
				case "modify":
					System.out
							.println("Introduceti numerele care vreti sa le schibati numarul vechi/ numarul nou");
					try {
						integer.modify(sc.nextInt(), sc.nextInt());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "findAll":
					try {
						System.out.println("Elementele cautate sunt");
						for (Integer in : integer.findAll()) {
							System.out.print(" " + in.intValue());
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				case "findRange":
					System.out
							.println("Introduceti numarul elementelor care vreti sa regasiti");
					int lenght = sc.nextInt();
					int[] l = new int[lenght];
					System.out.println("introduceti indexulrile");
					for (int i = 0; i < l.length; i++) {
						l[i] = sc.nextInt();
					}
					try {
						System.out.println("Elementele cautate sunt");
						for (Integer in : integer.findRange(l)) {
							System.out.print(" " + in.intValue());
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				default:
					break;
				}

				System.out
						.println("Daca mai veti sa faceti operatii asupra sirului introduceti true");
			} while (sc.next().equals("true"));
		} else if (read.equals("double")) {
			System.out.println("Spuneti lungimea sirului");
			OperationsForDouble doub = new OperationsForDouble(sc.nextInt());
			
			do {
				System.out
				.println("Spuneti ce operatii doriti sa faceti asupra sirului add/remove/find/cout/modify/findAll/findRange");
				read = sc.next();
				switch (read) {
				case "add": {
					System.out
							.println("Introduceti numarul ce vreti sa il adaugati");
					try {
						doub.add(sc.nextDouble());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case "remove":
					System.out
							.println("Introduceti numarul ce vreti sa il stergeti");
					try {
						doub.remove(sc.nextDouble());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "find":
					System.out
							.println("Introduceti numarul ce vreti sa il cautati");
					try {
						System.out.println("Elementul gasit este------------"
								+ doub.find(sc.nextDouble()));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "cout":
					System.out.println("Numarul elementelor este------------"
							+ doub.count());
					break;
				case "modify":
					System.out
							.println("Introduceti numerele care vreti sa le schibati numarul vechi/ numarul nou");
					try {
						doub.modify(sc.nextDouble(), sc.nextDouble());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "findAll":
					try {
						System.out.println("Elementele cautate sunt");
						for (Double in : doub.findAll()) {
							System.out.print(" " + in.doubleValue());
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				case "findRange":
					System.out
							.println("Introduceti numarul elementelor care vreti sa regasiti");
					int lenght = sc.nextInt();
					int[] l = new int[lenght];
					System.out.println("introduceti indexulrile");
					for (int i = 0; i < l.length; i++) {
						l[i] = sc.nextInt();
					}
					try {
						System.out.println("Elementele cautate sunt");
						for (Double in : doub.findRange(l)) {
							System.out.print(" " + in.intValue());
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				default:
					break;
				}

				System.out
						.println("Daca mai veti sa faceti operatii asupra sirului introduceti true");
			} while (sc.next().equals("true"));
		}else
			System.out.println("Trebuie folosita clasa generica");
	}

}
