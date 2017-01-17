package mjreffel.mayancalendarconverter;

import android.app.Activity;
import android.util.Log;

import java.util.GregorianCalendar;
import mjreffel.mayancalendarconverter.DateConverterActivity;

/**
 * Created by markreffel on 1/17/17.
 */
public class tzolkinConverter {
    public class tzolkinObject {
        public String innerCircleString;
        public String outerCircleString;
        public int imageReference;
    }


    public tzolkinObject onCalculateTzolkin (int year, int month, int day, MyAppApplication mApp) {


        tzolkinObject returnObject = new tzolkinObject();

        // 01/01/1900 => 4 Etz'nab'

        int calcTotal = mApp.getNumDay(year, month, day, 1939, 3, 21);
        Log.d("Calculate pre Total", Integer.toString(calcTotal));

        calcTotal = calcTotal%260;
        Log.d("Calculate Total", Integer.toString(calcTotal));


        //Perform the modulo needed based on the base day and how many days have passed
        int whatInnerNum = (calcTotal % 13);
        Log.d("Inner Circle Num", Integer.toString((whatInnerNum)));
        int whatOuterNum = (calcTotal % 20);
        Log.d("Outer Circle Num", Integer.toString((whatOuterNum)));
        returnObject.innerCircleString = mApp.innterCircles[whatInnerNum];
        returnObject.outerCircleString = mApp.outerCircleTzolkin[whatOuterNum];
        returnObject.imageReference = mApp.imagesTzolkin[whatOuterNum];

        //Output the desired date to the results text box
        return returnObject;

    }
}
