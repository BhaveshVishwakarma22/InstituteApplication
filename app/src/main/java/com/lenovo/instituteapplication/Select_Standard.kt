package com.lenovo.instituteapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

object CommonThing{
    lateinit var goFrom:String
    lateinit var goBranch:String
}

class Select_Standard : AppCompatActivity() {

    lateinit var btn_4sem:MaterialButton
    lateinit var btn_5sem:MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_standard)

        btn_4sem = findViewById(R.id.sem4_button)
        btn_5sem = findViewById(R.id.sem5_button)

        btn_4sem.setOnClickListener{
            CommonThing.goBranch = "btech 4 sem"
            val intent = Intent(applicationContext, StudentList::class.java)
            startActivity(intent)
        }

        btn_5sem.setOnClickListener{
            CommonThing.goBranch = "btech 5 sem"
            val intent = Intent(applicationContext, StudentList::class.java)
            startActivity(intent)
        }
    }
}