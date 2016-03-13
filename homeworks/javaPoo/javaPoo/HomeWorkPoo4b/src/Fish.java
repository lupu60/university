public class Fish extends Animal implements Pet
{
	private String name;

	/**
	 * This Constructor initializes Fish with the null parameters
	 */
	public Fish()
	{
		super(0);
		this.name = " ";
	}

	/**
	 * This Constructor initalizes Fish with the parameters given
	 * 
	 * @param legs
	 *            - the legs, type {@link int}
	 * 
	 * @param name
	 *            - the Fish name, type {@link String}
	 */
	public Fish(int legs, String name)
	{
		super(legs);
		this.name = name;
	}

	/**
	 * This method returns the fish name
	 * 
	 * @return name
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
		System.out.println("mananca pesti mai mici");
	}

	@Override
	public void play()
	{
		System.out.println("nu se joaca mereu! ");
	}

	@Override
	public void walk()
	{
		System.out.println("nu merge!");
	}
}
