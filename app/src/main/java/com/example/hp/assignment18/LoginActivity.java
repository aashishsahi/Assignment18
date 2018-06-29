package com.example.hp.assignment18;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.login);

        final SharedPreferences preferences = getSharedPreferences("Preference", 0);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText username = findViewById(R.id.username);
                EditText password = findViewById(R.id.password);
                String passcheck = preferences.getString(username.getText().toString(), "Password");

                Log.i("shared", passcheck);
                if(password.getText().toString().equals(passcheck))
                {

                    Intent intent = new Intent(LoginActivity.this, AccountActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Entered details are not correct", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
