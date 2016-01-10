package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lb.tiresstock.R;

/**
 * Created by paul-ioan.barbu on 09.01.2016.
 */
public class SummerTires extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.summer_tires, container, false);
    }
}
