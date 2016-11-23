package com.dandelion.thirdproject;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity16 extends AppCompatActivity
        implements SensorEventListener {

    private static final String MY_LOG = "MyLog";
    private static final int SHAKE_THRESHOLD = 2000;
    private float last_x = -1.0f, last_y = -1.0f, last_z = -1.0f;
    private long lastUpdate;
    private float x, y, z;
    private SensorManager sensorManager;
    private TextView textViewX;
    private TextView textViewY;
    private TextView textViewZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        textViewX = (TextView) findViewById(R.id.textViewX);
        textViewY = (TextView) findViewById(R.id.textViewY);
        textViewZ = (TextView) findViewById(R.id.textViewZ);
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onClick(View view) {
        StringBuilder sb = new StringBuilder();
        for (Sensor sensor : sensorManager.getSensorList(Sensor.TYPE_ALL)) {
            sb.append("\n ----------------\n")
                    .append(" Name= ").append(sensor.getName())
                    .append("\n Type= ").append(sensor.getType())
                    .append("\n Vendor= ").append(sensor.getVendor())
                    .append("\n Version= ").append(sensor.getVersion())
                    .append("\n MaxRange= ").append(sensor.getMaximumRange())
                    .append("\n Resolution= ").append(sensor.getResolution())
                    .append("\n ----------------\n");
        }
        Log.d(MY_LOG, sb.toString());
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            textViewX.setText("X: " + event.values[0]);
            textViewY.setText("Y: " + event.values[1]);
            textViewZ.setText("Z: " + event.values[2]);

            long curTime = System.currentTimeMillis();
            // only allow one update every 100ms.
            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;

                x = event.values[0];
                y = event.values[1];
                z = event.values[2];

                float speed = Math.abs(x + y + z - last_x -
                        last_y - last_z) / diffTime * 10000;

                if (speed > SHAKE_THRESHOLD) {
                    Log.d("sensor", "shake detected w/ speed: " + speed);
                    Toast.makeText(this, "shake detected w/ speed: " +
                            speed, Toast.LENGTH_SHORT).show();
                }
                last_x = x;
                last_y = y;
                last_z = z;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

}
