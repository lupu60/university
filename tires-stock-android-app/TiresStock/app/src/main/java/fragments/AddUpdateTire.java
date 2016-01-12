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

import model.Tire;

/**
 * Created by paul-ioan.barbu on 10.01.2016.
 */
public class AddUpdateTire extends Fragment {

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
    private String jsonString;
    private int idForUpdate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.add_update_tire, container, false);

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
                Tire actualTire = new Tire();
                String brand = brandEditText.getText().toString();
                String size = sizeEditText.getText().toString();
                String profile = profiledEditText.getText().toString();
                String speedRating = speedRatingEditText.getText().toString();
                String quantity = quantityEditText.getText().toString();
                String price = priceEditText.getText().toString();

                if (!brand.isEmpty() && !size.isEmpty() && !profile.isEmpty() && !speedRating.isEmpty() &&
                        !quantity.isEmpty() && !price.isEmpty()) {

                    actualTire.setBrand(brand);
                    actualTire.setSize(size);
                    actualTire.setProfile(profile);
                    actualTire.setSpeed_rating(speedRating);

                    if (android.text.TextUtils.isDigitsOnly(quantity) && android.text.TextUtils.isDigitsOnly(price)) {

                        actualTire.setQuantity(Integer.parseInt(quantity));
                        actualTire.setPrice(Integer.parseInt(price));

                        Gson gson;
                        if (isUpdatingItem()) {
                            actualTire.setId(idForUpdate);
                            gson = new Gson();
                        } else {
                            gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                        }

                        jsonString = gson.toJson(actualTire);

                        Log.e("Tire json", jsonString);

                        String actualURL = MainActivity.getURLFromActualTabView();
                        new AddUpdate().execute(actualURL);

                        cancelButton.performClick();
                    } else {
                        Toast.makeText(getActivity(), "Please check quantity or number. They must be numbers!", Toast.LENGTH_SHORT).show();
                    }

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

        idForUpdate = tire.getId();

        brandEditText.setText(tire.getBrand());
        sizeEditText.setText(tire.getSize());
        profiledEditText.setText(tire.getProfile());
        speedRatingEditText.setText(tire.getSpeed_rating());
        quantityEditText.setText("" + tire.getQuantity());
        priceEditText.setText("" + tire.getPrice());

        addButton.setText(UPDATE);
    }

    public boolean isUpdatingItem() {
        if (addButton.getText().toString().equalsIgnoreCase(UPDATE)) {
            return true;
        } else {
            return false;
        }
    }

    private class AddUpdate extends AsyncTask<String, Void, Void> {

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
            RequestBody body = RequestBody.create(mediaType, jsonString);
            Request request;

            if (isUpdatingItem()) {
                request = new Request.Builder()
                        .url(urls[0])
                        .post(body)
                        .addHeader("content-type", "application/json")
                        .build();

            } else {
                request = new Request.Builder()
                        .url(urls[0])
                        .put(body)
                        .addHeader("content-type", "application/json")
                        .build();
            }

            try {
                Response response = client.newCall(request).execute();
                responseHolder = response.message();

                if (isUpdatingItem())
                    info = "Tire UPDATED successfully: " + responseHolder;
                else
                    info = "Tire ADDED successfully: " + responseHolder;

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