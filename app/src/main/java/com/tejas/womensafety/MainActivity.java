package com.tejas.womensafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SensorManager mSensorManager;

    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector(this);
        Toast.makeText(this, "Developed By Tejas Avhad", Toast.LENGTH_SHORT).show();

    }
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener((SensorEventListener) mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener((SensorListener) mShakeDetector);
    }
public void HN(View view) {
        Intent i1=new Intent(this,HelplineNumber.class);
        startActivity(i1);
}
}