package com.lenovo.instituteapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lenovo.instituteapplication.model.TeacherChatItem

class ChatMeassage_Adapter(val songs:List<TeacherChatItem>) : RecyclerView.Adapter<Chat_msg_MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Chat_msg_MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.chat_item, parent, false)
        return Chat_msg_MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: Chat_msg_MyViewHolder, position: Int) {
        holder.msg.text = songs[position].message
    }

    override fun getItemCount(): Int {
        return songs.size
    }
}

class Chat_msg_MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var msg:TextView = itemView.findViewById(R.id.tv_chat_msg)
}