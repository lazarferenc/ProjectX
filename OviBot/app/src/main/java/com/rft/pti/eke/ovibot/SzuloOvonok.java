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

        @Override
        protected void onPostExecute(String result) {

            super.onPostExecute(result);

            String response = result.toString();
            try {

                JSONArray new_array = new JSONArray(response);

                for (int i = 0, count = new_array.length(); i < count; i++) {
                    try {
                        //JSON
                        JSONObject jsonObject = new_array.getJSONObject(i);
                        //Teljes név
                        TeljesNev_array.add(jsonObject.getString("TeljesNev").toString());
                        //Iroda
                        Iroda_array.add(jsonObject.getString("Iroda").toString());
                        //Telefon
                        Telefon_array.add(jsonObject.getString("Telefon").toString());
                        //Email
                        Email_array.add(jsonObject.getString("Email").toString());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 0; i < TeljesNev_array.size(); i++) {
                    json_array.add(i, new JsonModellKollegak(TeljesNev_array.get(i), Iroda_array.get(i), Telefon_array.get(i), Email_array.get(i)));
                }

                if(deleteIndex >= 0){
                    Log.d("INDEX:",Integer.toString(deleteIndex));
                    json_array.remove(deleteIndex);
                }

                //kollégák adapter
                adapterkollegak = new AdapterKollegak(cont,R.layout.activity_szulo_ovonok,json_array);
                list_kollegak =  (ListView) findViewById(R.id.list);

                //kollégák lista
                list_kollegak.setAdapter(adapterkollegak);


                AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        //adatok
                        JsonModellKollegak data = json_array.get(arg2);
                        Intent i = new Intent(cont, DetailActivityKollegak.class);
                        //teljes név
                        i.putExtra("TeljesNev", data.getTeljesNev());
                        //iroda
                        i.putExtra("Iroda",data.getIroda());
                        //telefon
                        i.putExtra("Telefon", data.getTelefon());
                        //email
                        i.putExtra("Email", data.getEmail());
                        i.putExtra("index", arg2);

                        startActivity(i);
                        finish();
                    }
                };
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
