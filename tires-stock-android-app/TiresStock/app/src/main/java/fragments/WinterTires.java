package fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.lb.tiresstock.MainActivity;
import com.lb.tiresstock.R;

import java.util.ArrayList;

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
            TableRow headerRow = new TableRow(getActivity());
            headerRow.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            for (int j = 0; j < winterTires.get(0).getNUMBER_OF_COLUMNS(); j++) {
                String[] col = {"Id ", "Brand ", "Size ", "Profile ", "Speed ", "Quantity ", "Price "};
                TextView columnsView = new TextView(getActivity());
                columnsView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                columnsView.setTextColor(Color.MAGENTA);
                columnsView.setBackgroundResource(R.drawable.border);
                columnsView.setPadding(5, 0, 0, 0);
                columnsView.setText(col[j]);
                columnsView.setTextSize(20);
                headerRow.addView(columnsView);
            }
            tableLayout.addView(headerRow);

            for (int i = 0; i < winterTires.size(); i++) {
                Log.d("tire", "" + i);
                Tire actualTire = winterTires.get(i);
                TableRow tableRow = new TableRow(getActivity());
                tableRow.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                for (int j = 0; j < actualTire.getNUMBER_OF_COLUMNS(); j++) {
                    String[] col = {actualTire.getId() + " ", actualTire.getBrand() + " ", actualTire.getSize() + " ", actualTire.getProfile() + " ",
                            actualTire.getSpeed_rating() + " ", actualTire.getQuantity() + " ", actualTire.getPrice() + " "};
                    TextView columnsView = new TextView(getActivity());
                    columnsView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                    columnsView.setBackgroundResource(R.drawable.border);
                    columnsView.setTextColor(Color.BLACK);
                    columnsView.setPadding(5, 0, 0, 0);
                    columnsView.setText(col[j]);
                    tableRow.addView(columnsView);

                }
                tableLayout.addView(tableRow);
            }
        }
        return v;
    }
}
