package helpers;

import java.util.ArrayList;

import model.Tire;

/**
 * Created by paul-ioan.barbu on 09.01.2016.
 */
public class Store {

    private ArrayList<Tire> winterTires;
    private ArrayList<Tire> summerTires;
    private ArrayList<Tire> farmerTires;

    public ArrayList<Tire> getWinterTires() {
        return winterTires;
    }

    public void setWinterTires(ArrayList<Tire> winterTires) {
        this.winterTires = winterTires;
    }

    public ArrayList<Tire> getSummerTires() {
        return summerTires;
    }

    public void setSummerTires(ArrayList<Tire> summerTires) {
        this.summerTires = summerTires;
    }

    public ArrayList<Tire> getFarmerTires() {
        return farmerTires;
    }

    public void setFarmerTires(ArrayList<Tire> farmerTires) {
        this.farmerTires = farmerTires;
    }
}
