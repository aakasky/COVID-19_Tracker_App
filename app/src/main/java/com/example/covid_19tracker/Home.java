package com.example.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    RecyclerView mRecyclerView;
    private static String covidUrl = "https://data.covid19india.org/district_wise.json";
    List<Model> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mList = new ArrayList<>();

        StringRequest request = new StringRequest(covidUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonData(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Some error occurred!!", Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(Home.this);
        rQueue.add(request);

    }

    void parseJsonData(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("districts");

            for (int i = 0; i < jsonArray.length(); ++i) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                Model model = new Model();
                model.setDistrictName(jsonObject1.getString("district"));
                model.setActive(jsonObject1.getString("active"));
                model.setRecovered(jsonObject1.getString("recovered"));
                model.setDeceased(jsonObject1.getString("deceased"));
                model.setConfirmed(jsonObject1.getString("confirmed"));
                model.setnActive(jsonObject1.getString("deltaactive"));
                model.setnRecovered(jsonObject1.getString("deltarecovered"));
                model.setnDead(jsonObject1.getString("deltadeceased"));

                mList.add(model);
            }

            Adapter myAdapter = new Adapter(getApplicationContext(), mList);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            mRecyclerView.setAdapter(myAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}