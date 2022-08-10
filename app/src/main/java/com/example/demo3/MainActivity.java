package com.example.demo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 10;
    private Button buttondone;
    private EditText editFullName;
    private EditText editBirthday;
    private EditText editAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(" List person ");

        editFullName = findViewById(R.id.FullName);
        editBirthday = findViewById(R.id.Birthday);
        editAbout = findViewById(R.id.About);


        buttondone = findViewById(R.id.Done);

        buttondone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity();
            }

            private void nextActivity() {
                String UseFullName = editFullName.getText().toString().trim();
                String UseBirthday = editBirthday.getText().toString().trim();
                String UseAbout = editAbout.getText().toString().trim();

                Intent intent = new Intent(MainActivity.this, InformationActivity.class);
                intent.putExtra(InformationActivity.KeyUserFullName, UseFullName);
                intent.putExtra("UserDemoone",UseBirthday);
                intent.putExtra("UserDemoone1", UseAbout);
                startActivityForResult(intent, MY_REQUEST_CODE);
            }
        });
    }
    public class KeyUserFullName {
    }
}