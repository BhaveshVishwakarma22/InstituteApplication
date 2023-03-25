package com.lenovo.instituteapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lenovo.instituteapplication.model.TeacherChatItem
import com.lenovo.instituteapplication.repository.Repository

class TeacherParentChat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_parent_chat)

        val songList = findViewById<RecyclerView>(R.id.teacher_chat_Rv)
        val songObjects:MutableList<TeacherChatItem> = mutableListOf()
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getAllTChatMsg(institute_loggedin.institute_codes)
        viewModel.Tc_MsgResponse.observe(this, Observer { response->
            if(response.isSuccessful){
                Log.d("Response", response.toString())
                for(res in response.body()!!){
                    Log.d("Response", res.message)
                    Log.d("Response", res.sender)

                    songObjects.add(TeacherChatItem(institute_loggedin.institute_codes, res.message, res.sender, res.sno))

                    songList.adapter = ChatMeassage_Adapter(songObjects)
                    songList.layoutManager = LinearLayoutManager(applicationContext)
                }
            }else{
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}