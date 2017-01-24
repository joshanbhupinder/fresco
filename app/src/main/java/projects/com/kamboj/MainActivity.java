/*
package projects.com.kamboj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.philliphsu.bottomsheetpickers.time.BottomSheetTimePickerDialog;
import com.philliphsu.bottomsheetpickers.time.grid.GridTimePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity implements BottomSheetTimePickerDialog.OnTimeSetListener {

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.click);

        String hours = "05";
        String minutes = "45";
        String ampm = "PM";

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
       */
/* calendar.set(Calendar.HOUR,calendar.get(Calendar.HOUR));
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        calendar.set(Calendar.AM_PM, "AM".equals(ampm) ? 0 : 1);*//*


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm a");

        textView.setText(format.format(calendar.getTime()));
        System.out.println(format.format(calendar.getTime()));
    }


    */
/**
     * Getting date object from passing the time 24 hour
     *//*

    public Date getDateFromTimeAmPmFormat(String time) {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
            final Date dateObj = sdf.parse(time);
            return dateObj;
        } catch (final ParseException e) {
            e.printStackTrace();
        }

        return null;
    }


    public String getTimeAMPM(String value)
    {

        S

        String hours = "05";
        String minutes = "45";
        String ampm = "PM";

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
       */
/* calendar.set(Calendar.HOUR,calendar.get(Calendar.HOUR));
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        calendar.set(Calendar.AM_PM, "AM".equals(ampm) ? 0 : 1);*//*


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm a");

        textView.setText(format.format(calendar.getTime()));
        System.out.println(format.format(calendar.getTime()));

        return null;
    }

    public void checkDate()
    {
        if (getDateFromTimeAmPmFormat())
    }


    */
/**
     * Gets value from shared preference.
     *
     * @param key          The key from you want to get the value.
     * @param defaultValue Default value, if nothing is found on that key.
     * @param context      the context
     * @return the value from shared preference
     * @description To get the value from a preference file on the specified
     * key.
     *//*

    public long getValue(String key, long defaultValue, Context context) {
        if (context == null) return 0l;

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        return preferences.getLong(key, defaultValue);
    }

    */
/**
     * return the saved checkout date
     *
     * @param context
     * @return
     *//*

    public Date getCheckOut(Context context) {
        return new Date(getValue("date_key", 0l, context));
    }



    */
/**
     * If user does not have internet then, user should checkout automatically
     *//*

    private void saveCheckOut(Activity activity, String checkout) {
        final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy K:mm a");
        try {
            Date checkOutDate = sdf.parse(checkout);
            saveValue("date_key", checkOutDate.getTime(), activity);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    */
/**
     * Save value to shared preference.
     *
     * @param key     On which key you want to save the value.
     * @param value   The value which needs to be saved.
     * @param context the context
     * @description To save the value to a preference file on the specified key.
     *//*

    public void saveValue(String key, long value, Context context) {
        if (context == null) return;

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor saveValue = preferences.edit();
        saveValue.putLong(key, value);
        saveValue.apply();
    }


    public Date getToday(String format) {
        Date date = null;
        Calendar c = Calendar.getInstance();
        String todayStr;
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            todayStr = formatter.format(c.getTime());
            date = formatter.parse(todayStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public void onTimeSet(ViewGroup viewGroup, int hourOfDay, int minute) {
        Calendar cal = new java.util.GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
        cal.set(Calendar.MINUTE, minute);
        textView.setText(DateFormat.getTimeFormat(MainActivity.this).format(cal.getTime()));
    }

}
*/
