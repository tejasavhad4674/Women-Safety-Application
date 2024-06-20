package com.tejas.womensafety;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

public class ShakeDetector implements SensorEventListener {

    private float mAccel;
    private float mAccelCurrent;
    private float mAccelLast;

    private long mShakeTimestamp;
    private int mShakeCount;

    private Context mContext;

    public ShakeDetector(MainActivity context) {
        mContext = context;
    }

    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        mAccel = 10f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;
        mAccelLast = mAccelCurrent;
        mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
        float delta = mAccelCurrent - mAccelLast;
        mAccel = mAccel * 0.9f + delta;
        if (mAccel > 25) {
            Toast.makeText(mContext, "Detected", Toast.LENGTH_SHORT).show();
            sendSms();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    private void sendSms() {

        String phoneNumber = "9876543210";
        String message = "I am In Danger I Need Help. Please Urgently Reach Me Out";
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, message, null, null);
    }

    }