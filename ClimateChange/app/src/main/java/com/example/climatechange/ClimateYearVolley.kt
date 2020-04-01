package com.example.climatechange


import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class ClimateYearVolley(val url:String, val contexto:Context, val climateAdapter: CYearRecyclerAdapter){
    val queue = Volley.newRequestQueue(contexto)

    fun callClimateAPI(){
        val dataYear = ArrayList<ClimateYear>()
        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            Response.Listener<JSONArray> { response ->
                val years = response
                for (i in 0..years.length()-1){
                    val year = years.getJSONObject(i)
                    val yearDude  =  ClimateYear(year.getString("year"), year.getString("data"))
                    dataYear.add(yearDude)
                }

                climateAdapter.setData(dataYear)
            },
            Response.ErrorListener {
                Log.e("Volley Error", it.toString())
                Toast.makeText(contexto, "That didn't work!" + it.toString(), Toast.LENGTH_SHORT).show()
            })

        queue.add(request)
    }
}