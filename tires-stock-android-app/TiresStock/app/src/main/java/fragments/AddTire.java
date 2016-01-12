package fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lb.tiresstock.MainActivity;
import com.lb.tiresstock.R;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import helpers.Configuration;
import model.Tire;

/**
 * Created by paul-ioan.barbu on 10.01.2016.
 */
public class AddTire extends Fragment {

    private EditText brandEditText;
    private EditText sizeEditText;
    private EditText profiledEditText;
    private EditText speedRatingEditText;
    private EditText quantityEditText;
    private EditText priceEditText;

    private Button addButton;
    private Button cancelButton;

    private final String ADD = "Add";
    private final String UPDATE = "Update";
    private String addJsonString;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.add_tire, container, false);

        brandEditText = (EditText) v.findViewById(R.id.brand_edit_text);
        sizeEditText = (EditText) v.findViewById(R.id.size_edit_text);
        profiledEditText = (EditText) v.findViewById(R.id.profile_edit_text);
        speedRatingEditText = (EditText) v.findViewById(R.id.speed_rating_edit_text);
        quantityEditText = (EditText) v.findViewById(R.id.quantity_edit_text);
        priceEditText = (EditText) v.findViewById(R.id.price_edit_text);

        addButton = (Button) v.findViewById(R.id.add_button);
        addButton.setOnClickListener(addButtonListener());
        cancelButton = (Button) v.findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(cancelButtonListener());

        return v;
    }

    private View.OnClickListener addButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(addButton.getText().toString().equalsIgnoreCase(ADD)){
                Tire tireToAdd = new Tire();
                String brand = brandEditText.getText().toString();
                String size = sizeEditText.getText().toString();
                String profile = profiledEditText.getText().toString();
                String speedRating = speedRatingEditText.getText().toString();
                String quantity = quantityEditText.getText().toString();
                String price = priceEditText.getText().toString();

                if (!brand.isEmpty() && !size.isEmpty() && !profile.isEmpty() && !speedRating.isEmpty() &&
                        !quantity.isEmpty() && !price.isEmpty()) {

                    tireToAdd.setBrand(brand);
                    tireToAdd.setSize(size);
                    tireToAdd.setProfile(profile);
                    tireToAdd.setSpeed_rating(speedRating);
                    tireToAdd.setQuantity(quantity);
                    tireToAdd.setPrice(price);

                    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                    addJsonString = gson.toJson(tireToAdd);

                    Log.e("Tire json", addJsonString);

                    String actualTab = MainActivity.getActualTabView();

                    if (actualTab.equals(MainActivity.SUMMER)) {
                        new Add().execute(Configuration.SUMMER_TIRES_URL);
                    }
                    if (actualTab.equals(MainActivity.WINTER)) {
                        new Add().execute(Configuration.WINTER_TIRES_URL);
                    }

                    cancelButton.performClick();
                } else {
                    Toast.makeText(getActivity(), "Please fill all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    private View.OnClickListener cancelButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        };
    }

    public void prefillFields(Tire tire) {
        brandEditText.setText(tire.getBrand());
        sizeEditText.setText(tire.getSize());
        profiledEditText.setText(tire.getProfile());
        speedRatingEditText.setText(tire.getSpeed_rating());
        quantityEditText.setText(tire.getQuantity());
        priceEditText.setText(tire.getPrice());

        addButton.setText(UPDATE);
    }

    private class Add extends AsyncTask<String, Void, Void> {

        private ProgressDialog Dialog = new ProgressDialog(MainActivity.mainActivity);
        OkHttpClient client = new OkHttpClient();
        String responseHolder;
        String info;

        protected void onPreExecute() {
            Dialog.setMessage("Please wait..");
            Dialog.show();
        }

        protected Void doInBackground(String... urls) {

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n  \"brand\": \"TI12123231\",\n  \"size\": \"225/70R15C\",\n  \"profile\": \"PASSIO\",\n  \"speed_rating\": \"q\",\n  \"price\": 460,\n  \"quantity\": 3\n}");
            Request request = new Request.Builder()
                    .url(urls[0])
                    .put(body)
                    .addHeader("content-type", "application/json")
                    .build();

            Log.e("Tag", "{\n  \"brand\": \"TI12123231\",\n  \"size\": \"225/70R15C\",\n  \"profile\": \"PASSIO\",\n  \"speed_rating\": \"q\",\n  \"price\": 460,\n  \"quantity\": 3\n}");

            try {
                Response response = client.newCall(request).execute();
                responseHolder = response.message();

                info = "Tire added successfully: " + responseHolder;
            } catch (IOException e) {
                info = e.getMessage();
            }
            return null;
        }

        protected void onPostExecute(Void unused) {
            Dialog.dismiss();
            MainActivity.mainActivity.getTiresInfoTextView().setText(info);
        }
    }
}