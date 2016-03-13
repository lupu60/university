import java.util.Scanner;
import java.util.ArrayList;

public class Test {
///test tema2
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		//new model
		ArrayList<Accessory> accessories3 = new ArrayList<>();
		
		//actual models
		Engine d100 = new Engine("diesel", 100, 1990, 300);
		Color blue = new Color(123, "blue", 50);
		ArrayList<Accessory> accessories1 = new ArrayList<>();
		accessories1.add(new Accessory("wheels", 100));
		accessories1.add(new Accessory("air conditioning", 100));
		accessories1.add(new Accessory("radio", 30));
		accessories1.add(new Accessory("electric windows front", 230));
		accessories1.add(new Accessory("gear auto", 400));
		accessories1.add(new Accessory("airbag", 150));
		Car logan = new Car("Logan", d100, blue, accessories1, 10000);


		Engine p120 = new Engine("petrol", 120, 2100, 400);
		Color black = new Color(133, "black", 60);
		ArrayList<Accessory> accessories2 = new ArrayList<>();
		accessories2.add(new Accessory("chrome wheels", 200));
		accessories2.add(new Accessory("climatronic air", 200));
		accessories2.add(new Accessory("radio CD/MP3", 50));
		accessories2.add(new Accessory("gear manual", 200));
		accessories2.add(new Accessory("electric windows full", 500));
		accessories2.add(new Accessory("airbag fulpack", 400));
		Car sandero = new Car("Sandero", p120, black, accessories2, 9000);
		// var
		byte opt = 0;
		byte nr = -1;
		//car
		String name;
		double carprice;
		//engine
		String fuel;
		int hp;
		int cm3;
		double eprice;
		//color
		int code;
		String type;
		double cprice;
		//accessory
        String acname;
	    double aprice;
				
		
	     while (opt != 3) {
		System.out
				.print("Welcome\n #1 Show Models \n #2 Create Model \n #3 Exit \n #?=");
		 opt = keyboard.nextByte();
         
		switch (opt) {
		case 1://#1 Show Models 

		 while (opt != -1) {	   
			System.out.print("Show specifications \n #1 Dacia Logan \n #2 Dacia Sandero \n #3 Back \n #?=");
			opt = keyboard.nextByte();
			
						switch (opt) {
						case 1://Logan
							while (opt != -2) {	
							System.out.println(logan.toString());
							System.out.print("#1 Add Accessory \n #2 Remove Accessory \n #3 Buy this car \n #4 Back \n #?=");
							opt = keyboard.nextByte();
							System.out.println("");    
													switch (opt) {
													case 1://add accessory
														System.out
																.println("Choose accessory from list:");
													   for (int i = 0; i < accessories2.size(); i++) {
														   System.out
																.print("#"+i+accessories2.get(i));
														
													}System.out
															.print("#?=");
													   nr = keyboard.nextByte();
													   accessories1.add(accessories2.get(nr));
														break;
														
													case 2://remove accessory
																System.out
																.println("Choose accessory from list:");
													   for (int i = 0; i < accessories1.size(); i++) {
														   System.out
																.print("#"+i+accessories1.get(i));
														
													}System.out
															.print("#?=");
													   nr = keyboard.nextByte();
													   accessories1.remove(nr);
														break;
														
													case 3://buy car
													System.out
															.println("Congratulations!");	
													opt=0;
													System.out
															.println("\n");
													break;
													case 4:
														opt=-2;
														break;
													default:System.out
															.println("Wrong #!");
														break;
													}
							                         
							
							
							}
							break;
						
						case 2://Sandero
							while (opt != -2) {	
							System.out.println(sandero.toString());
							System.out.print("#1 Add Accessory \n #2 Remove Accessory \n #3 Buy this car \n #4 Back \n #?=");
							opt = keyboard.nextByte();
							System.out.println("");
															switch (opt) {
															case 1://add accessory
																System.out
																		.println("Choose accessory from list:");
															   for (int i = 0; i < accessories1.size(); i++) {
																   System.out
																		.print("#"+i+accessories1.get(i));
																
															}System.out
																	.print("#?=");
															   nr = keyboard.nextByte();
															   accessories2.add(accessories1.get(nr));
																break;
																
															case 2://remove accessory
																		System.out
																		.println("Choose accessory from list:");
															   for (int i = 0; i < accessories2.size(); i++) {
																   System.out
																		.print("#"+i+accessories2.get(i));
																
															}System.out
																	.print("#?=");
															   nr = keyboard.nextByte();
															   accessories2.remove(nr);
																break;
																
															case 3://buy car
															System.out
																	.println("Congratulations!");	
															opt=0;
															System.out
																	.println("\n");
															break;
														case 4:
															opt = -2;
															break;
														default:
															System.out.println("Wrong #!");
															break;
														}
							
							}
							break;
						case 3:
							opt=-1;
							break ;
						default:System.out
						.println("Wrong #!!");
							break;
						}
			             
		     }
		break;
		     	
		case 2://#2 Create Model
	
			loop3: while (opt!=-3){
			System.out.println("Defines name and price");		
			name=keyboard.next();
			carprice=keyboard.nextDouble();
			//defines engine
			System.out.println("Defines engine: fuel | hp| cm3| price  *press enter after each");
			fuel=keyboard.next();
			hp=keyboard.nextInt();
			cm3=keyboard.nextInt();
			eprice=keyboard.nextDouble();
			Engine custome = new Engine(fuel, hp, cm3, eprice);
			//defines color
			System.out.println("Defines color: code| type| price *press enter after each");
			code=keyboard.nextInt();
			type=keyboard.next();
			cprice=keyboard.nextDouble();
			Color customc = new Color(code, type, cprice);
			//accessories
			loop1:while(opt!= -2){
			System.out.print("Defines accessories: \n #1 Choose list of accessories: \n #2 Create list of accessories \n #3 Back \n #?= ");
			opt=keyboard.nextByte();
												switch (opt) {
												case 1:// choose list of accessories
													 while (opt != -1) {	   
													System.out.print("#1 Show list of logan \n #2 Show list of sandero \n #3 Back \n #?=");
													opt=keyboard.nextByte();
																switch (opt) {
																case 1://logan
																	  for (int i = 0; i < accessories1.size(); i++) {
																		   System.out
																				.print("#"+i+accessories1.get(i));}
																	  System.out
																			.println("#1 Use or #2 Back");
																	  opt=keyboard.nextByte();
																	  if(opt==1){
																		 accessories3=accessories1;
																		 break loop1;
																	  }else{}
																	
																	
																	break;
																case 2://sandero
																	  for (int i = 0; i < accessories2.size(); i++) {
																		   System.out
																				.print("#"+i+accessories2.get(i));}
																	  System.out
																			.println("#1 Use or #2 Back");
																	  opt=keyboard.nextByte();
																	  if(opt==1){
																		 accessories3=accessories2;
																		 break loop1;
																	  }else{}
																	
																	break;
																case 3:opt=-1;
																	break;
																default:System.out
																.println("Wrong #!!");
																	break;
																}
													 }
													break;
												case 2://create list
													while(opt != -1){
														System.out
																.println("#1 Add accessory \n #2 View list of accessories \n #3 Use list \n #?=");
														opt=keyboard.nextByte();
														switch (opt) {
														case 1:System.out
																.print("Name=");
														acname=keyboard.next();
														System.out
																.print("Price=");
														aprice=keyboard.nextDouble();
														accessories3.add(new Accessory(acname, aprice));
															break;
														case 2:
															 for (int i = 0; i < accessories3.size(); i++) {
																   System.out
																		.print("#"+i+accessories3.get(i));}
															
															break;
														case 3:
															opt=-1;
															break;

														default:System.out
														.println("Wrong #!!");
															break;
														}
														
														
													}
													break;
												case 3:
													opt=-2;
													break;
												default:System.out
												.println("Wrong #!!");
													break;
												}
						}
			Car customcar = new Car(name, custome, customc, accessories3, carprice);
			while(opt!=-4){
			System.out.println("#1 View Car \n #2 Finish and buy");
			opt=keyboard.nextByte();
			switch (opt) {
			case 1:
							System.out.println(customcar.toString());
							break;
						case 2:
							System.out.println("Congratulations!");
							opt = -4;
							break loop3;
						default:
							System.out.println("Wrong #!");
							break;
						}
					}
			}
	break;

		case 3:
			System.out.println("Goodbye");
			break;
		default:System.out
		.println("Wrong #!");
			break ;
		}

	     }

	}

}
