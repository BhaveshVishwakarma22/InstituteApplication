package com.lenovo.instituteapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lenovo.instituteapplication.MyAdapterss.StudentListAdapter
import com.lenovo.instituteapplication.model.NoticeItemItem
import com.lenovo.instituteapplication.model.StudentModelItem
import com.lenovo.instituteapplication.repository.Repository

class StudentList : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

        val songList = findViewById<RecyclerView>(R.id.student_list_rv)
        val songObjects:MutableList<StudentModelItem> = mutableListOf()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getAllStudents(institute_loggedin.institute_codes)
        viewModel.StdutendtResponse.observe(this, Observer { response->
            if(response.isSuccessful){
                Log.d("Response", response.toString())
                for(res in response.body()!!){

                    if(res.standard == CommonThing.goBranch){
                        Log.d("Response", res.name)
                        Log.d("Response", res.parents_name)
                        songObjects.add(StudentModelItem(
                            address = res.address,
                            attendence = res.attendence,
                            bus_fee = res.bus_fee,
                            canteen_due = res.canteen_due,
                            college_code = res.college_code,
                            contact_number = res.contact_number,
                            fee_due = res.fee_due,
                            gender = res.gender,
                            hostel_fee = res.hostel_fee,
                            name = res.name,
                            parents_contact = res.parents_contact,
                            parents_name = res.parents_name,
                            password = res.password,
                            performance = res.performance,
                            roll_number = res.roll_number,
                            sno = res.sno,
                            standard = res.standard,
                            total_fee = res.total_fee,
                            tution_fee = res.tution_fee
                        ))
//
                        songList.adapter = StudentListAdapter(songObjects)
                        songList.layoutManager = LinearLayoutManager(applicationContext)
                    }
                }
            }else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        })


        songList.adapter = StudentListAdapter(songObjects)
        songList.layoutManager = LinearLayoutManager(this)
    }
}