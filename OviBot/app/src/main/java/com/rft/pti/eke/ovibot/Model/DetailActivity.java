package com.rft.pti.eke.ovibot.Model;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by lazarferenc on 2016.12.09..
 */

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle mainBundle = getIntent().getExtras();
        String Datum = mainBundle.getString("Datum");
        String Reggeli = mainBundle.getString("Reggeli");
        String Ebed = mainBundle.getString("Ebed");
        String Uzsonna = mainBundle.getString("Uzsonna");

        int index = mainBundle.getInt("index");

        Bundle bundle = new Bundle();
        bundle.putString("Datum", Datum);
        bundle.putString("Reggeli", Reggeli);
        bundle.putString("Ebed", Ebed);
        bundle.putString("Uzsonna", Uzsonna);

        bundle.putInt("index",index);


        super.onCreate(savedInstanceState);

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
