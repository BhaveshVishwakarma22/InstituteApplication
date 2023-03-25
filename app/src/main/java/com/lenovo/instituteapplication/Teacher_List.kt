package com.lenovo.instituteapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lenovo.instituteapplication.MyAdapterss.ParentListAdapter
import com.lenovo.instituteapplication.MyAdapterss.TeacherListAdapter
import com.lenovo.instituteapplication.model.ParentModelItem
import com.lenovo.instituteapplication.model.TeacherModelItem
import com.lenovo.instituteapplication.repository.Repository

class Teacher_List : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_list)

        val songList = findViewById<RecyclerView>(R.id.teacher_list_rv)
        val songObjects:MutableList<TeacherModelItem> = mutableListOf()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getAllTeachers(institute_loggedin.institute_codes)
        viewModel.TeacherLResponse.observe(this, Observer { response->
            if(response.isSuccessful){
                Log.d("Response", response.toString())
                for(res in response.body()!!){
                    Log.d("Response", res.name)
                    songObjects.add(
                        TeacherModelItem(
                            canteen_due = res.canteen_due,
                            college_code = res.college_code,
                            name = res.name,
                            password = res.password,
                            sno = res.sno,
                            contact = res.contact,
                            email = res.email,
                            address = res.address,
                            attendence = res.attendence,
                            branch = res.branch,
                            faculty_id = res.faculty_id,
                            mess_fee = res.mess_fee,
                            salary = res.salary,
                            performance = res.performance
                        )
                    )
//
                    songList.adapter = TeacherListAdapter(songObjects)
                    songList.layoutManager = LinearLayoutManager(applicationContext)
                }
            }else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        })

        songList.adapter = TeacherListAdapter(songObjects)
        songList.layoutManager = LinearLayoutManager(this)
    }
}