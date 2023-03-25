package com.lenovo.instituteapplication.MyAdapterss

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lenovo.instituteapplication.R
import com.lenovo.instituteapplication.model.StudentAccountItem
import com.lenovo.instituteapplication.model.StudentModelItem

class StudentAccountAdapter(val songs:List<StudentAccountItem>) : RecyclerView.Adapter<StudentAccountViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAccountViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_account_item, parent, false)
        return StudentAccountViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: StudentAccountViewHolder, position: Int) {
        holder.txtTitle.text = "Roll No: ${songs[position].roll_no}\nFee Due: ${songs[position].fee_due}\nCanteen Due: ${songs[position].canteen_due}\nBus Fee: ${songs[position].bus_fee}\nTotal Fee: ${songs[position].totall_fee}\nTution Fee: ${songs[position].tution_fee}\nHostel Fee: ${songs[position].hostel_fee}"
    }

    override fun getItemCount(): Int {
        return songs.size
    }
}

class StudentAccountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txtTitle: TextView = itemView.findViewById(R.id.tv_student_account)
}