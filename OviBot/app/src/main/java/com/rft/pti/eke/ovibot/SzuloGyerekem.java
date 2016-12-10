package com.rft.pti.eke.ovibot;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rft.pti.eke.ovibot.Adapter.AdapterGyerekek;
import com.rft.pti.eke.ovibot.Details.DetailActivityGyerekek;
import com.rft.pti.eke.ovibot.Model.JsonModellGyerekek;

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

public class SzuloGyerekem extends AppCompatActivity {
    ArrayList<String> TeljesNev_array = new ArrayList<String>();
    ArrayList<String> Magatartas_array = new ArrayList<String>();
    ArrayList<String> Hangulat_array = new ArrayList<String>();
    ArrayList<String> Jelenlet_array = new ArrayList<String>();
    ArrayList<String> Datum_array = new ArrayList<String>();
    ArrayList<JsonModellGyerekek> json_array = new ArrayList<JsonModellGyerekek>();
    ListView list;
    AdapterGyerekek adapter2;
    Context cont =  this;
    int deleteIndex = -1;
    private static String URL = "http://users.ininet.hu/beadando/gyerekekJson.js";

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
                        Magatartas_array.add(jsonObject.getString("Magatartas").toString());
                        Hangulat_array.add(jsonObject.getString("Hangulat").toString());
                        Jelenlet_array.add(jsonObject.getString("Jelenlet").toString());
                        Datum_array.add(jsonObject.getString("Datum").toString());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


                for (int i = 0; i < TeljesNev_array.size(); i++) {
                    json_array.add(i, new JsonModellGyerekek(TeljesNev_array.get(i), Magatartas_array.get(i), Hangulat_array.get(i), Jelenlet_array.get(i), Datum_array.get(i)));
                }

                if(deleteIndex >= 0){
                    Log.d("INDEX:",Integer.toString(deleteIndex));
                    json_array.remove(deleteIndex);
                }

                adapter2 = new AdapterGyerekek(cont,R.layout.activity_szulo_gyerekem,json_array);
                list =  (ListView) findViewById(R.id.list);


                list.setAdapter(adapter2);

                AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        JsonModellGyerekek data = json_array.get(arg2);
                        Intent i = new Intent(cont, DetailActivityGyerekek.class);
                        /*Szintén a modelben a getteről levenni a kommentet*/
                        i.putExtra("TeljesNev", data.getTeljesNev());
                        i.putExtra("Magatartas",data.getMagatartas());
                        i.putExtra("Hangulat", data.getHangulat());
                        i.putExtra("Jelenlet", data.getJelenlet());
                        i.putExtra("Datum", data.getDatum());
                        i.putExtra("index", arg2);
                        startActivity(i);
                        finish();
                    }
                };
                list.setOnItemClickListener(onItemClickListener);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
