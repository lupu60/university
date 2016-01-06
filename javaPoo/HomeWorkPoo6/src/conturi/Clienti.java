package conturi;

import java.util.ArrayList;
import exception.Ibanexception;
import exception.Mainexception;
import exception.Moneyexception;

public class Clienti
{
	private String nume;
	private ArrayList<Cont> listaConturi = new ArrayList<>();

	public Clienti()
	{
	}

	public Clienti(String nume)
	{
		this.nume = nume;
	}

	public Clienti(String nume, ArrayList<Cont> listaConturi)
	{
		this.nume = nume;
		this.listaConturi = listaConturi;
	}

	public String getNume()
	{
		return nume;
	}

	public void setNume(String nume)
	{
		this.nume = nume;
	}

	public ArrayList<Cont> getListaConturi()
	{
		return listaConturi;
	}

	public void setListaConturi(ArrayList<Cont> listaConturi)
	{
		this.listaConturi = listaConturi;
	}
//metoda add adauga cont clientului aferent
	public void add(String iban, double money) throws Mainexception
	{
		if (iban == null)
			throw new Ibanexception("||" + iban + "||  Iban inexistent");
		if (money < 0)
			throw new Moneyexception("||" + money
					+ "||   Nu puteti introduce o suma negativa");
		listaConturi.add(new Cont(iban, nume, money));
		System.out.println("contul sa adaugat cu succes");
	}
//metoda rem sterge cont clientului aferent
	public void rem(String iban) throws Mainexception
	{

		for (Cont c : listaConturi)
		{
			if (c.getIban().equals(iban))
			{
				if (c.getMoney() == 0)
				{
					listaConturi.remove(c);
					return;
				} else
					throw new Moneyexception("||" + c.getMoney()
							+ "|| mai aveti sold");
			}
		}
		throw new Ibanexception("||" + iban + "||  Iban inexistent");
	}

	public int cautare(String iban) throws Ibanexception
	{
		for (Cont c : listaConturi)
		{
			if (c.getIban().equals(iban))
			{
				return listaConturi.indexOf(c);
			}
		}
		throw new Ibanexception("||" + iban + "||  Iban inexistent");

	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((listaConturi == null) ? 0 : listaConturi.hashCode());
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
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
		Clienti other = (Clienti) obj;
		if (listaConturi == null)
		{
			if (other.listaConturi != null)
				return false;
		} else if (!listaConturi.equals(other.listaConturi))
			return false;
		if (nume == null)
		{
			if (other.nume != null)
				return false;
		} else if (!nume.equals(other.nume))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Client: nume=" + nume + ", listaConturi=" + listaConturi + "  ";
	}

}
