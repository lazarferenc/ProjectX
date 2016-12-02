package com.rft.pti.eke.ovibot;

import android.app.DownloadManager;
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

import java.util.HashMap;
import java.util.Map;


public class OvonoGyerekek extends AppCompatActivity {

    EditText TeljNev, Magatartas,Hangulat,Jelenlet;
    Button gyerekFel, gyerekMegjelenit;
    TextView lista;
    RequestQueue requestQueue;
    String insertUrl = "http://users.ininet.hu/beadando/insertGyerekek.php";
    String showUrl = "http://users.ininet.hu/beadando/selectGyerekek.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovono_gyerekek);

        TeljNev = (EditText) findViewById(R.id.et_teljnev);
        Magatartas = (EditText) findViewById(R.id.et_magatartas);
        Hangulat = (EditText) findViewById(R.id.et_hangulat);
        Jelenlet = (EditText) findViewById(R.id.et_jelenlet);
        gyerekFel = (Button) findViewById(R.id.btn_gyerek_megjelenit);
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

                            JSONArray students = response.getJSONArray("students");
                            for (int i = 0; i < students.length(); i++) {
                                JSONObject student = students.getJSONObject(i);


                                String TeljesNev = student.getString("TeljNev");
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


                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                requestQueue.add(jsonObjectRequest);


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
                                parameters.put("TeljNev", TeljNev.getText().toString());
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
        });
    }}





