package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.firstNameField)
    TextInputEditText firstNameField;

    @BindView(R.id.lastNameField)
    TextInputEditText lastNameField;

    @BindView(R.id.submitBtn)
    MaterialButton submit;

    @BindView(R.id.fullNameTextView)
    TextView fullNameTextView;

    @BindView(R.id.goodDayText)
    TextView goodDay;
    private String fullName, lastName, firstName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        firstName = "";
        lastName = "";

        submit.setOnClickListener(v -> {

            firstName = String.valueOf(firstNameField.getText());
            lastName = String.valueOf(lastNameField.getText());


            if(firstName.length() < 1 || lastName.length() < 1){
                Toast.makeText(this, "Missing inputs, please try again.", Toast.LENGTH_LONG).show();
            }
            else {

                fullName = firstName + " " + lastName;
                fullNameTextView.setText(fullName);
                goodDay.setVisibility(View.VISIBLE);
            }


        });


    }


}
