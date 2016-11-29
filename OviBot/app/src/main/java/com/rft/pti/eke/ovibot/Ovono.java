package com.rft.pti.eke.ovibot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ovono extends AppCompatActivity {

    TextView greetingText;
    Button logOutButton, jelenleti, etkezes, gyerekek, kollegak;


    Storage storage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovono);

       // greetingText = (TextView) findViewById(R.id.greeting_textView);
        logOutButton = (Button) findViewById(R.id.log_out_button);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storage.clear();
                Intent intent = new Intent(Ovono.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        jelenleti = (Button) findViewById(R.id.btn_gyerekem);
        jelenleti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jelenleti = new Intent(Ovono.this,OvonoJelenleti.class);
                startActivity(jelenleti);
            }


        });

        etkezes = (Button) findViewById(R.id.btn_etkezes);
        etkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent etkezes = new Intent(Ovono.this, Etkezes.class);
                startActivity(etkezes);
            }
        });

        gyerekek = (Button) findViewById(R.id.btn_gyerekek);
        gyerekek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gyerekek = new Intent(Ovono.this, OvonoGyerekek.class);
                startActivity(gyerekek);
            }
        });

        kollegak = (Button) findViewById(R.id.btn_ovonok);
        kollegak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kollegak = new Intent(Ovono.this, OvonoKollegak.class);
                startActivity(kollegak);
            }
        });
        // Load username
        storage = new Storage(this);
        String userName = storage.getName();
        //greetingText.setText(getString(R.string.greeting, userName));
    }


}
