package com.example.ecommerceapp

import android.app.Activity
import android.media.audiofx.AudioEffect.Descriptor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity,val ProductList: List<Product>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val ratings : TextView
        val image : ImageView
        val title: TextView
       // var description :TextView
        var price : TextView
        init {
            ratings= itemView.findViewById(R.id.rateings)
            price = itemView.findViewById(R.id.ProductPrice)
         //   description= itemView.findViewById(R.id.textDesc)
            image= itemView.findViewById(R.id.ProductImage)
            title= itemView.findViewById(R.id.ProductName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView= LayoutInflater.from(context).inflate(R.layout.each_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return ProductList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val CurrItem = ProductList[position]
        holder.title.text=CurrItem.title

        holder.price.text="$"+CurrItem.price.toString()
       // holder.description.text=CurrItem.description
        var stars : Int
        stars=1
        var rates : String
        rates = ""
        while (stars <= CurrItem.rating ){
            rates= rates+ "*"
            stars+=1
        }
holder.ratings.text = rates
        Picasso.get().load(CurrItem.thumbnail).into(holder.image);

    }
}