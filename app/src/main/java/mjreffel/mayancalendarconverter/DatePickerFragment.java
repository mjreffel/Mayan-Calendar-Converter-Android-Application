package mjreffel.mayancalendarconverter;

import android.app.DatePickerDialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DatePickerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DatePickerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int year, month, day;
        MyAppApplication mApp = ((MyAppApplication)getActivity().getApplicationContext());
        if(mApp.currDate == null) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
        } else {
            //Use the global current date instead for the date loaded into the calendar
            year = mApp.currDate.get(Calendar.YEAR);
            month = mApp.currDate.get(Calendar.MONTH);
            day = mApp.currDate.get(Calendar.DAY_OF_MONTH);
        }

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        MyAppApplication mApp = ((MyAppApplication)getActivity().getApplicationContext());

        //Update the global current date
        mApp.currDate = new GregorianCalendar(year, month, day);

        //Calculate the necessary dates to later update
        tzolkinConverter.tzolkinObject tempTzolkin =  mApp.globalTzolkinConverter.onCalculateTzolkin(year, month, day, mApp);
        longCountConverter.longObject tempLong = mApp.globalLongCountConverter.onCalculateLong(year, month, day, mApp);
        haabConverter.haabObject tempHaab = mApp.globalHaabConverter.onCalculateHaab(year, month, day, mApp);

        //Update the fields in the activity to reflect the above calculations
        mApp.tzolkinText.setText(tempTzolkin.innerCircleString + tempTzolkin.outerCircleString);
        mApp.longText.setText(tempLong.baktun + "." + tempLong.katun + "." + tempLong.tun + "." + tempLong.uinal + "." + tempLong.kin);
        mApp.haabText.setText(tempHaab.innerCircleString + tempHaab.outerCircleString);
        mApp.tzolkinImage.setBackgroundResource(tempTzolkin.imageReference);

        //Setup the long detail section
        mApp.longBaktun.setText(""+tempLong.baktun);
        mApp.longKatun.setText(""+tempLong.katun);
        mApp.longTun.setText(""+tempLong.tun);
        mApp.longUinal.setText(""+tempLong.uinal);
        mApp.longKin.setText(""+tempLong.kin);


        mApp.haabImage.setBackgroundResource(tempHaab.imageReference);

        mApp.dateButton.setText((1+month) + "/" + day + "/" + year);


    }
}
