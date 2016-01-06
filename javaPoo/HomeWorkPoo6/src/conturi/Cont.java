package conturi;

import java.text.NumberFormat;

import exception.Ibanexception;
import exception.Mainexception;
import exception.Moneyexception;

public class Cont
{
	private String iban;
	private String name;
	private double money;
	final private double moneyi = 50;

	public Cont()
	{
		super();
	}

	public Cont(String iban, String name, double money)
	{
		super();
		this.iban = iban;
		this.name = name;
		this.money = money;
	}

	public String getIban()
	{
		return iban;
	}

	public String getName()
	{
		return name;
	}

	public double getMoney()
	{
		return money;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iban == null) ? 0 : iban.hashCode());
		return result;
	}

	

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cont other = (Cont) obj;
		if (iban == null)
		{
			if (other.iban != null)
				return false;
		} else if (!iban.equals(other.iban))
			return false;
		return true;
	}
//metoda add adauga bani contului aferent
	public void add(double money) throws Mainexception
	{
		if (iban == null)
			throw new Ibanexception("||" + iban + "||  Iban inexistent");
		if (money < 0)
			throw new Moneyexception("||" + money
					+ "||   Nu puteti introduce o suma negativa");
		if (money < 0 && money < moneyi)
			throw new Moneyexception("||" + money
					+ "||   Trebuie o suma mai mare");
		this.money += money;
		System.out.println("Adaugarea sa realizat cu succes");

	}

	public void rem(double money) throws Mainexception
	{
		if (iban == null)
			throw new Ibanexception("||" + iban + "||  Iban inexistent");

		if (money < 0)
			throw new Moneyexception("||" + money
					+ "||   Nu puteti introduce o suma negativa");
		if (money < 0 && money < moneyi)
			throw new Moneyexception("||" + money
					+ "||   Trebuie o suma mai mare");
		if (this.money <= money)
			throw new Moneyexception("Fonduri insuficiente");
		this.money -= money;
		System.out.println("Retragerea sa realizat cu succes");
	}

	public void tranzactie(double money, Cont contp) throws Mainexception
	{
		if (iban == null)
			throw new Ibanexception("||" + iban + "||  Iban inexistent");
		if (money < 0)
			throw new Moneyexception("||" + money
					+ "||   Nu puteti introduce o suma negativa");
		rem(money);
		contp.add(money);
		System.out.println("Tranzactia sa realizat cu succes");
	}

	@Override
	public String toString()
	{
		return "Cont :iban=" + iban + ", name=" + name + ", money="
				+ NumberFormat.getCurrencyInstance().format(money) + " ";
	}

}
