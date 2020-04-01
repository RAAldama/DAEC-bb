package com.example.climatechange

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.climate_country_layout.view.*
import kotlinx.android.synthetic.main.climate_year_layout.view.*

class CYearRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var years: List<ClimateYear> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ClimateYearViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.climate_year_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return years.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ClimateYearViewHolder -> {
                holder.bind(years.get(position))
            }
        }
    }

    fun setData(listYears: List<ClimateYear>) {
        years = listYears
        notifyDataSetChanged()
    }

    class ClimateYearViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val year = itemView.yearNumber
        val temp = itemView.yearTemp

        fun bind(climateYear: ClimateYear) {
            year.text = climateYear.year
            temp.text = climateYear.temp
        }
    }
}