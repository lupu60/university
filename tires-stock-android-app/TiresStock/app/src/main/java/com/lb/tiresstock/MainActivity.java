package com.lb.tiresstock;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import helpers.PagerAdapter;
import helpers.ResponseHolder;
import helpers.Store;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView showTiresTextView;
    private Button showTiresButton;
    public static Store store = new Store();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("SUMMER"));
        tabLayout.addTab(tabLayout.newTab().setText("FARMER"));
        tabLayout.addTab(tabLayout.newTab().setText("WINTER"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        showTiresTextView = (TextView) findViewById(R.id.show_tires_text_view);
        showTiresButton = (Button) findViewById(R.id.show_tires_button);
        showTiresButton.setOnClickListener(showTiresListener());
    }

    private View.OnClickListener showTiresListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // WebServer Request URL
                String serverURL = "https://tires-stock.herokuapp.com/summer_tire";

                // Use AsyncTask execute Method To Prevent ANR Problem
                new ShowTires().execute(serverURL);

            }
        };
    }

    private class ShowTires extends AsyncTask<String, Void, Void> {

        private String content;
        private String error = null;
        private ProgressDialog Dialog = new ProgressDialog(MainActivity.this);
        private String data = "";
        private ResponseHolder responseHolder = null;

        protected void onPreExecute() {

            Dialog.setMessage("Please wait..");
            Dialog.show();

/*
            try {
                // Set Request parameter
                data += "&" + URLEncoder.encode("data", "UTF-8") + "=" + serverText.getText();

            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
*/

        }

        protected Void doInBackground(String... urls) {

            BufferedReader reader = null;

            try {

                URL url = new URL(urls[0]);
                URLConnection conn = url.openConnection();

                // Send POST data request

/*              conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(data);
                wr.flush()*/
                ;

                // Get the server response

                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuffer sb = new StringBuffer("");
                String line;

                String NL = System.getProperty("line.separator");
                while ((line = reader.readLine()) != null) {
                    sb.append(line + NL);
                }

                content = sb.toString();

            } catch (Exception ex) {
                error = ex.getMessage();
            } finally {
                try {

                    reader.close();
                } catch (Exception ex) {
                }
            }

            return null;
        }

        protected void onPostExecute(Void unused) {

            Dialog.dismiss();

            if (error != null) {

                showTiresTextView.setText("Output : " + error);

            } else {

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                responseHolder = gson.fromJson(content, ResponseHolder.class);
                store.setWinterTires(responseHolder.getTires());

                // Show Response Json On Screen (activity)
                showTiresTextView.setText(responseHolder.getTires().get(0).getBrand() + ", size: " + responseHolder.getTires().get(0).getSize());
            }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
