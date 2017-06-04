package uwaterloo.ca.javapractice;

import java.util.Scanner;

/**
 * Created by nicol on 2017-05-29.
 */


// EUCLEDEAN ALGORITHM GIVES THE GREATEST INTEGER THAT CAN DIVIDE BOTH OF THE GIVEN INTEGERS SAY A AND B

public class EucledeanAlgorithm {


    private static int GCD;

    public  static int GreatestCommonDivisor(int y, int z) {
        y=(y<0)?y*-1:y;
        z=z<0?z*-1:z;
        int min;
        min = (y > z) ? z : y;
        int max = (y < z) ? z : y;
        while(min != 0){
            int temp = min;
            min = max % min;
            max = temp;
        }
        return max;
    }


    public static void main(String[] args){
        int a,b;
        Scanner scanner =new Scanner(System.in);
        System.out.println("Please enter two integers");
        a=scanner.nextInt();
        b=scanner.nextInt();

       int z= GreatestCommonDivisor(a,b);
        System.out.println("The greatest GCD is "+ Integer.toString(z));


    }



}
