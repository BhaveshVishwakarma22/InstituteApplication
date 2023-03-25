package com.lenovo.instituteapplication.MyAdapterss

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lenovo.instituteapplication.R
import com.lenovo.instituteapplication.model.ParentModelItem
import com.lenovo.instituteapplication.model.StudentModelItem

class ParentListAdapter (val songs:List<ParentModelItem>) : RecyclerView.Adapter<ParentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.parent_item, parent, false)
        return ParentViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        holder.txtParentName.text = "Parent Name: ${songs[position].name}"
        holder.txtStudentName.text = "Child: ${songs[position].child_name}"
        holder.txtDesc.text = "R.No.: ${songs[position].roll_no}\nEmail: ${songs[position].email}\nContact No.:${songs[position].contact}\nTotal Fee: ${songs[position].total_fee}\nFess due: ${songs[position].fee_due}\nTution Fee: ${songs[position].tution_fee}\nBus Fee: ${songs[position].bus_fee}\nCanteen Due: ${songs[position].canteen_due}\nHostel Fee: ${songs[position].hostel_fee}"
    }

    override fun getItemCount(): Int {
        return songs.size
    }
}

class ParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txtParentName: TextView = itemView.findViewById(R.id.parent_name)
    var txtStudentName: TextView = itemView.findViewById(R.id.student_name2)
    var txtDesc: TextView = itemView.findViewById(R.id.parent_description)
}