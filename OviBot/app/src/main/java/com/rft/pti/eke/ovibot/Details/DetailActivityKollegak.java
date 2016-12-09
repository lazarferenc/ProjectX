package com.rft.pti.eke.ovibot.Details;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by lazarferenc on 2016.12.09..
 */

public class DetailActivityKollegak extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle mainBundle = getIntent().getExtras();
        String TeljesNev = mainBundle.getString("TeljesNev");
        String Iroda = mainBundle.getString("Iroda");
        String Telefon = mainBundle.getString("Telefon");
        String Email = mainBundle.getString("Email");

        int index = mainBundle.getInt("index");

        Bundle bundle = new Bundle();
        bundle.putString("TeljesNev", TeljesNev);
        bundle.putString("Iroda", Iroda);
        bundle.putString("Telefon", Telefon);
        bundle.putString("Email", Email);
        bundle.putInt("index",index);


        super.onCreate(savedInstanceState);

    }

    @Override
    public void onBackPressed() {
        finish();
    }


}
