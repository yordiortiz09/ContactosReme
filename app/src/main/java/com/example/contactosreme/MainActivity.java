package com.example.contactosreme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

import Adaptadores.AdaptadorData;
import Modelos.Contacto;
import Modelos.Data;

public class MainActivity extends AppCompatActivity {
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = Singleton.getInstance(MainActivity.this).getRequestQueue();

         RecyclerView recyclerView = findViewById(R.id.recyclerView);
         String url="https://ramiro.uttics.com/api/contactos";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                Data data = gson.fromJson(String.valueOf(response), Data.class);
                List<Contacto> contactos = data.getData();
                AdaptadorData adaptadorData = new AdaptadorData(contactos, MainActivity.this);
                recyclerView.setAdapter(adaptadorData);
                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager manager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(manager);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}