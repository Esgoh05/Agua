package com.administrador.agua;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText edtEmail;
    private EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.ChanceColor);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide(); //funcion ocultar barra menu

        btnLogin = findViewById(R.id.btn_login);
        edtEmail = findViewById(R.id.edtTextEmailAddress);
        edtPassword = findViewById(R.id.edtTextPassword);

        btnLogin.setBackgroundResource(R.drawable.custom_button); //shape, contorno de esquinas para boton
        btnLogin.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1E88E5")));

        edtEmail.setBackgroundColor(Color.TRANSPARENT);
        edtPassword.setBackgroundColor(Color.TRANSPARENT);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void Siguiente(View view){
        Intent siguiente = new Intent(this, SignUpActivity.class);
        startActivity(siguiente);
        finish();
    }
}