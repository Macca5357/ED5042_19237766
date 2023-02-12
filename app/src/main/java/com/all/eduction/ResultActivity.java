package com.all.eduction;

/* Student name: Gavin McCarthy
 * Student id: 19237766
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    ImageView imageViewBack;
    TextView textViewName,textViewAge,textViewPhoneNumber;
    Spinner spinner;
    Button buttonShare;
    String name,age,phoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getData();
        initViews();

    }

    private void initViews() {
        imageViewBack=findViewById(R.id.imageViewBack);
        textViewName=findViewById(R.id.textViewName);
        textViewAge=findViewById(R.id.textViewAge);
        textViewPhoneNumber=findViewById(R.id.textViewPhoneNumber);
        spinner=findViewById(R.id.spinner);
        buttonShare=findViewById(R.id.buttonShare);
        textViewAge.setText(age);
        textViewName.setText(name);
        textViewPhoneNumber.setText(phoneNumber);
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result="Student data ";
                result+="Name : "+name+"\n";
                result+="Age : "+age+"\n";
                result+="Phone Number : "+phoneNumber+"\n";
                result+="Grade : "+spinner.getSelectedItem()+"\n";
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, result);
                startActivity(Intent.createChooser(shareIntent, "Share result"));

            }
        });

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

    private void getData() {
        name=getIntent().getStringExtra("name");
        age=getIntent().getStringExtra("age");
        phoneNumber=getIntent().getStringExtra("phoneNumber");

    }
}