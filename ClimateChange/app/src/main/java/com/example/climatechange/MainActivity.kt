package com.example.climatechange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var cChangeAdapter : CChangeRecyclerAdapter

    var country : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView()

        ClimateCountryVolley(getClimateAPIUrl(), this, cChangeAdapter).callClimateAPI()
    }

    private fun setRecyclerView(){
        recycler_view_year.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            cChangeAdapter = CChangeRecyclerAdapter()
            adapter = cChangeAdapter
        }
    }

    fun getClimateAPIUrl(): String{
        var climateAPI : String = "http://climatedataapi.worldbank.org/climateweb/rest/v1/country"
        return climateAPI
    }


}
