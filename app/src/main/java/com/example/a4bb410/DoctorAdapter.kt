package com.example.a4bb410

import androidx.recyclerview.widget.RecyclerView
import com.example.a4bb410.databinding.ItemDoctorBinding

class DoctorAdapter(val list: List<DoctorItemModel>):RecyclerView.Adapter<DoctorAdapter.ViewHolder>() {
    class ViewHolder(val item: ItemDoctorBinding): RecyclerView.ViewHolder(item.root)
}