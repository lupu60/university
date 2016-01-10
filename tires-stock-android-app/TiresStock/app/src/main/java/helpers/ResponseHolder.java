package helpers;

import java.util.ArrayList;

import model.Tire;

/**
 * Created by paul-ioan.barbu on 09.01.2016.
 */
public class ResponseHolder {
    private ArrayList<Tire> tires;

    public ArrayList<Tire> getTires() {
        return tires;
    }

    @Override
    public String toString() {
        return "ResponseHolder{" +
                "tires=" + tires +
                '}';
    }
}
