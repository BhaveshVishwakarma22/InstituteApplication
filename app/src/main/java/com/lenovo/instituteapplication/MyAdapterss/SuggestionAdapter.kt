package com.lenovo.instituteapplication.MyAdapterss

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lenovo.instituteapplication.R
import com.lenovo.instituteapplication.model.SuggestionModelItem
import com.lenovo.instituteapplication.sug_oor_com

class SuggestionAdapter(val songs:List<SuggestionModelItem>) : RecyclerView.Adapter<SuggestionViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.suggestion_item, parent, false)
        return SuggestionViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SuggestionViewHolder, position: Int) {
        if(sug_oor_com.sorcom){
            holder.txtTitle.text = "${songs[position].message}\nPublisher: ${songs[position].sender}"
        }else{
            holder.txtTitle.text = "${songs[position].message}"
        }

    }

    override fun getItemCount(): Int {
        return songs.size
    }
}

class SuggestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txtTitle: TextView = itemView.findViewById(R.id.suggestion_msg)
}