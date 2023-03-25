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
import com.lenovo.instituteapplication.MyAdapterss.StudentListAdapter
import com.lenovo.instituteapplication.model.ParentModelItem
import com.lenovo.instituteapplication.model.StudentModelItem
import com.lenovo.instituteapplication.repository.Repository

class Parent_List : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_list)

        val songList = findViewById<RecyclerView>(R.id.parent_list_rv)
        val songObjects:MutableList<ParentModelItem> = mutableListOf()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getAllParents(institute_loggedin.institute_codes)
        viewModel.ParentsLResponse.observe(this, Observer { response->
            if(response.isSuccessful){
                Log.d("Response", response.toString())
                for(res in response.body()!!){
                    Log.d("Response", res.name)
                    songObjects.add(
                        ParentModelItem(
                            bus_fee = res.bus_fee,
                            canteen_due = res.canteen_due,
                            college_code = res.college_code,
                            fee_due = res.fee_due,
                            hostel_fee = res.hostel_fee,
                            name = res.name,
                            password = res.password,
                            sno = res.sno,
                            total_fee = res.total_fee,
                            tution_fee = res.tution_fee,
                            child_name = res.child_name,
                            contact = res.contact,
                            email = res.email,
                            roll_no = res.roll_no,
                        )
                    )
//
                    songList.adapter = ParentListAdapter(songObjects)
                    songList.layoutManager = LinearLayoutManager(applicationContext)
                }
            }else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        })

        songList.adapter = ParentListAdapter(songObjects)
        songList.layoutManager = LinearLayoutManager(this)
    }
}