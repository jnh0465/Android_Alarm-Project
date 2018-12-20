package com.jiwoolee.alarmproject;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AlarmActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String hour_st = bundle.getString("hour");
        String mm_st = bundle.getString("minute");

        final int hour = Integer.parseInt(hour_st);
        final int mm = Integer.parseInt(mm_st);

        Toast.makeText(AlarmActivity.this,"Alarm 예정 " + hour_st + "시 " + mm_st + "분",Toast.LENGTH_SHORT).show();

        Button bt_end = (Button) findViewById(R.id.bt_end);  //종료버튼 클릭시
        bt_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(AlarmActivity.this, MainActivity.class); //버튼클릭시 PaymentActivity 호출
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // 다른 액티비티 다 종료하고 MainActivity만 남기기
                startActivity(intent);
            }
        });
    }

    @Override public void onBackPressed() {
        //super.onBackPressed(); //뒤로가기 버튼 막기
    }
}
