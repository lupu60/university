package helpers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragments.FarmerTires;
import fragments.SummerTires;
import fragments.WinterTires;

/**
 * Created by paul-ioan.barbu on 09.01.2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {

    int numOfTabs;

    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                SummerTires summerTires = new SummerTires();
                return summerTires;
            case 1:
                FarmerTires farmerTires = new FarmerTires();
                return farmerTires;
            case 2:
                WinterTires winterTires = new WinterTires();
                return winterTires;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Override
    public int getItemPosition(Object object){
        return PagerAdapter.POSITION_NONE;
    }
}

