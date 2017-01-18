package mjreffel.mayancalendarconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class DateConverterActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_converter);
        MyAppApplication mApp = ((MyAppApplication)getApplicationContext());

        //Update the global variables with the correct references from inside the activity
        mApp.tzolkinText = (TextView) findViewById(R.id.tzolkinText);
        mApp.longText = (TextView) findViewById(R.id.longText);
        mApp.haabText = (TextView) findViewById(R.id.haabText);
        mApp.tzolkinImage = (ImageView) findViewById(R.id.tzolkinImage);
        mApp.longBaktun = (TextView) findViewById(R.id.editBaktun);
        mApp.longKatun = (TextView) findViewById(R.id.editKatun);
        mApp.longTun = (TextView) findViewById(R.id.editTun);
        mApp.longUinal = (TextView) findViewById(R.id.editUinal);
        mApp.longKin = (TextView) findViewById(R.id.editKin);

        mApp.haabImage = (ImageView) findViewById(R.id.haabImage);
        mApp.dateButton = (Button) findViewById(R.id.pickDateButton);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_date_converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }


}
