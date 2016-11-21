package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
    Button btn;
    CheckBox cb_szulo;
    CheckBox cb_ovono;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btn_login);
        /*cb_szulo=(CheckBox)findViewById(R.id.cb_szulo);
        cb_ovono=(CheckBox)findViewById(R.id.cb_ovono);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,OvonoActivity.class);
                startActivity(intent);
            }
        });*/

        CheckBox cb_szulo = (CheckBox) findViewById(R.id.cb_szulo);
        cb_szulo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent1= new Intent(MainActivity.this,SzuloActivity.class);
                            startActivity(intent1);

                        }
                    });
                }
            }
        });
        CheckBox cb_ovono = (CheckBox) findViewById(R.id.cb_ovono);
        cb_ovono.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
             if(isChecked)
             {
                 btn.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         Intent intent=new Intent(MainActivity.this,OvonoActivity.class);
                         startActivity(intent);
                     }
                 });

             }
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
