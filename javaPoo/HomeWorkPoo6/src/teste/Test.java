package teste;

import java.util.ArrayList;
import java.util.Scanner;
import conturi.Clienti;
import exception.Ibanexception;
import exception.Mainexception;
import exception.Moneyexception;

public abstract class Test
{
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Clienti> lc = new ArrayList<>();

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		lc.add(new Clienti("Bogdan"));
		lc.add(new Clienti("Alex"));
		int flag1 = 1;
		int ct;
		// int ct1;
		while (flag1 != 0)
		{
			System.out.println(" ");
			System.out.println("0----Listeaza clienti existenti");
			System.out.println("1----Adauga conturi la clienti existenti");
			System.out.println("2----Stergeti conturi la clientii existenti");
			System.out.println("3----Operatii pe conturi");
			int i = sc.nextInt();

			switch (i)
			{
			case 0:
				System.out.println(lc);

				break;
			case 1:

				for (int j = 0; j < lc.size(); j++)
				{

					System.out.println(j + "--" + lc.get(j).toString());
				}
				System.out.println("Alegeti clientul:");
				ct = sc.nextInt();
				while (true)
				{
					System.out.println("iban=");
					String iban = sc.next();

					System.out.println("money=");
					double money = sc.nextDouble();
					try
					{
						lc.get(ct).add(iban, money);
						break;
					} catch (Ibanexception e)
					{
						System.out.println(e);
					} catch (Moneyexception e)
					{
						System.out.println(e);
					} catch (Mainexception e)
					{
						e.printStackTrace();
					}

				}
				break;
			case 2:
				for (int j = 0; j < lc.size(); j++)
				{

					System.out.println(j + "--" + lc.get(j).toString());
				}
				System.out.println("Alegeti clientul");
				ct = sc.nextInt();
				while (true)

				{

					System.out.println("iban=");
					String iban = sc.next();
					try
					{
						lc.get(ct).rem(iban);
						break;

					} catch (Ibanexception e)
					{
						System.out.println(e);
					} catch (Moneyexception e)
					{
						System.out.println(e);

					} catch (Mainexception e)
					{

						e.printStackTrace();
					}

				}
				break;
			case 3:
				for (int j = 0; j < lc.size(); j++)
				{

					System.out.println(j + "--" + lc.get(j).toString());
				}
				System.out.println("Alegeti clientul:");
				ct = sc.nextInt();
				System.out.println("");
				System.out.println(lc.get(ct).toString());
				int it = -1;
				cau1: while (true)
				{
					System.out.println("Alegeti contul  iban:");
					String ibt = sc.next();

					cau: for (int j = 0; j < lc.get(ct).getListaConturi()
							.size(); j++)
					{
						if (lc.get(ct).getListaConturi().get(j).getIban()
								.equals(ibt) == true)
						{
							it = j;
							break cau;
						}

					}
					if (it == -1)
					{
						System.out.println("Iban inexistent");

					}
					if (it != -1)
					{
						break cau1;
					}

				}

				System.out.println("0----Adauga bani");
				System.out.println("1----Sterge bani");
				System.out.println("2----Tranzactie");
				i = sc.nextInt();
				switch (i)
				{
				case 0:

					while (true)
					{

						System.out.println("money=");
						double money = sc.nextDouble();
						try
						{
							lc.get(ct).getListaConturi().get(it).add(money);
							break;
						} catch (Ibanexception e)
						{
							System.out.println(e);
						} catch (Moneyexception e)
						{
							System.out.println(e);
						} catch (Mainexception e)
						{
							e.printStackTrace();
						}

					}

					break;
				case 1:
					while (true)
					{

						System.out.println("money=");
						double money = sc.nextDouble();
						try
						{
							lc.get(ct).getListaConturi().get(it).rem(money);
							break;
						} catch (Ibanexception e)
						{
							System.out.println(e);
						} catch (Moneyexception e)
						{
							System.out.println(e);
						} catch (Mainexception e)
						{
							e.printStackTrace();
						}

					}
					break;
				case 2:
					for (int j = 0; j < lc.size(); j++)
					{

						System.out.println(j + "--" + lc.get(j).toString());
					}
					System.out
							.println("Alegeti clientul cauruia doritii sa ii trimiteti bani");
					int c2 = sc.nextInt();
					System.out.println("");
					System.out.println(lc.get(c2).toString());
					int it1 = -1;
					cau1: while (true)
					{
						System.out.println("Alegeti contul  iban:");
						String ibt = sc.next();

						cau: for (int j = 0; j < lc.get(c2).getListaConturi()
								.size(); j++)
						{
							if (lc.get(c2).getListaConturi().get(j).getIban()
									.equals(ibt) == true)
							{
								it = j;
								break cau;
							}

						}
						if (it1 == -1)
						{
							System.out.println("Iban inexistent");

						}
						if (it1 != -1)
						{
							break cau1;
						}

					}
					while (true)
					{
						System.out.println("Suma pe care vreti sa o trimiteti");
						double mt = sc.nextDouble();

						try
						{
							lc.get(ct)
									.getListaConturi()
									.get(it)
									.tranzactie(
											mt,
											lc.get(c2).getListaConturi()
													.get(it1));
							break;
						} catch (Ibanexception e)
						{
							System.out.println(e);
						} catch (Moneyexception e)
						{
							System.out.println(e);
						} catch (Mainexception e)
						{
							e.printStackTrace();
						}

					}
				}

				break;
			}
		}
	}
}
