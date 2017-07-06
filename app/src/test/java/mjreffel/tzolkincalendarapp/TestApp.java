package mjreffel.tzolkincalendarapp;

import org.junit.Test;
import org.mockito.internal.matchers.Null;

import java.util.regex.Pattern;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Mandip Sangha on 7/5/2017.
 */

public class TestApp {
    //Used to test the that the number of day between two dates function works right
    @org.junit.Test
    public void getNumDayTest(){
        MyAppApplication mApp = new MyAppApplication();

        int calcTotal = mApp.getNumDay(1988, 9, 2, 1939, 3, 21);
        assertEquals(18063, calcTotal);

        calcTotal = mApp.getNumDay(1955, 4, 3, 1939, 3, 21);
        assertEquals(5857, calcTotal);

        calcTotal = mApp.getNumDay(2000, 1, 1, 1939, 3, 21);
        assertEquals(22201, calcTotal);

        calcTotal = mApp.getNumDay(1995, 6, 16, 1939, 3, 21);
        assertEquals(20541, calcTotal);

        calcTotal = mApp.getNumDay(2017, 5, 27, 1939, 3, 21);
        assertEquals(28557, calcTotal);
    }

    //Used to test right data is given for the Tzolkin calendar
    @org.junit.Test
    public void onCalculateTzolkinTest(){
        MyAppApplication mApp = new MyAppApplication();
        tzolkinConverter TzolkinConverter = new tzolkinConverter();

        tzolkinConverter.tzolkinObject tempTzolkin = TzolkinConverter.onCalculateTzolkin (1988, 9, 2, mApp);
        assertEquals("K'an",tempTzolkin.outerCircleString);
        assertEquals("7",tempTzolkin.innerCircleString);

        tempTzolkin = TzolkinConverter.onCalculateTzolkin (1955, 4, 3, mApp);
        assertEquals("Etz'nab'",tempTzolkin.outerCircleString);
        assertEquals("8",tempTzolkin.innerCircleString);

        tempTzolkin = TzolkinConverter.onCalculateTzolkin (2000, 1, 1, mApp);
        assertEquals("Ik'",tempTzolkin.outerCircleString);
        assertEquals("11",tempTzolkin.innerCircleString);

        tempTzolkin = TzolkinConverter.onCalculateTzolkin (1995, 6, 16, mApp);
        assertEquals("Ik'",tempTzolkin.outerCircleString);
        assertEquals("2",tempTzolkin.innerCircleString);

        tempTzolkin = TzolkinConverter.onCalculateTzolkin (2017, 5, 27, mApp);
        assertEquals("Etz'nab'",tempTzolkin.outerCircleString);
        assertEquals("10",tempTzolkin.innerCircleString);
    }

    //Used to test right data is given for the Haab calendar
    @org.junit.Test
    public void onCalculateHaabTest(){
        MyAppApplication mApp = new MyAppApplication();
        haabConverter HaabConverter = new haabConverter();

        haabConverter.haabObject tempHaab  = HaabConverter.onCalculateHaab (1988, 9, 2, mApp);
        assertEquals("Mol",tempHaab.outerCircleString);
        assertEquals("7",tempHaab.innerCircleString);

        tempHaab  = HaabConverter.onCalculateHaab (1955, 4, 3, mApp);
        assertEquals("Kumk'u",tempHaab.outerCircleString);
        assertEquals("11",tempHaab.innerCircleString);

        tempHaab  = HaabConverter.onCalculateHaab (2000, 1, 1, mApp);
        assertEquals("K'ank'in",tempHaab.outerCircleString);
        assertEquals("10",tempHaab.innerCircleString);

        tempHaab  = HaabConverter.onCalculateHaab (1995, 6, 16, mApp);
        assertEquals("Sotz'",tempHaab.outerCircleString);
        assertEquals("10",tempHaab.innerCircleString);

        tempHaab  = HaabConverter.onCalculateHaab (2017, 5, 27, mApp);
        assertEquals("Sip",tempHaab.outerCircleString);
        assertEquals("16",tempHaab.innerCircleString);
    }

    //Used to test right data is given for the long count calendar
    @org.junit.Test
    public void onCalculateLongTest(){
        MyAppApplication mApp = new MyAppApplication();
        longCountConverter LongCountConverter = new longCountConverter();

        longCountConverter.longObject tempLong = LongCountConverter.onCalculateLong(1988, 9, 2, mApp);
        assertEquals(12,tempLong.baktun);
        assertEquals(18,tempLong.katun);
        assertEquals(15,tempLong.tun);
        assertEquals(6,tempLong.uinal);
        assertEquals(4,tempLong.kin);

        tempLong = LongCountConverter.onCalculateLong(1955, 4, 3, mApp);
        assertEquals(12,tempLong.baktun);
        assertEquals(17,tempLong.katun);
        assertEquals(1,tempLong.tun);
        assertEquals(7,tempLong.uinal);
        assertEquals(18,tempLong.kin);

        tempLong = LongCountConverter.onCalculateLong(2000, 1, 1, mApp);
        assertEquals(12,tempLong.baktun);
        assertEquals(19,tempLong.katun);
        assertEquals(6,tempLong.tun);
        assertEquals(15,tempLong.uinal);
        assertEquals(2,tempLong.kin);

        tempLong = LongCountConverter.onCalculateLong(1995, 6, 16, mApp);
        assertEquals(12,tempLong.baktun);
        assertEquals(19,tempLong.katun);
        assertEquals(2,tempLong.tun);
        assertEquals(4,tempLong.uinal);
        assertEquals(2,tempLong.kin);

        tempLong = LongCountConverter.onCalculateLong(2017, 5, 27, mApp);
        assertEquals(13,tempLong.baktun);
        assertEquals(0,tempLong.katun);
        assertEquals(4,tempLong.tun);
        assertEquals(8,tempLong.uinal);
        assertEquals(18,tempLong.kin);
    }
}

