package com.administrador.agua;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class PersonalInfoActivity extends AppCompatActivity {

    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        setTitle("Información personal");

        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setBackgroundResource(R.drawable.custom_button); //shape, contorno de esquinas para boton
        btnRegister.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1E88E5")));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.personal_info_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void Siguiente(View view){
        Intent siguiente = new Intent(this, SignUpActivity.class);
        startActivity(siguiente);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.btn_salir){
            //finish(); //finaliza la actividad. Nota. tomar en cuenta la pila
            finishAffinity(); //finaliza la app
        }
        return super.onOptionsItemSelected(item);
    }
}