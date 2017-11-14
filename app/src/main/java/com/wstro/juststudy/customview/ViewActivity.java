package com.wstro.juststudy.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wstro.juststudy.R;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        List<PieData> dataList = new ArrayList<>();
        dataList.add(new PieData("1",6));
        dataList.add(new PieData("2",3));
        dataList.add(new PieData("3",2));
        dataList.add(new PieData("4",1));


        PieChart pieChart = (PieChart) findViewById(R.id.pie_chart);
        pieChart.setDataList(dataList);
    }
}
