package com.jiwoolee.alarmproject;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

import static java.security.AccessController.getContext;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    private AlarmManager mAlarmManager;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        mAlarmManager = (AlarmManager)getContext().getSystemService(Context.ALARM_SERVICE);
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        return new TimePickerDialog(getContext(), this, hour, minute, DateFormat.is24HourFormat(getContext()));
    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);

        String hourOfDay_st = String.valueOf(hourOfDay);
        String minute_st = String.valueOf(minute);

        Intent intent = new Intent(getContext(), AlarmActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("hour", hourOfDay_st);
        bundle.putString("minute", minute_st);
        intent.putExtras(bundle);

        PendingIntent operation = PendingIntent.getActivity(getContext(), 0, intent, 0);
        mAlarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), operation);
    }
}