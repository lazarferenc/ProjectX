package com.rft.pti.eke.ovibot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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

public class OvonoKollegak extends Activity {

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
                        JSONObject jsonObject = new_array.getJSONObject(i);
                        TeljesNev_array.add(jsonObject.getString("TeljesNev").toString());
                        Iroda_array.add(jsonObject.getString("Iroda").toString());
                        Telefon_array.add(jsonObject.getString("Telefon").toString());
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


                adapterkollegak = new AdapterKollegak(cont,R.layout.activity_ovono_kollegak,json_array);
                list_kollegak =  (ListView) findViewById(R.id.list);


                list_kollegak.setAdapter(adapterkollegak);

                AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        JsonModellKollegak data = json_array.get(arg2);
                        Intent i = new Intent(cont, DetailActivityKollegak.class);
                        i.putExtra("TeljesNev", data.getTeljesNev());
                        i.putExtra("Iroda",data.getIroda());
                        i.putExtra("Telefon", data.getTelefon());
                        i.putExtra("Email", data.getEmail());

                        i.putExtra("index", arg2);
                        startActivity(i);
                        finish();
                    }
                };
                list_kollegak.setOnItemClickListener(onItemClickListener);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
    }

