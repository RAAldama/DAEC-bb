package com.example.climatechange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_country.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray

class countryActivity : AppCompatActivity() {

    private lateinit var cYearAdapter : CYearRecyclerAdapter

    var country : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)
        val iso = intent.getStringExtra("iso")
        setRecyclerView()
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        ClimateYearVolley(getClimateAPIUrl(iso), this, cYearAdapter).callClimateAPI()
    }

    private fun setRecyclerView(){
        recycler_view_year.apply{
            layoutManager = LinearLayoutManager(this@countryActivity)
            cYearAdapter = CYearRecyclerAdapter()
            adapter = cYearAdapter
        }
    }

    fun getClimateAPIUrl(iso:String): String{
        var climateAPI : String = "http://climatedataapi.worldbank.org/climateweb/rest/v1/country/cru/tas/year/"+iso
        return climateAPI
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}