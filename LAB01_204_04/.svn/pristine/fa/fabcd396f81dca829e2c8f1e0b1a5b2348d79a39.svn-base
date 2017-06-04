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

public class RotationalSensorHandler implements SensorEventListener {
    private TextView _textView;
//    private LineGraphView _graphView;



    public RotationalSensorHandler(TextView textView) {
        _textView=textView;
//        _graphView=graphView;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // TODo..
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_ROTATION_VECTOR){

            try{

                Log.d("Android/Data", "onRotationalSensorChanged:" + String.format("%.2f,%.2f,%.2f",event.values[0],event.values[1],event.values[2]));
            }
            catch(Exception ex){
                Log.e("Android/Data", ex.getMessage() );
            }
            finally{

//                _graphView.addPoint(event.values);
            }


        }
    }
}
