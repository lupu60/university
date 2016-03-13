public class Test
{
	/**
	 * This method verify if an animal is pet. If it is true will call play else
	 * return a message
	 * 
	 * @param a
	 *            -type {@link Animal}
	 */
	public static void playWithAnimal(Animal a)
	{
		if (a instanceof Pet)
			((Pet) a).play();
		else
			System.out.println("nu este de tip pet!");
	}

	public static void main(String[] args)
	{

		Cat c = new Cat(4, "garfield");
		System.out.println(c);
		playWithAnimal(c);
		c.play();
		c.eat();
		c.walk();
		System.out.println("-----------------------------------");
		Spider s = new Spider(8, "Spider-man");
		System.out.println(s);
		playWithAnimal(s);
		s.play();
		s.eat();
		s.walk();
		System.out.println("-----------------------------------");
		Fish f = new Fish(0, "Nemo");
		System.out.println(f);
		playWithAnimal(f);
		f.play();
		f.eat();
		f.walk();
	}

}
