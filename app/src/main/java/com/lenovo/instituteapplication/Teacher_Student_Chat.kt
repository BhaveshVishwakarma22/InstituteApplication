package com.lenovo.instituteapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.lenovo.instituteapplication.BossObj.dataBoss
import com.lenovo.instituteapplication.model.TeacherChatItem
import com.lenovo.instituteapplication.repository.Repository
import com.lenovo.instituteapplication.util.Constants.Companion.BASE_URL
import okhttp3.*
import java.io.IOException



class Teacher_Student_Chat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_student_chat)

        val et_msg_box:EditText = findViewById(R.id.et_ts_msg)
        val btn_msg_send:MaterialButton = findViewById(R.id.btn_ts_send)
        val tsc_tittle:TextView = findViewById(R.id.home_tsc_title)

        val songList = findViewById<RecyclerView>(R.id.ts_chat_Rv)

        if(dataBoss){
            tsc_tittle.text = "Teacher Student Chat"
        }else{
            tsc_tittle.text = "Teacher Chat"
        }

        val songObjects:MutableList<TeacherChatItem> = mutableListOf()
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getAllTSChatMsg(institute_loggedin.institute_codes)
        viewModel.TS_MsgResponse.observe(this, Observer { response->
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



        btn_msg_send.setOnClickListener{
            val msg = et_msg_box.text
//            ------------------------------------------Ok Http
            val client:OkHttpClient = okhttp3.OkHttpClient()
            val url = "$BASE_URL/add_row_tschat_table/${institute_loggedin.institute_codes}/Bhavesh/${msg}"
            val request = okhttp3.Request.Builder()
                .url(url)
                .build()

            client.newCall(request).enqueue(object :Callback{
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    val intent = Intent(applicationContext, Teacher_Student_Chat::class.java)
                    startActivity(intent)
                }
            })
        }
    }
}