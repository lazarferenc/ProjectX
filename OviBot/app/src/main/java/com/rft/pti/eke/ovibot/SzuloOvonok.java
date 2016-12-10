package com.rft.pti.eke.ovibot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rft.pti.eke.ovibot.Adapter.AdapterKollegak;
import com.rft.pti.eke.ovibot.Details.DetailActivityKollegak;
import com.rft.pti.eke.ovibot.Model.JsonModellKollegak;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class SzuloOvonok extends Activity {
    ArrayList<String> TeljesNev_array = new ArrayList<String>();
    ArrayList<String> Iroda_array = new ArrayList<String>();
    ArrayList<String> Telefon_array = new ArrayList<String>();
    ArrayList<String> Email_array = new ArrayList<String>();

    ArrayList<JsonModellKollegak> json_array = new ArrayList<JsonModellKollegak>();
    ListView list_kollegak;
    AdapterKollegak adapterkollegak;
    Context cont =  this;
    int deleteIndex = -1;
    private static String URL = "http://users.ininet.hu/beadando/ovonok.js";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        deleteIndex = bundle.getInt("delete");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        new TheTask().execute();
    }

    class TheTask extends AsyncTask<Void,Void,String> {

        @Override
        protected String doInBackground(Void... params) {
            String str = null;
            try {
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(URL);
                HttpResponse response = httpclient.execute(httppost);
                str = EntityUtils.toString(response.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;

        }
    }
}
