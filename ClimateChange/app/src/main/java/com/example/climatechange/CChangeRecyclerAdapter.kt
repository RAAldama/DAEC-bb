package com.example.climatechange

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.climate_country_layout.view.*

class CChangeRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var countries: List<ClimateCountry> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ClimateCountryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.climate_country_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return countries.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ClimateCountryViewHolder -> {
                holder.bind(countries.get(position))
            }
        }
    }

    fun setData(listCountries: List<ClimateCountry>) {
        countries = listCountries
        notifyDataSetChanged()
    }

    class ClimateCountryViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.countryName
        val iso = itemView.countryISO
        val btn = itemView.infoBtn

        fun bind(climateCountry: ClimateCountry) {
            name.text = climateCountry.nombre
            iso.text = climateCountry.iso3
            btn.setOnClickListener{
                val intent = Intent(itemView.context, countryActivity::class.java)
                intent.putExtra("iso", iso.text as String)
                itemView.context.startActivity(intent)
            }
        }
    }
}