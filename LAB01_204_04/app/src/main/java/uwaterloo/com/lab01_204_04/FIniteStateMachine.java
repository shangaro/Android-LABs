////package uwaterloo.com.lab01_204_04;
////
////import android.widget.Button;
////
/////**
//// * Created by nicol on 2017-05-16.
//// */
////
////public static class FiniteStateMachine implements IFSMdesign {
////
////    @Override
////    public boolean ParkingMeter(int Coins, Button timeReset) {
////
////        enum myFSMStates={COUNTDOWN,DEPLETION};
////        myFSMStates myStates=COUNTDOWN;
////        int time=180;//seconds
////        activateGreenLED();
////        deactivateRedLED();
////        // Inside the handler
////
////        switch(myStates){
////            case COUNTDOWN;
////                time--;// decrease time;
////                if(time==0){
////                    //transition
////                    myStates=DEPLETED;
////                    deactivateGreenLED();
////                    activateREDLED();
////                }
////                if(coinIn){
////                    time+=coinValues;//
////                    if(time>1800){
////                        //cap it to 1800
////                        time=1800;
////                    }
////                }
////                break;
////
////            case DEPLETED :
////
////                if(coinIn){
////                    time+=coinValue; // define coinValue later;
////                    activate GreenLED();
////                    deactivateREDLED();
////                    if(time>1800){
////                        time=1800;
////                    }
////                }
////
////                break;
////        }
////
////    }
////}
//
//import android.util.Log;
//
//import java.lang.reflect.GenericSignatureFormatError;
//
//public class myFSM{
//
//    // for my finit state machine
//
//    enum FSMStates{WAIT, FALL_B,RISE_A,STABLE_A,STABLE_B,DETERMINED};
//
//    private FSMStates myStates;
//
//
//    //
//    //Signature Constants
//
//            enum mySig{ LEFT,RIGHT,UNDETERMINED};
//            private  mySig mySignature;
//
//    // Series of constants
//
//    private final float[] Threshold_A{0.5f,1.5f,0.2f};
//    private final float[] Threshold_B{-1.0f,-1.5f,0.2f};
//
//    //tracking my own history reading so we can calculate slope
//    private float previousReading;
//
//    //constructor
//
//    public myFSM(){
//        myState= FSMStates.WAIT;
//        mySignature=mySig.UNDETERMINED;
//        previousReading=0.0f;
//
//    }
//
//    public void supplyReading (float input){
//
//        // fsm goes here
//        // I have the most recent reading coming in
//        float slope=input-previousReading;
//        FSMStates mystate;
//
//        switch(mystate){
//
//            case WAIT:
//
//                Log.d("myFSM says",String.format("Waing on %f",slope));
//                if(slope>=Threshold_A[0]){
//                    myState=FSMStates.A;
//
//                }
//
//                break;
//
//            case Fall_B:
//                break;
//            case RISE_A:
//                logd("Android/Data", "I am rising");
//                if(slope<=0 ){
//                    if( input>Threshold_A[1]){
//
//                    }
//                }
//                    mystate=FSMStates.STABLE_A;
//                }
//                else{
//                    // if the amplitude is reaching on threshold ..
//                    //bad move
//
//                    Log.d("myFSM says", String.format("Maxima is:"%f",input));
//                    myState= FSMStates.DETERMINED;
//                    mySignature=mySig.UNDETERMINED;
//
//                    Log.d{"myFSM says","String.format("
//                }
//                break;
//            case  Stable_A:
//                Log.d("myFSM says", "I am stabilizing...");
//
//                // count down from 0..
//                counter--;
//                if(counter==0){
//                    if(Math.abs(input)<=Threshold_A[2]){
//                        myState=FSMStates.DETERMINED;
//                    }
//                    else{myState=FSMStates.DETERMINED;
//                        mySignature=mySig.UNDETERMINED;}
//                }
//
//                break;
//            case Stable_B:
//                break;
//            case Determined:
//
//                Log.d("myFSM says", "String.format("Determind! My signature is %s);
//                break;
//
//        }
//    }
//
//}
