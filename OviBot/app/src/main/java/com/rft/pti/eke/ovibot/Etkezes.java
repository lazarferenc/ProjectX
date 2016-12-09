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

import com.android.volley.toolbox.HttpClientStack;
import com.rft.pti.eke.ovibot.Adapter.AdapterEtkezes;
import com.rft.pti.eke.ovibot.Model.DetailActivity;
import com.rft.pti.eke.ovibot.Model.JsonModellEtkezes;

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

public class Etkezes extends Activity {

    ArrayList<String> Datum_array = new ArrayList<String>();
    ArrayList<String> Reggeli_array = new ArrayList<String>();
    ArrayList<String> Ebed_array = new ArrayList<String>();
    ArrayList<String> Uzsonna_array = new ArrayList<String>();
    //ArrayList<String> Datum_array = new ArrayList<String>();
    ArrayList<JsonModellEtkezes> json_array = new ArrayList<JsonModellEtkezes>();
    ListView list;
    AdapterEtkezes adapter;
    Context cont =  this;
    int deleteIndex = -1;
    private static String URL = "http://users.ininet.hu/beadando/etkezes.js";

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
                        Datum_array.add(jsonObject.getString("Datum").toString());
                        Reggeli_array.add(jsonObject.getString("Reggeli").toString());
                        Ebed_array.add(jsonObject.getString("Ebed").toString());
                        Uzsonna_array.add(jsonObject.getString("Uzsonna").toString());
                        //Datum_array.add(jsonObject.getString("Datum").toString());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 0; i < Datum_array.size(); i++) {
                    json_array.add(i, new JsonModellEtkezes(Datum_array.get(i), Reggeli_array.get(i), Ebed_array.get(i), Uzsonna_array.get(i) ));
                }

                if(deleteIndex >= 0){
                    Log.d("INDEX:",Integer.toString(deleteIndex));
                    json_array.remove(deleteIndex);
                }


                adapter = new AdapterEtkezes(cont,R.layout.activity_etkezes,json_array);
                list =  (ListView) findViewById(R.id.list);


                list.setAdapter(adapter);

                AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        JsonModellEtkezes data = json_array.get(arg2);
                        Intent i = new Intent(cont, DetailActivity.class);
                        i.putExtra("Datum", data.getDatum());
                        i.putExtra("Reggeli",data.getReggeli());
                        i.putExtra("Ebed", data.getEbed());
                        i.putExtra("Uzsonna", data.getUzsonna());

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