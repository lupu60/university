public class Spider extends Animal implements Pet
{
	private String name;

	/**
	 * This Constructor initializes Spider with the null parameters
	 */
	public Spider()
	{
		super(8);
		this.name = " ";
	}

	/**
	 * This Constructor initalizes Spider with the parameters given
	 * 
	 * @param legs
	 *            - the legs, type {@link int}
	 * 
	 * @param name
	 *            - the Spider name, type {@link String}
	 */
	public Spider(int legs, String name)
	{
		super(legs);
		this.name = name;

	}

	/**
	 * This method returns the cat name
	 * 
	 * @return name, the cat name, type {@link String}
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
		System.out.println("mananca insecte mici");
	}

	@Override
	public void play()
	{
		System.out.println("nu se joaca! ");
	}
}
