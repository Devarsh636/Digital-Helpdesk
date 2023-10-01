package com.example.digitalhelpdesk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    public static final String position = "com.example.digitalhelpdesk.position";
    public static final String index = "com.example.digitalhelpdesk.index";
    ArrayList<ArrayListObject> data = new ArrayList<ArrayListObject>();
    GridView gridView;
    ProgressDialog ppg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //loading user selected language
        loadLocale();
        setContentView(R.layout.activity_main2);

        //This will take position from MainActivity to MainActivity2
        //We must assign value inside onCreate method because intent calls directly that method
        int num_application = getIntent().getIntExtra(MainActivity.index, 0);

        //assign grid view xml code to gridView
        gridView = findViewById(R.id.gridview);

        //set values for array list
        setValues(num_application);

        AdapterMA2 h = new AdapterMA2(MainActivity2.this, data);
        gridView.setAdapter(h);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int num_activity, long id) {
                ppg = new ProgressDialog(MainActivity2.this);
                ppg.show();
                ppg.setContentView(R.layout.progress_bar);
                ppg.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra(position, num_application);
                intent.putExtra(index, num_activity);
                startActivity(intent);
            }
        });

        Button changelanguage =findViewById(R.id.changed_language);
        changelanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLanguageDialog();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }

    private void showChangeLanguageDialog() {
        final String[] languages={"English", "हिंदी", "ગુજરતી"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
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
        mdialog.show();
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

    private void setValues(int position) {
        //find image by id
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        if (position==0) {
            imageView.setImageResource(R.drawable.ptm);

            data.add(new ArrayListObject(getString(R.string.pay), R.drawable.ptm_pay));
            data.add(new ArrayListObject(getString(R.string.upi), R.drawable.ptm_upi));
            data.add(new ArrayListObject(getString(R.string.add_money), R.drawable.ptm_addm));
            data.add(new ArrayListObject(getString(R.string.mobile_recharge), R.drawable.ptm_mobile));
            data.add(new ArrayListObject(getString(R.string.tv), R.drawable.ptm_tv));
            data.add(new ArrayListObject(getString(R.string.credit_card), R.drawable.ptm_creditcard));
            data.add(new ArrayListObject(getString(R.string.cylinder_gas), R.drawable.ptm_cylinder));
            data.add(new ArrayListObject(getString(R.string.pipeline_gas), R.drawable.ptm_gas));
            data.add(new ArrayListObject(getString(R.string.electricity), R.drawable.ptm_electricity));
            data.add(new ArrayListObject(getString(R.string.water), R.drawable.ptm_water));
            data.add(new ArrayListObject(getString(R.string.broad_band), R.drawable.ptm_broadband));
            data.add(new ArrayListObject(getString(R.string.subscription), R.drawable.ptm_subscription));
            data.add(new ArrayListObject(getString(R.string.education), R.drawable.ptm_education));
            data.add(new ArrayListObject(getString(R.string.loan), R.drawable.ptm_loan));
            data.add(new ArrayListObject(getString(R.string.rent), R.drawable.ptm_rent));
        } else if (position==1) {
            imageView.setImageResource(R.drawable.pp);

            data.add(new ArrayListObject(getString(R.string.mobile_recharge), R.drawable.pp_mobile));
            data.add(new ArrayListObject(getString(R.string.tv), R.drawable.pp_tv));
            data.add(new ArrayListObject(getString(R.string.credit_card), R.drawable.pp_creditcard));
            data.add(new ArrayListObject(getString(R.string.cylinder_gas), R.drawable.pp_cylinder));
            data.add(new ArrayListObject(getString(R.string.pipeline_gas), R.drawable.pp_gas));
            data.add(new ArrayListObject(getString(R.string.electricity), R.drawable.pp_electricity));
            data.add(new ArrayListObject(getString(R.string.water), R.drawable.pp_water));
            data.add(new ArrayListObject(getString(R.string.broad_band), R.drawable.pp_broadband));
            data.add(new ArrayListObject(getString(R.string.subscription), R.drawable.pp_subscription));
            data.add(new ArrayListObject(getString(R.string.education), R.drawable.pp_education));
            data.add(new ArrayListObject(getString(R.string.loan), R.drawable.pp_loan));
            data.add(new ArrayListObject(getString(R.string.rent), R.drawable.pp_rent));
        } else if (position==2) {
            imageView.setImageResource(R.drawable.gp);

            data.add(new ArrayListObject(getString(R.string.mobile_recharge), R.drawable.ptm_mobile));
            data.add(new ArrayListObject(getString(R.string.tv), R.drawable.ptm_tv));
            data.add(new ArrayListObject(getString(R.string.credit_card), R.drawable.ptm_creditcard));
            data.add(new ArrayListObject(getString(R.string.cylinder_gas), R.drawable.ptm_cylinder));
            data.add(new ArrayListObject(getString(R.string.pipeline_gas), R.drawable.ptm_gas));
            data.add(new ArrayListObject(getString(R.string.electricity), R.drawable.ptm_electricity));
            data.add(new ArrayListObject(getString(R.string.water), R.drawable.ptm_water));
            data.add(new ArrayListObject(getString(R.string.broad_band), R.drawable.ptm_broadband));
            data.add(new ArrayListObject(getString(R.string.subscription), R.drawable.ptm_subscription));
            data.add(new ArrayListObject(getString(R.string.education), R.drawable.ptm_education));
            data.add(new ArrayListObject(getString(R.string.loan), R.drawable.ptm_loan));
            data.add(new ArrayListObject(getString(R.string.rent), R.drawable.ptm_rent));
        } else if (position==3) {
            imageView.setImageResource(R.drawable.bh);

            data.add(new ArrayListObject(getString(R.string.mobile_recharge), R.drawable.bh_mobile));
            data.add(new ArrayListObject(getString(R.string.tv), R.drawable.bh_tv));
            data.add(new ArrayListObject(getString(R.string.credit_card), R.drawable.bh_creditcard));
            data.add(new ArrayListObject(getString(R.string.cylinder_gas), R.drawable.bh_cylinder));
            data.add(new ArrayListObject(getString(R.string.pipeline_gas), R.drawable.bh_gas));
            data.add(new ArrayListObject(getString(R.string.electricity), R.drawable.bh_electricity));
            data.add(new ArrayListObject(getString(R.string.water), R.drawable.bh_water));
            data.add(new ArrayListObject(getString(R.string.broad_band), R.drawable.bh_broadband));
            data.add(new ArrayListObject(getString(R.string.subscription), R.drawable.bh_subscription));
            data.add(new ArrayListObject(getString(R.string.education), R.drawable.bh_education));
            data.add(new ArrayListObject(getString(R.string.loan), R.drawable.bh_loan));
            data.add(new ArrayListObject(getString(R.string.rent), R.drawable.bh_rent));
        } else if (position==4) {
            imageView.setImageResource(R.drawable.mo);

            data.add(new ArrayListObject(getString(R.string.mobile_recharge), R.drawable.mo_mobile));
            data.add(new ArrayListObject(getString(R.string.tv), R.drawable.mo_tv));
            data.add(new ArrayListObject(getString(R.string.credit_card), R.drawable.mo_creditcard));
            data.add(new ArrayListObject(getString(R.string.cylinder_gas), R.drawable.mo_cylinder));
            data.add(new ArrayListObject(getString(R.string.pipeline_gas), R.drawable.mo_gas));
            data.add(new ArrayListObject(getString(R.string.electricity), R.drawable.mo_electricity));
            data.add(new ArrayListObject(getString(R.string.water), R.drawable.mo_water));
            data.add(new ArrayListObject(getString(R.string.broad_band), R.drawable.mo_broadband));
            data.add(new ArrayListObject(getString(R.string.subscription), R.drawable.mo_subscription));
            data.add(new ArrayListObject(getString(R.string.education), R.drawable.mo_education));
            data.add(new ArrayListObject(getString(R.string.loan), R.drawable.mo_loan));
            data.add(new ArrayListObject(getString(R.string.rent), R.drawable.mo_rent));
        } else if (position==5) {
            imageView.setImageResource(R.drawable.am);

            data.add(new ArrayListObject(getString(R.string.mobile_recharge), R.drawable.am_mobile));
            data.add(new ArrayListObject(getString(R.string.tv), R.drawable.am_tv));
            data.add(new ArrayListObject(getString(R.string.credit_card), R.drawable.am_creditcard));
            data.add(new ArrayListObject(getString(R.string.cylinder_gas), R.drawable.am_cylinder));
            data.add(new ArrayListObject(getString(R.string.pipeline_gas), R.drawable.am_gas));
            data.add(new ArrayListObject(getString(R.string.electricity), R.drawable.am_electricity));
            data.add(new ArrayListObject(getString(R.string.water), R.drawable.am_water));
            data.add(new ArrayListObject(getString(R.string.broad_band), R.drawable.am_broadband));
            data.add(new ArrayListObject(getString(R.string.subscription), R.drawable.am_subscription));
            data.add(new ArrayListObject(getString(R.string.education), R.drawable.am_education));
            data.add(new ArrayListObject(getString(R.string.loan), R.drawable.am_loan));
            data.add(new ArrayListObject(getString(R.string.rent), R.drawable.am_rent));
        }
    }
}