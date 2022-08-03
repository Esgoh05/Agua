package com.administrador.agua;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PersonalInfoActivity extends AppCompatActivity {

    private Button btnRegister;
    private TextView txtvNombre;
    private TextView txtvApPat;
    private TextView txtvApMat;
    private TextView txtvTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_personal_info);
        setContentView(R.layout.personal_info);
        //setTitle("Información personal");

        getSupportActionBar().hide(); //funcion ocultar barra menu
        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.title_personal_info);

        btnRegister = findViewById(R.id.btn_register);
        txtvNombre = findViewById(R.id.edtNombre);
        txtvApPat = findViewById(R.id.edtApPat);
        txtvApMat = findViewById(R.id.edtApMat);
        txtvTel = findViewById(R.id.edtPhone);

        txtvNombre.setBackgroundColor(Color.TRANSPARENT);
        txtvApPat.setBackgroundColor(Color.TRANSPARENT);
        txtvApMat.setBackgroundColor(Color.TRANSPARENT);
        txtvTel.setBackgroundColor(Color.TRANSPARENT);

        btnRegister.setBackgroundResource(R.drawable.custom_button); //shape, contorno de esquinas para boton
        btnRegister.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1E88E5")));

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogo();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.personal_info_menu, menu);
        return super.onCreateOptionsMenu(menu);
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

    private void mostrarDialogo(){
        AlertDialog.Builder builder = new AlertDialog.Builder( PersonalInfoActivity. this);
        builder.setIcon(R.drawable.ic_baseline_task_alt_24);
        builder.setTitle("Confirmación");
        builder.setMessage("¿La información insertada es correcta?").setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
               finish();
            }
        })
        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

            }
        }).setCancelable(false)
            .show();
    }

    public void siguiente(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}