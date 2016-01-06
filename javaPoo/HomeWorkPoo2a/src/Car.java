import java.text.NumberFormat;
import java.util.ArrayList;


public class Car {
private String name;
private Engine engine;
private Color color;
private ArrayList<Accessory> accessories;
private double price;	
private double taprice;

public Car(String name,Engine engine, Color color ,ArrayList<Accessory> accessories,double price){
    this.name=name;
	this.engine=engine;
	this.color=color;
	this.accessories=accessories;
	this.price=price;
	
}
public Car(){
	name=null;
	engine=null;
	color=null;
	accessories=null;
	price=0;
}
public Engine getEngine() {
	return engine;
}
public void setEngine(Engine engine) {
	this.engine = engine;
}
public Color getColor() {
	return color;
}
public void setColor(Color color) {
	this.color = color;
}
public ArrayList<Accessory> getAccessories() {
	return accessories;
}
public void setAccessories(ArrayList<Accessory> accessories) {
	this.accessories = accessories;
}
public double getPrice() {
	for(Accessory accessory1:accessories){
		taprice+=accessory1.getPrice();
	}
	return engine.getPrice()+color.getPrice()+taprice+price;
}
public void setPrice(double price) {
	this.price = price;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
			+ ((accessories == null) ? 0 : accessories.hashCode());
	result = prime * result + ((color == null) ? 0 : color.hashCode());
	result = prime * result + ((engine == null) ? 0 : engine.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	Car other = (Car) obj;
	if (accessories == null) {
		if (other.accessories != null)
			return false;
	} else if (!accessories.equals(other.accessories))
		return false;
	if (color == null) {
		if (other.color != null)
			return false;
	} else if (!color.equals(other.color))
		return false;
	if (engine == null) {
		if (other.engine != null)
			return false;
	} else if (!engine.equals(other.engine))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
		return false;
	return true;
}
public int findAccessory(Accessory accessory){
	for(Accessory accessory1:accessories){
		if(accessory.equals(accessory1)){
			return 0;
		}
	}
	return -1;
}
public void addAccessory(Accessory accessory){
	if(findAccessory(accessory)==-1){
		accessories.add(accessory);
	}
	else 
		System.out.println("Accessory exist");
}

public void removeAccessory(Accessory accessory){
	if(findAccessory(accessory)!=-1){
		accessories.remove(accessory);
	}
	else 
		System.out.println("Accessory does not exist");
}

@Override
public String toString() {
	for(Accessory accessory1:accessories){
		taprice+=accessory1.getPrice();
	}
	
	return "Car: "+name+"\n|||" + engine + "|||\n|||" + color + "|||\n||| Accessories=\n"
			+ accessories + "\n||| total price=" + NumberFormat.getCurrencyInstance().format((engine.getPrice()+color.getPrice()+taprice+price))+ "|||";
}

}
