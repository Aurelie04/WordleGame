package android.bignerdranch.fawordproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class start extends AppCompatActivity {

    Button startBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startBtn = findViewById(R.id.start);
        SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name =(EditText) findViewById(R.id.userName);
                Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
                String userName = name.getText().toString();

                SharedPreferences.Editor editor =prefs.edit();
                editor.putString("userName",userName);
                editor.commit();


              startActivity(mainActivity);
            }
        });
    }
}