package com.lb.tiresstock;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;

import fragments.AddUpdateTire;
import helpers.Configuration;
import helpers.PagerAdapter;
import helpers.ResponseHolder;
import helpers.Store;
import model.Tire;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView tiresInfoTextView;
    private Button loadTiresButton;
    public static Store store = new Store();
    private TabLayout tabLayout;
    public static final String ADD_TIRE_FRAGMENT_TAG = "ADD_TIRE_FRAGMENT_TAG";
    public static final String SUMMER = "Summer";
    public static final String WINTER = "Winter";
    public static final String FARMER = "Farmer";
    private static int currentTabPosition;
    private int index;
    public static MainActivity mainActivity;
    private PagerAdapter adapter;
    private final String UPDATE = "Update";
    private final String DELETE = "Delete";

    public TextView getTiresInfoTextView() {
        return tiresInfoTextView;
    }

    public void setTiresInfoTextView(TextView tiresInfoTextView) {
        this.tiresInfoTextView = tiresInfoTextView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivity = this;

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(SUMMER));
        tabLayout.addTab(tabLayout.newTab().setText(FARMER));
        tabLayout.addTab(tabLayout.newTab().setText(WINTER));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag(ADD_TIRE_FRAGMENT_TAG);
                if (fragment != null)
                    getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                viewPager.setCurrentItem(tab.getPosition());
                currentTabPosition = tab.getPosition();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tiresInfoTextView = (TextView) findViewById(R.id.tires_info_text_view);
        loadTiresButton = (Button) findViewById(R.id.load_tires_button);
        loadTiresButton.setOnClickListener(loadTiresListener());
    }

    private View.OnClickListener loadTiresListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = 0;
                // WebServer Request URL
                String[] serverURLs = {Configuration.SUMMER_TIRES_URL, Configuration.WINTER_TIRES_URL, Configuration.FARMER_TIRES_URL};

                for (int i = 0; i < serverURLs.length; i++) {
                    new ShowTires().execute(serverURLs[i]);
                }
            }
        };
    }

    private class ShowTires extends AsyncTask<String, Void, Void> {

        private ProgressDialog Dialog = new ProgressDialog(MainActivity.this);
        OkHttpClient client = new OkHttpClient();
        ResponseHolder responseHolder;
        String info;

        protected void onPreExecute() {
            Dialog.setMessage("Please wait..");
            Dialog.show();
        }

        protected Void doInBackground(String... urls) {

            Request request = new Request.Builder()
                    .url(urls[0])
                    .build();

            try {
                Response response = client.newCall(request).execute();
                Gson gson = new Gson();
                responseHolder = gson.fromJson(response.body().string(), ResponseHolder.class);

                info = "Tires LOADED successfully!";
            } catch (IOException e) {
                info = e.getMessage();
            }
            return null;
        }

        protected void onPostExecute(Void unused) {
            Dialog.dismiss();
            if (index == 0) {
                store.setSummerTires(responseHolder.getTires());
                index++;
            } else if (index == 1) {
                store.setWinterTires(responseHolder.getTires());
                index++;
            } else if (index == 2) {
                store.setFarmerTires(responseHolder.getTires());
                index++;
                adapter.notifyDataSetChanged();
            }
            tiresInfoTextView.setText(info);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add_tire) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragment addTireFragment = new AddUpdateTire();
            transaction.replace(R.id.fragment_place, addTireFragment, ADD_TIRE_FRAGMENT_TAG);
            transaction.addToBackStack(ADD_TIRE_FRAGMENT_TAG).commit();

        } else if (id == R.id.action_update_tire) {
            setInsertIdWindow(UPDATE);

        } else if (id == R.id.action_delete_tire) {
            setInsertIdWindow(DELETE);
        }

        return super.onOptionsItemSelected(item);
    }

    private void setInsertIdWindow(final String operation) {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.insert_id_dialog);
        dialog.setTitle("Please insert the id!");
        dialog.setCancelable(false);

        final EditText idEditText = (EditText) dialog.findViewById(R.id.insert_id_edit_text);

        Button okButton = (Button) dialog.findViewById(R.id.confirmation_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!idEditText.getText().toString().isEmpty()) {

                    final Tire foundTire = store.getTireFromId(getTiresAccordingToTabView(),
                            Integer.parseInt(idEditText.getText().toString()));

                    if (foundTire != null) {

                        if (operation.equalsIgnoreCase(UPDATE)) {

                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            final Fragment addTireFragment = new AddUpdateTire();
                            transaction.replace(R.id.fragment_place, addTireFragment, ADD_TIRE_FRAGMENT_TAG);
                            transaction.addToBackStack(ADD_TIRE_FRAGMENT_TAG).commit();

                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    ((AddUpdateTire) addTireFragment).prefillFields(foundTire);
                                }
                            }, 100);

                        } else if (operation.equalsIgnoreCase(DELETE)) {

                            Gson gson = new Gson();
                            String jsonTire = gson.toJson(foundTire);

                            new DeleteTires().execute(getURLFromActualTabView(), jsonTire);
                        }
                        dialog.dismiss();
                    } else
                        Toast.makeText(getApplicationContext(), "No data found with id: #" + idEditText.getText().toString() +
                                " Please try again!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter the id!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button cancelButton = (Button) dialog.findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private class DeleteTires extends AsyncTask<String, Void, Void> {

        private ProgressDialog Dialog = new ProgressDialog(MainActivity.this);
        OkHttpClient client = new OkHttpClient();
        String info;

        protected void onPreExecute() {
            Dialog.setMessage("Please wait..");
            Dialog.show();
        }

        protected Void doInBackground(String... urls) {

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, urls[1]);

            Request request = new Request.Builder()
                    .url(urls[0])
                    .delete(body)
                    .addHeader("content-type", "application/json")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                String responseHolder = response.message();

                info = "Tires DELETED successfully: " + responseHolder;
            } catch (IOException e) {
                info = e.getMessage();
            }
            return null;
        }

        protected void onPostExecute(Void unused) {
            Dialog.dismiss();
            tiresInfoTextView.setText(info);
        }
    }

    private ArrayList<Tire> getTiresAccordingToTabView() {
        switch (currentTabPosition) {
            case 0:
                return store.getSummerTires();
            case 1:
                return store.getFarmerTires();
            case 2:
                return store.getWinterTires();
            default:
                return null;
        }
    }

    public static String getURLFromActualTabView() {
        switch (currentTabPosition) {
            case 0:
                return Configuration.SUMMER_TIRES_URL;
            case 1:
                return Configuration.FARMER_TIRES_URL;
            case 2:
                return Configuration.WINTER_TIRES_URL;
            default:
                return null;
        }
    }


}
