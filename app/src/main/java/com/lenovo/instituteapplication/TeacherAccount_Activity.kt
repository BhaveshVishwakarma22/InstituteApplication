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
import com.lenovo.instituteapplication.MyAdapterss.TeacherAccountAdapter
import com.lenovo.instituteapplication.model.StudentAccountItem
import com.lenovo.instituteapplication.model.TeacherAccountMModelItem
import com.lenovo.instituteapplication.repository.Repository

class TeacherAccount_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_account)

        val songList = findViewById<RecyclerView>(R.id.teacher_acount_list_rv)
        val songObjects:MutableList<TeacherAccountMModelItem> = mutableListOf()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getAllAccountTeacher(institute_loggedin.institute_codes)
        viewModel.TeacherAccountResponse.observe(this, Observer { response->
            if(response.isSuccessful){
                Log.d("Response", response.toString())
                for(res in response.body()!!){
                    songObjects.add(
                        TeacherAccountMModelItem(
                            sno = res.sno,
                            faculty_id = res.faculty_id,
                            college_code = res.college_code,
                            payment = res.payment,
                            payment_due = res.payment_due,
                            mess_fee = res.mess_fee,
                            canteen_due = res.canteen_due
                        )
                    )
//
                    songList.adapter = TeacherAccountAdapter(songObjects)
                    songList.layoutManager = LinearLayoutManager(applicationContext)
                }
            }else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        })

        songList.adapter = TeacherAccountAdapter(songObjects)
        songList.layoutManager = LinearLayoutManager(this)
    }
}