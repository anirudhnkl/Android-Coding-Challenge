package com.anirudh.codingchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView mRecyclerView;
    private GuideAdapter mAdapter;
    private List<Guide> guides = new ArrayList<Guide>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new GuideAdapter(guides);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        getData();
    }

    private void getData()
    {
        String url = "https://guidebook.com/service/v2/upcomingGuides/";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>()
        {
            Guide guide;
            @Override
            public void onResponse(JSONObject response)
            {
                JSONArray array;
                JSONObject guideObject;
                JSONObject venue;
                String city = " ";
                String state = " ";
                try
                {
                    array = response.getJSONArray("data");
                    for(int i = 0; i < array.length(); i++)
                    {
                        guideObject = array.getJSONObject(i);
                        venue = guideObject.getJSONObject("venue");

                        if (venue.has("city"))
                            city = venue.getString("city");
                        if (venue.has("state"))
                            city = venue.getString("state");

                        guide = new Guide(
                                guideObject.getString("name"),
                                guideObject.getString("endDate"),
                                city,
                                state,
                                guideObject.getString("icon"));
                        guides.add(guide);
                    }
                }
                catch(JSONException e)
                {
                    e.printStackTrace();;
                }

                mAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(this).add(request);

    }
}
