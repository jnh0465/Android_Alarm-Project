package com.jiwoolee.android_alarmproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlarmActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Button ButtonStop = (Button) findViewById(R.id.btn_stop2);
        ButtonStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((MainActivity) MainActivity.mContext).alrarm_finish(); //알람 종료
                finish();
            }
        });
    }
}
