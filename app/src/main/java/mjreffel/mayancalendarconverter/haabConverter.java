package mjreffel.mayancalendarconverter;

import android.util.Log;

import java.util.GregorianCalendar;

/**
 * Created by markreffel on 1/17/17.
 */
public class haabConverter {

    public class haabObject {
        public String innerCircleString;
        public String outerCircleString;
        public int imageReference;
    }

    public haabObject onCalculateHaab(int year, int month, int day, MyAppApplication mApp) {

        haabObject returnObject = new haabObject();

        // 01/01/1900 => 4 Etz'nab'

        int calcTotal = mApp.getNumDay(year, month, day, 1939, 4, 21);
        Log.d("Calculate pre Total", Integer.toString(calcTotal));

        calcTotal = calcTotal%365;
        Log.d("Calculate Total", Integer.toString(calcTotal));


        //Perform the modulo needed based on the base day and how many days have passed
        int whatInnerNum = (calcTotal % 20);
        Log.d("Inner Circle Num Haab", Integer.toString((whatInnerNum)));
        int whatOuterNum = (calcTotal % 20);
        Log.d("Outer Circle Num Haab", Integer.toString((whatOuterNum)));
        returnObject.innerCircleString = mApp.innerCircleHaab[whatInnerNum];
        returnObject.outerCircleString = mApp.outerCircleHaab[whatOuterNum];
        returnObject.imageReference = mApp.imagesHaab[whatOuterNum];

        //Output the desired date to the results text box
        return returnObject;

    }
}
