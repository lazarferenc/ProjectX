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


}
