package mjreffel.mayancalendarconverter;

import android.app.Application;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Date;

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
    public Date currDate;







    //Global arrays so we only have one instance of them and dont waste space
    public static final String [] innterCircles = new String[] {
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

    public int getNumDay(int givenYear, int givenMonth,int givenDay, int checkYear, int checkMonth,int checkDay){
        //get the difference in the years
        int diffYear = givenYear - checkYear;
        //get the difference in the days
        int diffDay = (givenDay - checkDay)*-1;

        //set up the months
        int [] months =  {31,28,31,30,31,30,31,31,30,31,30,31};

        //checks if the count needs to be reset for the year and that the loop for the
        // over the same month is made
        boolean moreThenYear = false;
        if(diffYear >0)moreThenYear = true;
        //Sets the total count and the array start position
        int monthTotal = 0;
        int monthCount = (checkMonth-1);
        while(monthCount != (givenMonth) || moreThenYear){
            monthTotal += months[monthCount];
            monthCount++;
            if(monthCount == 12){
                moreThenYear = false;
                monthCount = 0;
            }
        }
        //Calculates the leap days
        double leapDays = Math.ceil((double)diffYear/4);
        Log.d("leap diff", Double.toString(leapDays));
        //Check make the year difference is one less for calculate if year is more then
        //  0
        if(diffYear-1>0)diffYear -= 1;
        //Calculate the total number of days
        int totalDay = (diffYear*365)+(monthTotal-diffDay)+(int)leapDays;
        Log.d("year diff", Integer.toString(diffYear));
        Log.d("month total", Integer.toString(monthTotal));
        Log.d("day diff", Integer.toString(diffDay));
        Log.d("Total days", Integer.toString(totalDay));
        return totalDay;
    }

}
