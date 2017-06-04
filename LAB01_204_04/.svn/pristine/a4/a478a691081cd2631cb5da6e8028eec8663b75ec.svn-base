package uwaterloo.com.lab01_204_04;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import android.widget.TextView;

import ca.uwaterloo.sensortoy.LineGraphView;
import java.lang.reflect.Array;


/**
 * Created by nicol on 2017-05-12.
 */

public class AccelerometerSensorHandler implements SensorEventListener {

    private TextView _myLocalTV;
    private LineGraphView _graphView;
    static float max_x=-9999;
    static float max_y=-9999;
    static float max_z=-9999;


    public AccelerometerSensorHandler(TextView myLocalTV,LineGraphView graphView){

        _myLocalTV=myLocalTV;
        _graphView=graphView;

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
       // ...
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

//        List<Object> collector = new LinkedList<Object>();
        try {

//              FileWriter fileWriter=new FileWriter(new File(filepath));


            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

                float x=event.values[0];
                float y=event.values[1];
                float z=event.values[2];
                max_x=(x>max_x)?x:max_x;
                max_y=(y>max_y)?y:max_y;
                max_z=(z>max_z)?z:max_z;


                _myLocalTV.setText("Accelerometer sensor reading: "+String.format("%.2f,%.2f,%.2f",x,y,z)
                +"\nMaxRecord: "+String.format("%.2f,%.2f,%.2f",max_x,max_y,max_x));

                // adding to csvList
                CSVUtility.AddToCSVList(new float[]{x,y,z});

                //adding to graph
                _graphView.addPoint(event.values);

                Log.d("Android/Data", "onAccelerometerSensorChanged:" + String.format("%.2f,%.2f,%.2f",x,y,z));


            }
        }
        catch (Exception ex){
            Log.e("Android/Data",ex.getMessage());


        }
        finally{

            // Dispose any dynamic memory allocation or memory stream
        }
    }

    public  void cleanMaxRecord(){
        max_x=-9999;
        max_y=-9999;
        max_z=-9999;
    }


}
