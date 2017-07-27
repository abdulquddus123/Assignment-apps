package com.assignmentapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {
   TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        textView=(TextView)findViewById(R.id.textView);
        DataView();
    }
    public void DataView(){
        String s = getIntent().getStringExtra("message");
        Toast.makeText(this, s.toString(), Toast.LENGTH_SHORT).show();


    }
}
