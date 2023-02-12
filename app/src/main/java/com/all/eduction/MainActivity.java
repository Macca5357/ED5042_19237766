package com.all.eduction;

/* Student name: Gavin McCarthy
 * Student id: 19237766
 */


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
     EditText editTextName,editTextAge
             ,editTextPhoneNumber;
     Button buttonSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName=findViewById(R.id.editTextName);
        editTextAge=findViewById(R.id.editTextAge);
        editTextPhoneNumber=findViewById(R.id.editTextPhoneNumber);
        buttonSubmit=findViewById(R.id.buttonSubmit);
          buttonSubmit.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(MainActivity.this,ResultActivity.class);
                  intent.putExtra("name",editTextName.getText().toString());
                  intent.putExtra("age",editTextAge.getText().toString());
                  intent.putExtra("phoneNumber",editTextPhoneNumber.getText().toString());
                  startActivity(intent);
              }
          });
    }
}