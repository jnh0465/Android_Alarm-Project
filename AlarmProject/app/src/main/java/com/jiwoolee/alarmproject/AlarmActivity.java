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
    }
}
