package com.lenovo.instituteapplication.MyAdapterss

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lenovo.instituteapplication.R
import com.lenovo.instituteapplication.model.ParentModelItem
import com.lenovo.instituteapplication.model.TeacherModelItem

class TeacherListAdapter (val songs:List<TeacherModelItem>) : RecyclerView.Adapter<TeacherViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.parent_item, parent, false)
        return TeacherViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        holder.txtParentName.text = "Teacher's Name: ${songs[position].name}"
        holder.txtStudentName.text = "Faculty Id: ${songs[position].faculty_id}\nBranch:${songs[position].branch}"
        holder.txtDesc.text = "Contact: ${songs[position].contact}\nEmail: ${songs[position].email}\nPerformance: ${songs[position].performance}\nSalary: ${songs[position].salary}\nAttendance: ${songs[position].attendence}\nMess fee: ${songs[position].mess_fee}\nCanteen Due: ${songs[position].canteen_due}"
    }

    override fun getItemCount(): Int {
        return songs.size
    }
}

class TeacherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txtParentName: TextView = itemView.findViewById(R.id.parent_name)
    var txtStudentName: TextView = itemView.findViewById(R.id.student_name2)
    var txtDesc: TextView = itemView.findViewById(R.id.parent_description)
}