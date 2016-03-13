import java.text.NumberFormat;

public class Engine {
	private String fuel;
	private int hp;
	private int cm3;
	private double price;

	public Engine(String fuel, int hp, int cm3, double price) {
		this.fuel = fuel;
		this.hp = hp;
		this.cm3 = cm3;
		this.price = price;
	}

	public Engine() {
		fuel = null;
		hp = 0;
		cm3 = 0;
		price = 0;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getCm3() {
		return cm3;
	}

	public void setCm3(int cm3) {
		this.cm3 = cm3;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cm3;
		result = prime * result + ((fuel == null) ? 0 : fuel.hashCode());
		result = prime * result + hp;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Engine other = (Engine) obj;
		if (cm3 != other.cm3)
			return false;
		if (fuel == null) {
			if (other.fuel != null)
				return false;
		} else if (!fuel.equals(other.fuel))
			return false;
		if (hp != other.hp)
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Engine: Fuel=" + fuel + ", hp=" + hp + ", cm3=" + cm3
				+ ", Price=" + NumberFormat.getCurrencyInstance().format(price) + " ";
	}
}
