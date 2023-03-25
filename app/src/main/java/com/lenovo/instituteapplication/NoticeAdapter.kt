package com.lenovo.instituteapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lenovo.instituteapplication.model.NoticeItemItem

class MyAdapter(val songs:List<NoticeItemItem>) : RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.notice_item, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtMsg.text = songs[position].notice
        holder.txtpub.text = songs[position].notice_publisher
    }
    override fun getItemCount(): Int {
        return songs.size
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txtMsg:TextView = itemView.findViewById(R.id.notice_msg)
    var txtpub:TextView = itemView.findViewById(R.id.notice_pub)
}