package uwaterloo.ca.javapractice;

/**
 * Created by nicol on 2017-05-18.
 */

import java.lang.Math;

public class MathPractice {


    public static double formulaOne(double x, double y, double z) {
        return Math.sqrt(x*x + y*y + z*z);
    }
    public static double formulaTwo(double x, double y, double z) {
        return Math.abs(x*Math.sin(y-Math.PI/8) + y*Math.atan(x/z));
    }
    public static double formulaThree(double x, double y, double z) {
        return x*Math.exp(y) - z*Math.log10(y-x);
    }
}
