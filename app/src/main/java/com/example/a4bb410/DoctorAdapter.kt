package com.example.a4bb410

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a4bb410.databinding.ItemDoctorBinding

class DoctorAdapter(val list: List<DoctorItemModel>):RecyclerView.Adapter<DoctorAdapter.ViewHolder>() {

    var listener: OnDoctorClickListener? = null


    class ViewHolder(val item: ItemDoctorBinding): RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemDoctorBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val doctor = list[position]
        holder.item.itemDoctorName.text = doctor.name
        holder.item.itemDoctorSpecialist.text = doctor.specility
        holder.item.itemDoctorSumary.text = doctor.caption
        holder.item.itemDoctorImage.setImageResource(doctor.image.toInt())
        holder.item.itemDoctorStar.rating = (doctor.star / 5.0).toFloat()
        holder.item.root.setOnClickListener {
            listener?.onClick(doctor)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}