package com.rft.pti.eke.ovibot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Szulo extends AppCompatActivity {
    Button logOutButton, etkezes, gyerekem, ovonok;
    Storage storage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szulo);
        logOutButton = (Button) findViewById(R.id.log_out_button);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storage.clear();
                Intent intent = new Intent(Szulo.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        etkezes = (Button) findViewById(R.id.btn_etkezes);
        etkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent etkezes = new Intent(Szulo.this,Etkezes.class);
                startActivity(etkezes);
            }
        });
        gyerekem = (Button) findViewById(R.id.btn_gyerekem);
        gyerekem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gyerekem = new Intent(Szulo.this,SzuloGyerekem.class);
                startActivity(gyerekem);

            }
        });
        ovonok = (Button) findViewById(R.id.btn_ovonok);
        ovonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ovonok = new Intent(Szulo.this,SzuloOvonok.class);
                startActivity(ovonok);
            }
        });
    }
}
