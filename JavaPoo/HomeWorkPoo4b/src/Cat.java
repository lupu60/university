public class Cat extends Animal implements Pet
{
	private String name;

	/**
	 * This Constructor initializes Cat with the null parameters
	 */
	public Cat()
	{
		super(4);
		this.name = " ";
	}

	/**
	 * This Constructor initalizes Cat with the parameters given
	 * 
	 * @param legs
	 *            - the legs, type {@link int}
	 * 
	 * @param name
	 *            - the Cat name, type {@link String}
	 */
	public Cat(int legs, String name)
	{
		super(legs);
		this.name = name;
	}

	/**
	 * This method returns the cat name
	 * 
	 * @return name - the cat name, type{@link String}
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * This method sets the name with the name given as parameter
	 * 
	 * @param setez_name
	 *            -the pet name, type {@link String}
	 * @return void
	 */
	@Override
	public void setName(String setez_name)
	{
		this.name = setez_name;
	}

	@Override
	public String toString()
	{
		return "Name: " + this.getName() + " ; " + "number of legs: "
				+ super.toString();
	}

	@Override
	public void eat()
	{
		System.out.println("mananca soareci!");
	}

	@Override
	public void play()
	{
		System.out.println("se joaca!");
	}

}
