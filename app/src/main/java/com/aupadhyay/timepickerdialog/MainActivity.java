package com.aupadhyay.timepickerdialog;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView timeDisplayTextView;
    Button timePickerButton;
    TimePickerDialog timePickerDialog;
    TimePickerDialog.OnTimeSetListener onTimeSetListener;

    int h, m;

    public void initTimePickerDialog()
    {
        timeDisplayTextView = (TextView) findViewById(R.id.timeDisplayTextView);
        timePickerButton = (Button) findViewById(R.id.timePickerButton);

        Calendar calendar = Calendar.getInstance(Locale.getDefault());

        h = calendar.get(Calendar.HOUR_OF_DAY);
        m = calendar.get(Calendar.MINUTE);

        onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                String min = String.valueOf(i1);
                if(i1<10)
                    min = "0"+min;
                timeDisplayTextView.setText(String.format("%s:%s", String.valueOf(i), min));
            }
        };

        timePickerDialog = new TimePickerDialog(this, onTimeSetListener, h, m, true);

        timePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTimePickerDialog();
    }
}
