package uwaterloo.ca.javapractice;



import android.icu.text.DecimalFormat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nicol on 2017-05-18.
 */

public class IOPractice {
    private static final String filePath="C:\\AndroidStudioProjects\\IOPractice.txt";



    public static void main(String[] args){
        FileReader fileReader;
        BufferedReader bufferedReader;
        ArrayList<Double> list=new ArrayList<Double>();
        String str=null;

        try{

            fileReader=new FileReader(filePath);
            bufferedReader=new BufferedReader(fileReader);

             str=bufferedReader.readLine();
            if(!str.isEmpty()){


                System.out.println(str);
                System.out.println(str.length());
            }

            fileReader.close();
            bufferedReader.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        finally{

            try {
                if (str != null) {

                    NumberFormat nf= NumberFormat.getInstance();

                    String[] stringList=(str.split(","));

                    Matcher match= Pattern.compile("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?").matcher(stringList[0]);
                    while(match.find()){
                        stringList[0]=match.group();
                    }

                    double x=nf.parse(stringList[0]).doubleValue();
                    double y=nf.parse(stringList[1]).doubleValue();
                    double z=nf.parse(stringList[2]).doubleValue();






                    System.out.println(MathPractice.formulaOne(x,y,z));
                    System.out.println(MathPractice.formulaTwo(x,y,z));
                    System.out.println(MathPractice.formulaThree(x,y,z));




                }
            }
            catch(Exception ex){
                    ex.printStackTrace();
                }


            }

        }


    }



