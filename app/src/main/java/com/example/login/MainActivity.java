package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.ui.login.DatePickerFragment;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name;
    EditText date;
    EditText number;
    EditText email;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        date = (EditText) findViewById(R.id.date);
        number = (EditText) findViewById(R.id.number);
        email = (EditText) findViewById(R.id.email);
        button = (Button) findViewById(R.id.button);

        date.setOnClickListener(this);
        button.setOnClickListener(this);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.date:
                showDatePickerDialog();
                break;

            case R.id.button:
                login(view);
                break;
        }
    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month++;
                // +1 because January is zero
                String formattedDay = (day < 10)? "0" + String.valueOf(day):String.valueOf(day);
                String formattedMonth = (month < 10)? "0" + String.valueOf(month):String.valueOf(month);

                final String selectedDate = formattedDay + "/" + formattedMonth + "/" + year;
                date.setText(selectedDate);
            }
        });
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public String getAge(){
        String [] strDate = date.getText().toString().split("/");
        int day = Integer.parseInt(strDate[0]);
        int month = Integer.parseInt(strDate[1]);
        int year = Integer.parseInt(strDate[2]);
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        return ageS;
    }

    public void login(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        EditText date = (EditText) findViewById(R.id.date);
        String birth = date.getText().toString();
        String age = getAge();
        intent.putExtra("Date", birth);
        intent.putExtra("Age", age);
        startActivity(intent);
    }
}
