package uwaterloo.ca.javapractice;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by nicol on 2017-06-01.
 */

public class TimerDemo2 {

    public static Timer[] Timers;
    public static int countdown=10;
    public static TimerTask[] timerTaskList;


    //params: takes counts for how many timers to generate
    //List of timers
    public static Timer[] TimerSynthesizer( int count){

            Timer[] timerList=new Timer[count];
            if(count>0){
                for(int i=0;i<count;i++){
                    timerList[i]=new Timer();
                }

                return timerList;
            }
            else{
                return new Timer[0];
            }



    }

    public static TimerTask[] TimerTaskSynthesizer(final int count){

        TimerTask[] localTimerTaskList=new TimerTask[count];
        countdown=count-1;
        while(countdown!=0){
             localTimerTaskList[countdown]=new TimerTask() {
                 @Override
                 public void run() {
                     switch (countdown){
                         case 3:
                             System.out.println("THREE");
                             break;
                         case 2:
                             System.out.println("TWO");
                             break;
                         case 1:
                             System.out.println("ONE");
                             break;
                         default:
                         {
                             System.out.println(countdown);
                             Log.d("Timer",String.format("Countdown is %s",countdown));
                             break;
                         }

                     }


                 }

             };
            countdown--;
        }

        return localTimerTaskList;
    }


    // one shot timer , shuts down all the timer after the task has been completed

    public  static void CallWatchDogTimer() {
        //myTimer3.schedule(task3, Timer3Period);
        int watchDogTimerPeriod=1000;
        Timer myTimer3= new Timer();
        TimerTask watchDogTimerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Rocket is Launched!!");
                for (Timer element : Timers) {
                    element.cancel();
                }

            }

        };
        myTimer3.schedule(watchDogTimerTask,watchDogTimerPeriod);

    }
    public static void main(String[] args){
        try{
            // ask for the list of Timers and TimerTasks;
            // Entry represents how many timers and timertasks object you need

            Timers=TimerSynthesizer(10);
            timerTaskList=TimerTaskSynthesizer(countdown);

            // Timeperiods
            int TimerPeriod=30;


                Timers[0].schedule(timerTaskList[0],TimerPeriod,TimerPeriod);
                Timers[1].schedule(timerTaskList[1],TimerPeriod+18,TimerPeriod+18);
                Timers[2].schedule(timerTaskList[1],TimerPeriod+18,TimerPeriod+18);


            if(countdown==0){
                CallWatchDogTimer();
            }
        }
        catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
        finally{
                //  TODO: 2017-06-01
        }









    }


}
