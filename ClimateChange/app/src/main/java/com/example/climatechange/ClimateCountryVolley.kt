package com.example.climatechange


import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class ClimateCountryVolley(val url:String, val contexto:Context, val climateAdapter: CChangeRecyclerAdapter){
    val queue = Volley.newRequestQueue(contexto)

    fun callClimateAPI(){
        val dataCountry = ArrayList<ClimateCountry>()
        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            Response.Listener<JSONArray> { response ->
                val countries  = response
                for (i in 0..countries.length()-1){
                    val country = countries.getJSONObject(i)
                    Log.i("object", country.toString())
                    val countryDude  =  ClimateCountry(country.getString("name"), country.getString("iso3"))
                    dataCountry.add(countryDude)
                }


                climateAdapter.setData(dataCountry)
            },
            Response.ErrorListener {
                Log.e("Volley Error", it.toString())
                Toast.makeText(contexto, "That didn't work!" + it.toString(), Toast.LENGTH_SHORT).show()
            })

        queue.add(request)
    }
}