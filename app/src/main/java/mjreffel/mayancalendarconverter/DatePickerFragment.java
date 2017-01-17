package mjreffel.mayancalendarconverter;

import android.app.DatePickerDialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;


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
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        MyAppApplication mApp = ((MyAppApplication)getActivity().getApplicationContext());

        //Calculate the necessary dates to later update
        tzolkinConverter.tzolkinObject tempTzolkin =  mApp.globalTzolkinConverter.onCalculateTzolkin(year, month, day, mApp);
        //longCountConverter.longObject tempLong = mApp.globalLongCountConverter.onCalculateLong(year, month, day, mApp);
        haabConverter.haabObject tempHaab = mApp.globalHaabConverter.onCalculateHaab(year, month, day, mApp);

        //Update the fields in the activity to reflect the above calculations
        mApp.tzolkinText.setText(tempTzolkin.innerCircleString + tempTzolkin.outerCircleString);
        //mApp.longText.setText(tempLong.innerCircleString + tempLong.outerCircleString);
        mApp.haabText.setText(tempHaab.innerCircleString + tempHaab.outerCircleString);
        mApp.tzolkinImage.setBackgroundResource(tempTzolkin.imageReference);
        mApp.haabImage.setBackgroundResource(tempHaab.imageReference);


    }
}
