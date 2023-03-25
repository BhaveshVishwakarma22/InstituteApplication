package com.lenovo.instituteapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lenovo.instituteapplication.MyAdapterss.StudentAccountAdapter
import com.lenovo.instituteapplication.MyAdapterss.StudentListAdapter
import com.lenovo.instituteapplication.model.StudentAccountItem
import com.lenovo.instituteapplication.model.StudentModelItem
import com.lenovo.instituteapplication.repository.Repository

class Student_Account : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_account)

        val songList = findViewById<RecyclerView>(R.id.student_acount_list_rv)
        val songObjects:MutableList<StudentAccountItem> = mutableListOf()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getAllAccountStudent(institute_loggedin.institute_codes)
        viewModel.StudentAccountResponse.observe(this, Observer { response->
            if(response.isSuccessful){
                Log.d("Response", response.toString())
                for(res in response.body()!!){
                    songObjects.add(
                        StudentAccountItem(
                            bus_fee = res.bus_fee,
                            canteen_due = res.canteen_due,
                            college_code = res.college_code,
                            fee_due = res.fee_due,
                            hostel_fee = res.hostel_fee,
                            sno = res.sno,
                            tution_fee = res.tution_fee,
                            roll_no = res.roll_no,
                            totall_fee = res.totall_fee
                        )
                    )
//
                    songList.adapter = StudentAccountAdapter(songObjects)
                    songList.layoutManager = LinearLayoutManager(applicationContext)
                }
            }else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        })


        songList.adapter = StudentAccountAdapter(songObjects)
        songList.layoutManager = LinearLayoutManager(this)
    }
}