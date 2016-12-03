package com.rft.pti.eke.ovibot;

import android.app.DownloadManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class OvonoGyerekek extends AppCompatActivity {

    EditText TeljesNev, Magatartas,Hangulat,Jelenlet;
    Button gyerekFel, gyerekMegjelenit;
    TextView lista;
    RequestQueue requestQueue;
    String insertUrl = "http://users.ininet.hu/beadando/insertGyerekek.php";
    String JSON_STRING;
    String showUrl = "http://users.ininet.hu/beadando/selectGyerekek.php";//php fál hibás.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovono_gyerekek);

        TeljesNev = (EditText) findViewById(R.id.et_teljnev);
        Magatartas = (EditText) findViewById(R.id.et_magatartas);
        Hangulat = (EditText) findViewById(R.id.et_hangulat);
        Jelenlet = (EditText) findViewById(R.id.et_jelenlet);
        gyerekFel = (Button) findViewById(R.id.btn_gyerek_fel);
        gyerekMegjelenit = (Button) findViewById(R.id.btn_gyerek_megjelenit);

        lista= (TextView) findViewById(R.id.tv_kilistaz);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        gyerekMegjelenit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, showUrl, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray gyerekek = response.getJSONArray("gyerekek");
                            for (int i = 0; i < gyerekek.length(); i++) {
                                JSONObject student = gyerekek.getJSONObject(i);


                                String TeljesNev = student.getString("TeljesNev");
                                String Magatartas = student.getString("Magatartas");
                                String Hangulat = student.getString("Hangulat");
                                String Jelenlet = student.getString("Jelenlet");


                                lista.append(TeljesNev+ " " +Magatartas + " " + Hangulat + " " + Jelenlet + "\n");
                            }
                            lista.append("===\n");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }


                },
                        new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                requestQueue.add(jsonObjectRequest);


            }
        });
        gyerekFel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {

                                Map<String, String> parameters = new HashMap<String, String>();
                                parameters.put("TeljesNev", TeljesNev.getText().toString());
                                parameters.put("Magatartas", Magatartas.getText().toString());
                                parameters.put("Hangulat", Hangulat.getText().toString());
                                parameters.put("Jelenlet", Jelenlet.getText().toString());
                                return parameters;
                            }
                        };
                        requestQueue.add(request);
                    }
                });
    }
    /*public void getJSON(View view)
    {
            new BackgroundTask().execute();
    }
    class BackgroundTask extends AsyncTask<Void,Void,String>
    {
        String json_url;
        @Override
        protected void onPreExecute() {
            json_url = "https://adobe.github.io/Spry/data/json/array-02.js";
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while((JSON_STRING = bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(JSON_STRING+"\n");

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            TextView lista= (TextView) findViewById(R.id.tv_kilistaz);
            lista.setText(result);
        }
    }*/
}





