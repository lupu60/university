public class Date {
	private byte day;
	private byte month;
	private short year;

	public Date(byte day, byte month, short year) {
		if (year > 0) {
			this.year = year;
		} else

			System.out.println("Wrong value for year, is negative");
		if (month > 0 && month <= 12) {
			this.month = month;
			if (month % 2 != 0)
				if (day > 0 && day <= 31)
					this.day = day;
				else
					System.out.println("Wrong value for day");
			else if (month == 2 && year % 4 == 0)
				if (day > 0 && day <= 29)
					this.day = day;
				else
					System.out.println("Wrong value for day ");
			else if (month == 2 && year % 4 != 0)
				if (day > 0 && day <= 29)
					this.day = day;
				else
					System.out.println("Wrong value for day");
			else if (day > 0 && day <= 30)
				this.day = day;
			else
				System.out.println("Wrong value for day ");
		} else
			System.out.println("Wrong value for month ");
	}

	public byte getDay() {
		return day;
	}

	public void setDay(byte day) {
		this.day = day;
	}

	public byte getMonth() {
		return month;
	}

	public void setMonth(byte month) {
		this.month = month;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
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
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return day + "/" + month + "/" + year;
	}

}
