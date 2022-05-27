package com.example.aplikasinonton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DaftarActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button pendaftaran, login;
    EditText daftaruser, daftarpwd, daftarcpwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        getSupportActionBar().hide();

        db = new DatabaseHelper(this);

        daftaruser = (EditText)findViewById(R.id.edtText_daftarUser);
        daftarpwd = (EditText)findViewById(R.id.edtText_daftarPwd);
        daftarcpwd = (EditText)findViewById(R.id.edtText_daftarCpwd);
        pendaftaran = (Button)findViewById(R.id.btn_pendaftaran);
        login = (Button)findViewById(R.id.btn_backlogin);

        //register
        pendaftaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = daftaruser.getText().toString();
                String strPassword = daftarpwd.getText().toString();
                String strPasswordConf = daftarcpwd.getText().toString();
                if (strPassword.equals(strPasswordConf)) {
                    Boolean daftar = db.insertUser(strUsername, strPassword);
                    if (daftar == true) {
                        Toast.makeText(getApplicationContext(), "Daftar Berhasil", Toast.LENGTH_SHORT).show();
                        Intent loginIntent = new Intent(DaftarActivity.this, MainActivity.class);
                        startActivity(loginIntent);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Daftar Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Password Tidak Cocok", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(DaftarActivity.this, MainActivity.class);
                startActivity(registerIntent);
                finish();
            }
        });
    }
}