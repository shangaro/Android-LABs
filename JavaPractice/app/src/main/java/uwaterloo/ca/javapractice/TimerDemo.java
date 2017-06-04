package uwaterloo.ca.javapractice;

import java.util.Timer;
import java.util.TimerTask;


public class TimerDemo {

    public static Timer myTimer1;
    public static Timer myTimer2;
    public static Timer myTimer3;


    public static void main(String args[]){

        //Create Timers
        myTimer1 = new Timer();
        myTimer2 = new Timer();
        myTimer3 = new Timer();

        //Define Timer Periods
        int Timer1Period = 30;
        int Timer2Period = 48;
        int Timer3Period = 1000;

        //Define Timer Tasks
        TimerTask task1 = new TimerTask(){
            public void run(){
                System.out.println("Timer 1 is UP!");
            }
        };

        TimerTask task2 = new TimerTask(){
            public void run(){
                System.out.println("Timer 2 is UP!");
            }
        };

        //This is a WATCHDOG Timer that kills timer 1 and timer 2 when the time is up.
        TimerTask task3 = new TimerTask(){
            public void run(){
                System.out.println("Shutting Down!");
                myTimer1.cancel();
                myTimer2.cancel();

                System.exit(0); //Need this to ensure the process itself is terminated.
            }
        };


        //Timer 1 and 2 are periodic timers
        //schedule(TimerTask, InitialPeriod, RemainingPeriod)
        myTimer1.schedule(task1, Timer1Period, Timer1Period);
        myTimer2.schedule(task2, Timer2Period, Timer2Period);

        //Timer 3 is a watchdog timer / one-shot timer
        //If the RemainingPeriod parameter is not provided, the timer is automatically configured to be a one-shot timer.
        myTimer3.schedule(task3, Timer3Period);

    }

}




