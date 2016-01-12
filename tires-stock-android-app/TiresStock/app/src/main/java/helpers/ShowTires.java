package helpers;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.lb.tiresstock.R;

import java.util.ArrayList;

import model.Tire;

/**
 * Created by paul-ioan.barbu on 10.01.2016.
 */
public class ShowTires {

    public static void showTires(Activity activity, TableLayout tableLayout, ArrayList<Tire> tires) {

        TableRow headerRow = new TableRow(activity);
        headerRow.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        for (int j = 0; j < tires.get(0).getNUMBER_OF_COLUMNS(); j++) {
            String[] col = {"Id ", "Brand ", "Size ", "Profile ", "Speed ", "Quantity ", "Price "};
            TextView columnsView = new TextView(activity);
            columnsView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            columnsView.setTextColor(Color.MAGENTA);
            columnsView.setBackgroundResource(R.drawable.border);
            columnsView.setPadding(5, 0, 0, 0);
            columnsView.setText(col[j]);
            columnsView.setTextSize(20);
            headerRow.addView(columnsView);
        }
        tableLayout.addView(headerRow);

        for (int i = 0; i < tires.size(); i++) {
            Log.d("tire", "" + i);
            Tire actualTire = tires.get(i);
            TableRow tableRow = new TableRow(activity);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

            for (int j = 0; j < actualTire.getNUMBER_OF_COLUMNS(); j++) {
                String[] col = {actualTire.getId() + " ", actualTire.getBrand() + " ", actualTire.getSize() + " ", actualTire.getProfile() + " ",
                        actualTire.getSpeed_rating() + " ", actualTire.getQuantity() + " ", actualTire.getPrice() + " "};
                TextView columnsView = new TextView(activity);
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
}
