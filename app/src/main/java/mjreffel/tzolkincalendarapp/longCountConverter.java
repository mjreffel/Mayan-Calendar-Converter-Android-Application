package mjreffel.tzolkincalendarapp;

import android.util.Log;

/**
 * Created by markreffel on 1/17/17.
 */
public class longCountConverter {

    public class longObject {
        int baktun, katun, tun, uinal, kin;
    }

    public longObject onCalculateLong (int year, int month, int day, MyAppApplication mApp) {

        longObject returnObject = new longObject();


        //Call getNumDay to get number of days
        int calcTotal = mApp.getNumDay(year, month, day, 1939, 03, 21);
        Log.d("Calculated Total Long", Integer.toString(calcTotal));

        // 21/03/1939 => 12.16.5.3.1
        int [] longDate = new int [5];


        // 21/03/1939 => 12.16.5.3.1
        //Initialize all the values to 0 so math works in this order
        returnObject.baktun = 12;
        returnObject.katun = 16;
        returnObject.tun = 5;
        returnObject.uinal = 3;
        returnObject.kin = 1;

        longObject calcTotals = new longObject();
        calcTotals.kin = (calcTotal%144000%7200%360%20);
        calcTotals.uinal = (calcTotal%144000%7200%360)/20;
        calcTotals.tun = (calcTotal%144000%7200)/360;
        calcTotals.katun = (calcTotal%144000)/7200;
        calcTotals.baktun = calcTotal/144000;


        //Calculate K'in
        returnObject.kin = returnObject.kin + calcTotals.kin;
        if(returnObject.kin > 19) {
            returnObject.uinal++;
            returnObject.kin = returnObject.kin%19 - 1;

        }
        Log.d("Calculated k'in", Integer.toString(returnObject.kin));

        //Calculate Unial
        returnObject.uinal = returnObject.uinal + calcTotals.uinal;
        if(returnObject.uinal > 17) {
            returnObject.tun++;
            returnObject.uinal = returnObject.uinal%17 - 1;
        }
        Log.d("Calculated uinal", Integer.toString(returnObject.uinal));

        //Calculate Tun
        returnObject.tun = returnObject.tun + calcTotals.tun;
        if(returnObject.tun > 19) {
            returnObject.katun++;
            returnObject.tun = returnObject.tun%19 - 1;
        }
        Log.d("Calculated tun", Integer.toString(returnObject.tun));

        //Calculate Katun
        returnObject.katun = returnObject.katun + calcTotals.katun;
        if(returnObject.katun > 19) {
            returnObject.baktun++;
            returnObject.katun = returnObject.katun%19 - 1;
        }
        Log.d("Calculated katun", Integer.toString(returnObject.katun));

        //Calculate Baktun
        returnObject.baktun = returnObject.baktun + calcTotals.baktun;
        Log.d("Calculated baktun", Integer.toString(returnObject.baktun));



        String longDateFormatted = "";
        for(int i = 0; i < longDate.length; i++) {
            longDateFormatted = longDateFormatted + Integer.toString(longDate[i]) + ".";
        }

        return returnObject;

    }
}
