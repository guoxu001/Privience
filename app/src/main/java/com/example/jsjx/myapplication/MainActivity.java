package com.example.jsjx.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Spinner sp1,sp2;
TextView tv;
String[] sheng=new String[]{"山西省","浙江省"};
String[][] shi=new String[][]{{"太原市","运城市","晋城市"},{"杭州市","湖州市","绍兴市"}};
ArrayAdapter<String>prvienceadapter,cityadapter;
int prviencePosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        prvienceadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sheng);
        sp1.setAdapter(prvienceadapter);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cityadapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,shi[position]);
                prviencePosition=position;

                }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv.setText(sheng[prviencePosition]+shi[prviencePosition][position]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void initView() {
        sp1=findViewById(R.id.sp1);
        sp2=findViewById(R.id.sp2);
        tv=findViewById(R.id.tv);
    }
}
