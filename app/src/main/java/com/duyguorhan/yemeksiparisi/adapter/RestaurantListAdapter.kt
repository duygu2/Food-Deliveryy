package com.duyguorhan.yemeksiparisi.adapter

import android.icu.util.Calendar
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.duyguorhan.yemeksiparisi.R
import com.duyguorhan.yemeksiparisi.models.Hours
import com.duyguorhan.yemeksiparisi.models.RestaurantModel
import java.text.SimpleDateFormat
import java.util.*

class RestaurantListAdapter(val restaurantList:List<RestaurantModel?>?, val clickListener: RestaurantListClickListener):RecyclerView.Adapter<RestaurantListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantListAdapter.MyViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.recycler_restaurant_list_row,parent,false)

        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: RestaurantListAdapter.MyViewHolder, position: Int) {
        holder.bind(restaurantList?.get(position))
        holder.itemView.setOnClickListener{
            clickListener.onItemClick(restaurantList?.get(position)!!)
        }
    }

    override fun getItemCount(): Int {
        return restaurantList?.size!!
    }

    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){

        val tvRestaurantName:TextView=view.findViewById(R.id.tvRestaurantName)
        val tvRestaurantAddress:TextView=view.findViewById(R.id.tvRestaurantAddress)
        val tvRestaurantHours:TextView=view.findViewById(R.id.tvRestaurantHours)
        val thumbImage: ImageView =view.findViewById(R.id.thumbImage)



        fun bind(restaurantModel: RestaurantModel?){
            tvRestaurantName.text=restaurantModel?.name
            tvRestaurantAddress.text= "Address: "+restaurantModel?.address
            tvRestaurantHours.text= "Today's Hours: " +getTodaysHours(restaurantModel?.hours!!)

            Glide.with(thumbImage)
                .load(restaurantModel?.image)
                .into(thumbImage)
        }
    }


    private fun getTodaysHours(hours: Hours):String? {
        val calendar: Calendar = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Calendar.getInstance()
        } else {
            TODO("VERSION.SDK_INT < N")
        }
        val date: Date = calendar.time
        val day: String = SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.time)
        return when (day) {
            "Sunday" -> hours.Sunday
            "Monday" -> hours.Monday
            "Tuesday" -> hours.Tuesday
            "Wednesday" -> hours.Wednesday
            "Thursday" -> hours.Thursday
            "Friday" -> hours.Friday
            "Saturday" -> hours.Saturday
            else -> hours.Sunday
        }

    }
    interface RestaurantListClickListener {
        fun onItemClick(restaurantModel: RestaurantModel?)
    }
}