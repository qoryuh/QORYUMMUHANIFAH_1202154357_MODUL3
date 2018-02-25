package com.example.hnf.qoryummuhanifah_1202154357_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

        EditText inputUsername, inputPassword;
        Button btnLogin;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            inputUsername = findViewById(R.id.inputUsername);
            inputPassword = findViewById(R.id.inputPassword);
            btnLogin = findViewById(R.id.btnLogin);
        }

        // proses login
    public void heyLogin(View view) {
        // mengecek username inputan dan password inputan dengan key
        if ( inputUsername.getText().toString().equals("EAD") &&
                inputPassword.getText().toString().equals("MOBILE") ) {
            Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, menuListActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Login Failed :(", Toast.LENGTH_SHORT).show();

            // kalau gagal login maka akan reset editText nya
            inputUsername.setText("");
            inputPassword.setText("");
        }
    }

}
