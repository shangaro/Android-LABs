package uwaterloo.com.lab01_204_04;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ca.uwaterloo.sensortoy.LineGraphView;

/**
 * Created by nicol on 2017-05-16.
 */

public class LightSensorHandler implements SensorEventListener {

    private TextView _textView;
//  private  LineGraphView _graphView;
    static float max_x=0;

    public LightSensorHandler(TextView textView) {

        _textView=textView;
//        _graphView=graphView;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_LIGHT){


            try{
                max_x=(event.values[0]>max_x)?event.values[0]:max_x;

                //add to text View

                _textView.setText("Light sensor reading "+Float.toString(event.values[0])
                +"\nMax record: "+ max_x +"\n");



                // logging
                Log.d("Android/Data", "onLightSensorChanged:"+String.valueOf(event.values[0]));

            }
            catch(Exception ex){
                Log.e("Android/Data",ex.getMessage());

            }
            finally{

                // Dispose Any
            }




        }


    }




    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

        // TODO

    }

    public  void cleanMaxRecord(){
        max_x=0;
    }
}
