package com.santacoder.getdatetimefrominternet;

import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class GetDateTime {
    Activity activity;
    String DT_API = "https://www.timeapi.io/api/Time/current/coordinate?latitude=22.5726&longitude=88.3639";
    RequestQueue requestQueue;



    public GetDateTime(Activity activity) {
        this.activity = activity;
        requestQueue = Volley.newRequestQueue(activity);
    }

    public void onGetDateTime(DateTimeInterface dateTimeInterface){
        JSONObject jsonObject = new JSONObject();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                DT_API, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    dateTimeInterface.onGetDateTime(
                            response.getString("day"),
                            response.getString("month"),
                            response.getString("year"),
                            response.getString("hour"),
                            response.getString("minute"),
                            response.getString("seconds"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }

    public interface DateTimeInterface{
        void onGetDateTime(String day, String month, String year, String hour, String minute, String second);
    }
}
