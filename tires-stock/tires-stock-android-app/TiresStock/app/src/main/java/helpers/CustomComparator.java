package helpers;

import java.util.Comparator;

import model.Tire;

/**
 * Created by paul-ioan.barbu on 12.01.2016.
 */
public class CustomComparator implements Comparator<Tire> {
    @Override
    public int compare(Tire o1, Tire o2) {
        return o1.getId() - o2.getId();
    }
}