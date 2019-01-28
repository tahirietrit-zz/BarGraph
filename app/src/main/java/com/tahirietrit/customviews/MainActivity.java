package com.tahirietrit.customviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CustomImageView mrekullia10;
    ArrayList<Float> dataSet = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mrekullia10 = findViewById(R.id.mrekullia_10);
        dataSet.add(15f);
        dataSet.add(25f);
        dataSet.add(35f);
        dataSet.add(75f);
        dataSet.add(45f);
        dataSet.add(55f);
        dataSet.add(55f);
        dataSet.add(55f);
        dataSet.add(55f);
        dataSet.add(55f);
        dataSet.add(55f);
        dataSet.add(55f);
        dataSet.add(55f);
        dataSet.add(55f);
        dataSet.add(55f);
        dataSet.add(100f);
        mrekullia10.setDataSet(dataSet);

    }
}
