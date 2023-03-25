package com.lenovo.instituteapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.button.MaterialButton
import com.lenovo.instituteapplication.commonVar.lMode

object commonVar{
    lateinit var lMode:String                   //Mode selected for sign in
}

class Select_Mode : AppCompatActivity() {

//    lateinit var sgnUpbtn: MaterialButton
    lateinit var logInbtn: MaterialButton
    lateinit var institute_modebtn: MaterialButton
    lateinit var et_email: EditText
    lateinit var et_c_code: EditText
    lateinit var et_fid_or_rno: EditText
    lateinit var et_pass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_mode)

//        sgnUpbtn = findViewById(R.id.btn_signup)
        logInbtn = findViewById(R.id.btn_login)
        institute_modebtn = findViewById(R.id.btn_institute_mode)
        et_email = findViewById(R.id.etMail)
        et_c_code = findViewById(R.id.etC_Code)
        et_fid_or_rno = findViewById(R.id.etfid_or_rno)
        et_pass = findViewById(R.id.etPassword)

//        Spinner Setup
        val modeSpinner: Spinner = findViewById(R.id.mode_spinner)                                  //Spinner element

        val modeAdapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this,
            R.array.modes,
            android.R.layout.simple_spinner_item
        )

        modeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        modeSpinner.adapter = modeAdapter

        modeSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                lMode = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action if Nothing selected
            }
        }

//        Login Button functionality

        logInbtn.setOnClickListener(){
            val mail = et_email.text.toString()
            val ccode = et_c_code.text.toString()
            val pass = et_pass.text.toString()
            val fid_or_rno = et_fid_or_rno.text.toString()

            if((mail == "bv200222@gmail.com") && (ccode == "c-123") && (pass == "1234")){
                    if (lMode == "STUDENT" && (fid_or_rno == "22") ) {
                        val studentIntent = Intent(this, Student_Mode_Main::class.java)
                        startActivity(studentIntent)

                    } else if (lMode == "PARENT"  && (fid_or_rno == "22") ) {
                        val parentIntent = Intent(this, Parent_Mode_Main::class.java)
                        startActivity(parentIntent)

                    } else if (lMode == "TEACHER" && (fid_or_rno == "f1") ) {
                        val teacherIntent = Intent(this, Teacher_Mode_Main::class.java)
                        startActivity(teacherIntent)

                    }else{
                        Toast.makeText(applicationContext, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(applicationContext, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }
        }

        institute_modebtn.setOnClickListener{
            val teacherIntent = Intent(this, MainActivity::class.java)
            startActivity(teacherIntent)
        }

    }
}