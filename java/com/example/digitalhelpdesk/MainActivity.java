package com.example.digitalhelpdesk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;



public class MainActivity extends AppCompatActivity {
    public static final String index = "com.example.digitalhelpdesk.index";
    ArrayList<ArrayListObject> logo = new ArrayList<ArrayListObject>();
    GridView gridView;
    ProgressDialog ppg;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //loading user selected language
        loadLocale();

        setContentView(R.layout.activity_main);
        //Assign image id's to the logo arraylist
        getLogoImageId();
        gridView = findViewById(R.id.grid);

        AdapterMA logos = new AdapterMA(this, logo);
        gridView.setAdapter(logos);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gridView.setFocusableInTouchMode(false);
                ppg = new ProgressDialog(MainActivity.this);
                ppg.show();
                ppg.setContentView(R.layout.progress_bar);
                ppg.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra(index, position);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //get different items from menu as id
        int id = item.getItemId();

        //set task for each items
        if(id == R.id.appbar) {
            showChangeLanguageDialog();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            this.finishAffinity();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }

    private void showChangeLanguageDialog() {
        final String[] languages={"English", "हिंदी", "ગુજરતી"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(getString(R.string.change_language));
        builder.setSingleChoiceItems(languages, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int choice) {
                if(choice==0) {
                    setLocale("en");
                    recreate();
                } else if(choice == 1) {
                    setLocale("hi");
                    recreate();
                } else if(choice==2) {
                    setLocale("gu");
                    recreate();
                }

                dialog.dismiss();
            }
        });
        AlertDialog mdialog = builder.create();
        mdialog.show();;
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration= new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();
    }

    public  void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        setLocale(language);
    }

    private void getLogoImageId() {
        logo.add(new ArrayListObject(getString(R.string.paytm), R.drawable.paytm));
        logo.add(new ArrayListObject(getString(R.string.phonepay), R.drawable.phonepe));
        logo.add(new ArrayListObject(getString(R.string.gpay), R.drawable.gpay));
        logo.add(new ArrayListObject(getString(R.string.bhim), R.drawable.bhim));
        logo.add(new ArrayListObject(getString(R.string.mobiwik), R.drawable.mobikwik));
        logo.add(new ArrayListObject(getString(R.string.amazon), R.drawable.amazon));
        logo.add(new ArrayListObject(getString(R.string.yono), R.drawable.yono));
        logo.add(new ArrayListObject(getString(R.string.icici), R.drawable.icici));
        logo.add(new ArrayListObject(getString(R.string.kotak), R.drawable.kotak));
        logo.add(new ArrayListObject(getString(R.string.paypal), R.drawable.paypal));
    }
}