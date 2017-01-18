package mjreffel.mayancalendarconverter;

import android.util.Log;

import java.util.GregorianCalendar;

/**
 * Created by markreffel on 1/17/17.
 */
public class longCountConverter {

    public class longObject {
        int baktun, katun, tun, uinal, kin;
    }

    public longObject onCalculateLong (int year, int month, int day, MyAppApplication mApp) {

        longObject returnObject = new longObject();

        // 21/03/1939 => 12.16.5.3.1

        //Call getNumDay to get number of days
        int calcTotal = mApp.getNumDay(year, month, day, 1939, 03, 21);

        // 21/03/1939 => 12.16.5.3.1
        int [] longDate = new int [5];

        //Calculate Baktun
        returnObject.baktun = 12 + calcTotal/144000;
        calcTotal = calcTotal%144000;
        Log.d("Calculated baktun", Integer.toString(returnObject.baktun));
        Log.d("calcTotal", Integer.toString(calcTotal));

        //Calculate Katun
        returnObject.katun = 16 + calcTotal/7200;
        calcTotal = calcTotal%7200;
        Log.d("Calculated katun", Integer.toString(returnObject.katun));
        Log.d("calcTotal", Integer.toString(calcTotal));

        //Calculate Tun
        returnObject.tun = 5 + calcTotal/360;
        calcTotal = calcTotal%360;
        Log.d("Calculated tun", Integer.toString(returnObject.tun));
        Log.d("calcTotal", Integer.toString(calcTotal));

        //Calculate Unial
        returnObject.uinal = 3 + calcTotal/20;
        calcTotal = calcTotal%20;
        Log.d("Calculated uinal", Integer.toString(returnObject.uinal));
        Log.d("calcTotal", Integer.toString(calcTotal));

        //Calculate K'in
        returnObject.kin = 1 + calcTotal;
        Log.d("Calculated k'in", Integer.toString(returnObject.kin));
        Log.d("calcTotal", Integer.toString(calcTotal));


        String longDateFormatted = "";
        for(int i = 0; i < longDate.length; i++) {
            longDateFormatted = longDateFormatted + Integer.toString(longDate[i]) + ".";
        }

        return returnObject;

    }
}
