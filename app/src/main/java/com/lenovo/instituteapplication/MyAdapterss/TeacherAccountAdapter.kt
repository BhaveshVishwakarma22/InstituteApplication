package com.lenovo.instituteapplication.MyAdapterss

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lenovo.instituteapplication.R
import com.lenovo.instituteapplication.model.StudentAccountItem
import com.lenovo.instituteapplication.model.TeacherAccountMModelItem

class TeacherAccountAdapter(val songs:List<TeacherAccountMModelItem>) : RecyclerView.Adapter<TeacherAccountViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherAccountViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_account_item, parent, false)
        return TeacherAccountViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: TeacherAccountViewHolder, position: Int) {
        holder.txtTitle.text = "Faculty ID: ${songs[position].faculty_id}\nPayment: ${songs[position].payment}\nPayment Due: ${songs[position].payment_due}\nCanteen Due: ${songs[position].canteen_due}\nMess Fee: ${songs[position].mess_fee}"
    }

    override fun getItemCount(): Int {
        return songs.size
    }
}

class TeacherAccountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txtTitle: TextView = itemView.findViewById(R.id.tv_student_account)
}