package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.lb.tiresstock.MainActivity;
import com.lb.tiresstock.R;

import java.util.ArrayList;

import helpers.ShowTires;
import model.Tire;

/**
 * Created by paul-ioan.barbu on 09.01.2016.
 */
public class WinterTires extends Fragment {

    private TableLayout tableLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.winter_tires, container, false);

        ArrayList<Tire> winterTires = MainActivity.store.getWinterTires();

        tableLayout = (TableLayout) v.findViewById(R.id.tab_layout);
        tableLayout.removeAllViews();

        if (winterTires != null) {
            ShowTires.showTires(getActivity(), tableLayout, winterTires);
        }
        return v;
    }
}
