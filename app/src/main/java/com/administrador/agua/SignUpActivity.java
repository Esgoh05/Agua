package com.administrador.agua;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.administrador.agua.validacion.Validacion;

public class SignUpActivity extends AppCompatActivity {

    private Button btnSend, btnInsertCode;
    private EditText edtMail, edttype_code;
    private ImageView imgsend_email;
    private RelativeLayout textTypeCode;
    private TextView txtvResend, txtCountDown;

    String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.ChanceColor);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().hide(); //funcion ocultar barra menu


        btnSend = findViewById(R.id.btn_send_email);
        edtMail = findViewById(R.id.edtTextEmailAddress);
        imgsend_email = findViewById(R.id.img_isend_email);
        edttype_code = findViewById(R.id.edtTNumberSigned);
        textTypeCode = findViewById(R.id.txtb_typecode);
        txtvResend = findViewById(R.id.txtv_resend_email);
        btnInsertCode = findViewById(R.id.btn_insert_code);
        txtCountDown = findViewById(R.id.txtCountDown);

        edtMail.setBackgroundColor(Color.TRANSPARENT);
        edttype_code.setBackgroundColor(Color.TRANSPARENT);

        btnSend.setBackgroundResource(R.drawable.custom_button); //shape, contorno de esquinas para boton
        btnSend.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1E88E5")));

        btnInsertCode.setBackgroundResource(R.drawable.custom_button);
        btnInsertCode.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1E88E5")));

        btnSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               /* if(imgsend_email.getVisibility() == View.VISIBLE){
                    validacionCampos();



                    btnSend.setVisibility(View.GONE);
                    textTypeCode.setVisibility(View.VISIBLE);
                    txtvResend.setVisibility(View.VISIBLE);
                    btnInsertCode.setVisibility(View.VISIBLE);
            }*/
                validacionCampos();
        }
    });
        Intent intent = new Intent(this, BroadcastService.class);
        startService(intent);
        Log.i(TAG, "Started");
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateGUI(intent);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, new IntentFilter(BroadcastService.COUNTDOWN_BR));
        Log.i(TAG, "Registered broadcast receiver");
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void onStop() {

        try {
            unregisterReceiver(broadcastReceiver);
        } catch (Exception e) {

        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, BroadcastService.class));
        Log.i(TAG, "STOPPED");
        super.onDestroy();
    }

    private void updateGUI(Intent intent){
        if (intent.getExtras() != null){
            long millisUntilFinished = intent.getLongExtra("contdown", 60000);
            txtCountDown.setText(Long.toString(millisUntilFinished / 1000));
        }
    }

    public void validacionCampos(){
        if(!validarEmail()){
            return;
        }
        Toast.makeText(SignUpActivity.this, "Por favor revisa tu correo, hemos enviado un código de verificación.", Toast.LENGTH_SHORT).show();
    }

    public void Siguiente(View view){
        //Intent siguiente = new Intent(this, PersonalInfoActivity.class);
        Intent siguiente = new Intent(this, PersonalInfoActivity.class);
        startActivity(siguiente);
        finish();
    }

    public boolean validarEmail(){
        String email = edtMail.getText().toString();

        if(email.isEmpty()){
            edtMail.setError("Campo invalido");
            return false;
        }
        else if (!Validacion.emailValidacion(email)){
            edtMail.setError("Por favor, ingrese un email valido");
            return false;
        }
        else{
            edtMail.setError(null);
            return true;
        }
    }
}