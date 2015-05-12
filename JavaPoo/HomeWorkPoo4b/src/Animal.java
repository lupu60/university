public abstract class Animal
{

	protected int legs;
	/**
	 * This Constructor initializes Animal with the null parameter
	 */
	public Animal()
	{
		legs = 0;
	
	}

	/**
	 * This Constructor initalizes Cat with the parameters given
	 * 
	 * @param legs
	 *            - the legs, type {@link int}
	 * 
	 */
	public Animal(int legs)
	{
		this.legs = legs;

	}

	/**
	 * This method returns the number of legs
	 * 
	 * @return legs - the number of legs, type {@link int}
	 */
	public int getLegs()
	{
		return legs;
	}

	/**
	 * This method sets the number of legs with the number given as parameter
	 * 
	 * @param setez
	 *            -the number of legs, type {@link int}
	 * @return void
	 */
	public void setLegs(int setez)
	{
		this.legs = setez;
	}

	public String toString()
	{
		return this.legs + " " ;
	}

	/**
	 * This method returns a message that the animal walk
	 * 
	 * @return void
	 */
	public void walk()
	{
		System.out.println("merge");
	}

	public abstract void eat();
}
