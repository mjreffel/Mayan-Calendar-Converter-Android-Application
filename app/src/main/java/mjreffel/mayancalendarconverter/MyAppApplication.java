package mjreffel.mayancalendarconverter;

import android.app.Application;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import java.util.GregorianCalendar;

/**
 * Created by markreffel on 1/17/17.
 */
public class MyAppApplication extends Application {


    //Global class references so we dont keep recreating them
    public tzolkinConverter globalTzolkinConverter = new tzolkinConverter();
    public longCountConverter globalLongCountConverter = new longCountConverter();
    public haabConverter globalHaabConverter = new haabConverter();


    //Global update fields that we need to change once calculations are done
    public TextView tzolkinText;
    public TextView longText;
    public TextView haabText;
    public ImageView tzolkinImage;
    public TextView longBaktun;
    public TextView longKatun;
    public TextView longTun;
    public TextView longUinal;
    public TextView longKin;
    public ImageView haabImage;
    public Button dateButton;
    public GregorianCalendar currDate;







    //Global arrays so we only have one instance of them and dont waste space
    public static final String [] innerCircles = new String[] {
            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19"
    };
    public static final String [] outerCircleTzolkin = new String[] {
            "Imix'",
            "Ik'",
            "Ak'b'al",
            "K'an",
            "Chikchan",
            "Kimi",
            "Manik'",
            "Lamat",
            "Muluk",
            "Ok",
            "Chuwen",
            "Eb'",
            "B'en",
            "Ix",
            "Men",
            "Kib'",
            "Kab'an",
            "Etz'nab'",
            "Kawak",
            "Ajaw"
    };

    public static final String [] outerCircleHaab = new String[] {
            "Pop'",
            "Wo'",
            "Sip",
            "Sotz'",
            "Sek",
            "Xul",
            "Yaxk'in'",
            "Mol",
            "Ch'en",
            "Yax",
            "Sak'",
            "Keh",
            "Mak",
            "K'ank'in",
            "Muwan'",
            "Pax'",
            "K'ayab",
            "Kumk'u",
            "Wayeb'"
    };
    public static final int[] imagesTzolkin = new int[] {
            R.drawable.tzolkin_imix,
            R.drawable.tzolkin_ik,
            R.drawable.tzolkin_akbal,
            R.drawable.tzolkin_kan,
            R.drawable.tzolkin_chikchan,
            R.drawable.tzolkin_kimi,
            R.drawable.tzolkin_manik,
            R.drawable.tzolkin_lamat,
            R.drawable.tzolkin_muluk,
            R.drawable.tzolkin_ok,
            R.drawable.tzolkin_chuwen,
            R.drawable.tzolkin_eb,
            R.drawable.tzolkin_ben,
            R.drawable.tzolkin_ix,
            R.drawable.tzolkin_men,
            R.drawable.tzolkin_kib,
            R.drawable.tzolkin_kaban,
            R.drawable.tzolkin_etznab,
            R.drawable.tzolkin_kawak,
            R.drawable.tzolkin_ajaw
    };
    public static final int[] imagesHaab = new int[] {
            R.drawable.haab_pop,
            R.drawable.haab_wo,
            R.drawable.haab_sip,
            R.drawable.haab_sotz,
            R.drawable.haab_sek,
            R.drawable.haab_xul,
            R.drawable.haab_yaxkin,
            R.drawable.haab_mol,
            R.drawable.haab_chen,
            R.drawable.haab_yax,
            R.drawable.haab_sak,
            R.drawable.haab_keh,
            R.drawable.haab_mak,
            R.drawable.haab_kankin,
            R.drawable.haab_muwan,
            R.drawable.haab_pax,
            R.drawable.haab_kayab,
            R.drawable.haab_kumku,
            R.drawable.haab_wayeb
    };

    //Setup Months array for use in the getNumDay function
    private int [] months =  {31,28,31,30,31,30,31,31,30,31,30,31};


    public int getNumDay(int givenYear, int givenMonth,int givenDay, int checkYear, int checkMonth,int checkDay){

        //Do it the Gregorian way and just add in leap years
        DateTime startTime = new DateTime(checkYear, checkMonth, checkDay,0,0);
        DateTime endTime = new DateTime(givenYear, givenMonth, givenDay,0,0);
        Interval differenceTime = new Interval(startTime, endTime);
        long calcTotalMili = differenceTime.toDurationMillis();
        int calcTotalDays = (int) (calcTotalMili / (1000*60*60*24));
        return calcTotalDays;
    }

}
