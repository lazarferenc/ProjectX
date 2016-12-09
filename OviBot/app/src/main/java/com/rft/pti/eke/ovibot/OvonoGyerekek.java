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

    EditText TeljesNev, Magatartas,Hangulat,Jelenlet,Datum;
    Button gyerekFel;
    RequestQueue requestQueue;
    String insertUrl = "http://users.ininet.hu/beadando/insertGyerekek.php";
    //String JSON_STRING;
    //String showUrl = "http://users.ininet.hu/beadando/selectGyerekek.php";//php fál hibás.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovono_gyerekek);

        TeljesNev = (EditText) findViewById(R.id.et_teljnev);
        Magatartas = (EditText) findViewById(R.id.et_magatartas);
        Hangulat = (EditText) findViewById(R.id.et_hangulat);
        Jelenlet = (EditText) findViewById(R.id.et_jelenlet);
        Datum = (EditText) findViewById(R.id.et_date);
        gyerekFel = (Button) findViewById(R.id.btn_gyerek_fel);



        requestQueue = Volley.newRequestQueue(getApplicationContext());
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
                                parameters.put("Datum", Datum.getText().toString());
                                return parameters;
                            }
                        };
                        requestQueue.add(request);
                    }
                });
    }

}





