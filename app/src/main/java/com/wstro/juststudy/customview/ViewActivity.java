package com.wstro.juststudy.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wstro.juststudy.R;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        /*List<PieData> dataList = new ArrayList<>();
        dataList.add(new PieData("1",6));
        dataList.add(new PieData("2",3));
        dataList.add(new PieData("3",2));
        dataList.add(new PieData("4",1));


        PieChart pieChart = (PieChart) findViewById(R.id.pie_chart);
        pieChart.setDataList(dataList);*/


       /* double a = Math.sin(30 * Math.PI/ 180f);
        LogUtils.d("sin30="+a);

        ByteBuffer buffer = ByteBuffer.allocate(4);

        int b = 1025;
        byte[] bytes = new byte[4];
        ByteUtils.putInt(bytes,0,b);
        LogUtils.d(Arrays.toString(bytes));

        LogUtils.d(Integer.toBinaryString(b));

        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putInt(b);
        byte[] bigArray = buffer.array();

        LogUtils.d("小端："+Arrays.toString(bigArray));
        buffer.clear();*/


    }
}
