package com.lenovo.instituteapplication.MyAdapterss

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lenovo.instituteapplication.R
import com.lenovo.instituteapplication.model.StudentModelItem

class StudentListAdapter(val songs:List<StudentModelItem>) : RecyclerView.Adapter<StudentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_item, parent, false)
        return StudentViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.txtTitle.text = "Student Name: ${songs[position].name}"
        holder.txtDesc.text = "R.No.: ${songs[position].roll_number}\n${songs[position].standard}\nContact No.: ${songs[position].contact_number}\nPerformance: ${songs[position].performance}\nAttendance: ${songs[position].attendence}\nTotal Fee: ${songs[position].total_fee}\nFess due: ${songs[position].fee_due}\nTution Fee:${songs[position].tution_fee}\nBus Fee:${songs[position].bus_fee}\nCanteen Due:${songs[position].canteen_due}\nHostel Fee: ${songs[position].hostel_fee}\nAddress: ${songs[position].address}\nParents Name: ${songs[position].parents_name}\nParents Contact: ${songs[position].parents_contact}"
    }

    override fun getItemCount(): Int {
        return songs.size
    }
}

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txtTitle: TextView = itemView.findViewById(R.id.student_name)
    var txtDesc: TextView = itemView.findViewById(R.id.student_description)
}
