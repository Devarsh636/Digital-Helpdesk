package com.example.digitalhelpdesk;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AdapterMA3 viewPagerAdapter;

    public static ArrayList<ArrayListObject> steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        steps = new ArrayList<ArrayListObject>();
        addingSteps();

        viewPagerAdapter = new AdapterMA3(getSupportFragmentManager(), steps.size());
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    void addingSteps() {
        ActionBar actionBar = getSupportActionBar();
        int application = getIntent().getIntExtra(MainActivity2.position, 0);
        int activity = getIntent().getIntExtra(MainActivity2.index, 0);

        if(application >= 0) {
            switch (activity){
                case 0 : actionBar.setTitle(R.string.pay);
                    steps.add(new ArrayListObject(getString(R.string.step1_pay), R.drawable.step_1_paytm, R.raw.step_1_pay));
                    steps.add(new ArrayListObject(getString(R.string.step2_pay), R.drawable.step_2_paytm, R.raw.step_2_pay));
                    steps.add(new ArrayListObject(getString(R.string.step3_pay), R.drawable.step_3_paytm, R.raw.step_3_pay));
                    steps.add(new ArrayListObject(getString(R.string.step4_pay), R.drawable.step_4_paytm, R.raw.step_4_pay));
                    steps.add(new ArrayListObject(getString(R.string.step5_pay), R.drawable.step_5_paytm, R.raw.step_5_pay));

                    break;

                    case 1 : actionBar.setTitle(R.string.upi);
                    steps.add(new ArrayListObject("Open settings and go to additional setting.", R.drawable.img, R.raw.family_older_brother));
                    steps.add(new ArrayListObject("Select language change.", R.drawable.img, R.raw.family_older_brother));
                    steps.add(new ArrayListObject("Select which language u want to choose.", R.drawable.img, R.raw.family_older_brother));
                    steps.add(new ArrayListObject("Click on your selection.", R.drawable.img, R.raw.family_older_brother));
                    steps.add(new ArrayListObject("Click on apply this language.", R.drawable.img, R.raw.family_older_brother));
                    steps.add(new ArrayListObject("Apply to whole phone", R.drawable.img, R.raw.family_older_brother));
                    steps.add(new ArrayListObject("The default language get changed.", R.drawable.img, R.raw.family_older_brother));
                    break;

                    case 2 : actionBar.setTitle(R.string.add_money);
                    steps.add(new ArrayListObject("Open settings and go to additional setting.", R.drawable.img, R.raw.family_older_brother));
                    steps.add(new ArrayListObject("Select language change.", R.drawable.img, R.raw.family_older_brother));
                    steps.add(new ArrayListObject("Select which language u want to choose.", R.drawable.img, R.raw.family_older_brother));
                    steps.add(new ArrayListObject("Click on your selection.", R.drawable.img, R.raw.family_older_brother));
                    steps.add(new ArrayListObject("Click on apply this language.", R.drawable.img, R.raw.family_older_brother));
                    steps.add(new ArrayListObject("Apply to whole phone", R.drawable.img, R.raw.family_older_brother));
                    steps.add(new ArrayListObject("The default language get changed.", R.drawable.img, R.raw.family_older_brother));
                    break;

                   case 3 : actionBar.setTitle(R.string.mobile_recharge);
                         steps.add(new ArrayListObject(getString(R.string.step1_recharge), R.drawable.step1_recharge_paytm, R.raw.step1_recharge));
                         steps.add(new ArrayListObject(getString(R.string.step2_recharge), R.drawable.step2_recharge_paytm, R.raw.step2_recharge));
                         steps.add(new ArrayListObject(getString(R.string.step3_recharge), R.drawable.step3_recharge_paytm, R.raw.step3_recharge));
                         steps.add(new ArrayListObject(getString(R.string.step4_recharge), R.drawable.step4_recharge_paytm, R.raw.step4_recharge));
                         steps.add(new ArrayListObject(getString(R.string.step5_recharge), R.drawable.step5_recharge_paytm, R.raw.step5_recharge));
                         steps.add(new ArrayListObject(getString(R.string.step6_recharge), R.drawable.step6_recharge_paytm, R.raw.step6_recharge));
                         steps.add(new ArrayListObject(getString(R.string.step7_recharge), R.drawable.step7_recharge_paytm, R.raw.step7_recharge));
                         break;

                     case 4 : actionBar.setTitle(R.string.tv);
                         steps.add(new ArrayListObject("Open settings and go to additional setting.", R.drawable.img));
                         steps.add(new ArrayListObject("Select language change.", R.drawable.img));
                         steps.add(new ArrayListObject("Select which language u want to choose.", R.drawable.img));
                         steps.add(new ArrayListObject("Click on your selection.", R.drawable.img));
                         steps.add(new ArrayListObject("Click on apply this language.", R.drawable.img));
                         steps.add(new ArrayListObject("Apply to whole phone", R.drawable.img));
                         steps.add(new ArrayListObject("The default language get changed.", R.drawable.img));
                         break;

                case 5 : actionBar.setTitle(R.string.credit_card);
                         steps.add(new ArrayListObject("Open settings and go to additional setting.", R.drawable.img));
                         steps.add(new ArrayListObject("Select language change.", R.drawable.img));
                         steps.add(new ArrayListObject("Select which language u want to choose.", R.drawable.img));
                         steps.add(new ArrayListObject("Click on your selection.", R.drawable.img));
                         steps.add(new ArrayListObject("Click on apply this language.", R.drawable.img));
                         steps.add(new ArrayListObject("Apply to whole phone", R.drawable.img));
                         steps.add(new ArrayListObject("The default language get changed.", R.drawable.img));
                         break;


                case 6 :
                    steps.add(new ArrayListObject("Open settings and go to additional setting.", R.drawable.img));
                         steps.add(new ArrayListObject("Select language change.", R.drawable.img));
                         steps.add(new ArrayListObject("Select which language u want to choose.", R.drawable.img));
                         steps.add(new ArrayListObject("Click on your selection.", R.drawable.img));
                         steps.add(new ArrayListObject("Click on apply this language.", R.drawable.img));
                         steps.add(new ArrayListObject("Apply to whole phone", R.drawable.img));
                         steps.add(new ArrayListObject("The default language get changed.", R.drawable.img));
                         break;

                case 7 : steps.add(new ArrayListObject("Open settings and go to additional setting.", R.drawable.img));
                         steps.add(new ArrayListObject("Select language change.", R.drawable.img));
                         steps.add(new ArrayListObject("Select which language u want to choose.", R.drawable.img));
                         steps.add(new ArrayListObject("Click on your selection.", R.drawable.img));
                         steps.add(new ArrayListObject("Click on apply this language.", R.drawable.img));
                         steps.add(new ArrayListObject("Apply to whole phone", R.drawable.img));
                         steps.add(new ArrayListObject("The default language get changed.", R.drawable.img));
                         break;
                case 8 : steps.add(new ArrayListObject("Open settings and go to additional setting.", R.drawable.img));
                         steps.add(new ArrayListObject("Select language change.", R.drawable.img));
                         steps.add(new ArrayListObject("Select which language u want to choose.", R.drawable.img));
                         steps.add(new ArrayListObject("Click on your selection.", R.drawable.img));
                         steps.add(new ArrayListObject("Click on apply this language.", R.drawable.img));
                         steps.add(new ArrayListObject("Apply to whole phone", R.drawable.img));
                         steps.add(new ArrayListObject("The default language get changed.", R.drawable.img));
                         break;
                case 9 : steps.add(new ArrayListObject("Open settings and go to additional setting.", R.drawable.img));
                         steps.add(new ArrayListObject("Select language change.", R.drawable.img));
                         steps.add(new ArrayListObject("Select which language u want to choose.", R.drawable.img));
                    steps.add(new ArrayListObject("Click on your selection.", R.drawable.img));
                    steps.add(new ArrayListObject("Click on apply this language.", R.drawable.img));
                    steps.add(new ArrayListObject("Apply to whole phone", R.drawable.img));
                    steps.add(new ArrayListObject("The default language get changed.", R.drawable.img));
                    break;
                case 10 : steps.add(new ArrayListObject("Open settings and go to additional setting.", R.drawable.img));
                    steps.add(new ArrayListObject("Select language change.", R.drawable.img));
                    steps.add(new ArrayListObject("Select which language u want to choose.", R.drawable.img));
                    steps.add(new ArrayListObject("Click on your selection.", R.drawable.img));
                    steps.add(new ArrayListObject("Click on apply this language.", R.drawable.img));
                    steps.add(new ArrayListObject("Apply to whole phone", R.drawable.img));
                    steps.add(new ArrayListObject("The default language get changed.", R.drawable.img));
                    break;
                default : steps.add(new ArrayListObject("Open settings and go to additional setting.", R.drawable.img));
                    steps.add(new ArrayListObject("Select language change.", R.drawable.img));
                    steps.add(new ArrayListObject("Select which language u want to choose.", R.drawable.img));
                    steps.add(new ArrayListObject("Click on your selection.", R.drawable.img));
                    steps.add(new ArrayListObject("Click on apply this language.", R.drawable.img));
                    steps.add(new ArrayListObject("Apply to whole phone", R.drawable.img));
                    steps.add(new ArrayListObject("The default language get changed.", R.drawable.img));
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        MainActivity2 m = new MainActivity2();
        final ProgressDialog ppg = m.ppg;
        ppg.dismiss();
    }
}