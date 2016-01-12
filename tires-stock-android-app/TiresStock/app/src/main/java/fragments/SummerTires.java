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
public class SummerTires extends Fragment {

    TableLayout tableLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.summer_tires, container, false);

        ArrayList<Tire> summerTires = MainActivity.store.getSummerTires();

        tableLayout = (TableLayout) v.findViewById(R.id.tab_layout);
        tableLayout.removeAllViews();

        if (summerTires != null) {
            ShowTires.showTires(getActivity(), tableLayout, summerTires);
        }
        return v;
    }
}
