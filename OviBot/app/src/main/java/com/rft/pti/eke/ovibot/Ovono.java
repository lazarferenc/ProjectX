package com.rft.pti.eke.ovibot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ovono extends AppCompatActivity {

    TextView greetingText;
    Button logOutButton, jelenleti;


    Storage storage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovono);

        //greetingText = (TextView) findViewById(R.id.greeting_textView);
        logOutButton = (Button) findViewById(R.id.log_out_button);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storage.clear();
                Intent logout = new Intent(Ovono.this, LoginActivity.class);
                startActivity(logout);
                finish();
            }
        });

        jelenleti = (Button) findViewById(R.id.btn_jelenleti);
        jelenleti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jelenleti = new Intent(Ovono.this,OvonoJelenleti.class);
                startActivity(jelenleti);
            }


        });
        // Load username
        storage = new Storage(this);
        String userName = storage.getName();
        //greetingText.setText(getString(R.string.greeting, userName));
    }
    public void etkezes(View view){
        Intent etkezes = new Intent(Ovono.this,Etkezes.class);
        etkezes.putExtra("delete", -1);
        startActivity(etkezes);

    }
    public void ovonok(View view){
        Intent kollegak = new Intent(Ovono.this,OvonoKollegak.class);
        kollegak.putExtra("delete",-1);
        startActivity(kollegak);

    }
    public void gyerekek(View view){
        Intent gyerekek = new Intent(Ovono.this,OvonoGyerekek.class);
        gyerekek.putExtra("delete",-1);
        startActivity(gyerekek);

    }


}
