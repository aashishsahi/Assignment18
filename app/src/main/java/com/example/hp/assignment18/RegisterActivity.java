package com.example.hp.assignment18;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final SharedPreferences preferences = this.getSharedPreferences("Preference", Context.MODE_PRIVATE);

        Button register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText username = findViewById(R.id.username);
                EditText password = findViewById(R.id.password);
                try {
                    preferences.edit().putString(username.getText().toString(), password.getText().toString()).apply();
                }
                catch (Exception e)
                {
                    Toast.makeText(RegisterActivity.this, "Unsuccessful", Toast.LENGTH_LONG).show();
                }


                Toast.makeText(RegisterActivity.this, "Successful Registration", Toast.LENGTH_LONG).show();


                AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                alert.setTitle("Back");
                alert.setMessage("Press back to login or register again.");
                alert.setPositiveButton("OK", null);
                alert.show();

            }
        });
    }
}
