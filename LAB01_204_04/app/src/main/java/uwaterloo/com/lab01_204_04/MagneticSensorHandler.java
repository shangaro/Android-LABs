package uwaterloo.com.lab01_204_04;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import android.widget.TextView;

import ca.uwaterloo.sensortoy.LineGraphView;

/**
 * Created by nicol on 2017-05-15.
 */

public class MagneticSensorHandler implements SensorEventListener {
    private  TextView _textView;
    private LineGraphView _graphView;
    static float max_x=-9999;
    static float max_y=-9999;
    static float max_z=-9999;

    public MagneticSensorHandler(TextView textView,LineGraphView graphView){
        _textView=textView;
        _graphView=graphView;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // To Do
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if(event.sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD){

            try{
                float x=event.values[0];
                float y=event.values[1];
                float z=event.values[2];

                max_x=(x>max_x)?x:max_x;
                max_y=(x>max_y)?x:max_y;
                max_z=(x>max_z)?x:max_z;

                // set textView
                _textView.setText("Magnetic sensor reading: "+String.format("%.2f,%.2f,%.2f",x,y,z)
                +"\nMax record: "+ String.format("%.2f,%.2f,%.2f",max_x,max_y,max_z));



                // add to graph
                _graphView.addPoint(event.values);

                // logging

                Log.d("Android/Data", "onMagneticSensorChanged:" + String.format("%.2f,%.2f,%.2f",x,y,z));


            }
            catch(Exception ex){

                Log.e("Android/Data",ex.getMessage());
            }
            finally{

                // Dispose Any
            }

        }
    }

    public  void cleanMaxRecord(){
        max_x=-9999;
        max_y=-9999;
        max_z=-9999;
    }
}
