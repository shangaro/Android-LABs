package uwaterloo.com.lab01_204_04;

import android.content.Context;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicol on 2017-05-17.
 */

public class CSVUtility {
    public static final String folderName="Lab1";
    public static final String fileName="Lab1.csv";
    private File _file;
    private static List <float[]> _dataList;
    private Context _context;


    public CSVUtility(Context context,File file) {
        _context=context;
        _file=file;
        _dataList=new ArrayList<float[]>();



    }

    public static void AddToCSVList(float[] f){

        if(_dataList.size()>100){
            _dataList.remove(0);
        }
       _dataList.add(f);

    }

    public void GenerateCSV(){
        FileOutputStream  fileOutputStream=null;
        boolean isCreated=false;
        try {

            fileOutputStream=new FileOutputStream(_file);


            fileOutputStream.write("X,Y,Z\n".getBytes());

            for (int i = 0; i < _dataList.size(); i++) {

                fileOutputStream.write(

                        String.format("%.2f,%.2f,%.2f\n", _dataList.get(i)[0], _dataList.get(i)[1], _dataList.get(i)[2]).getBytes());

                isCreated=true;
            }
            if(isCreated==true){

                Log.i("Android/Data", "GeneratedCSV file successfully @: "+ _file.getAbsolutePath()+_file.getName());
            }


            fileOutputStream.close();




        } catch (Exception e) {

            e.printStackTrace();
            Log.e("Android/Data","unable to generate csv file: "+ e.getMessage() );

        }



    }


}
