package com.lenovo.instituteapplication

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.lenovo.instituteapplication.util.Constants
import okhttp3.*
import java.io.IOException

class Institute_home : AppCompatActivity() {

    lateinit var tv_Institute_name:TextView
    lateinit var tv_Institute_code:TextView
    lateinit var tv_Institute_email_add:TextView
    lateinit var btn_edit_Institute:ImageButton

    lateinit var btn_teacher_chat:MaterialButton
    lateinit var btn_parent_institute_chat:MaterialButton
    lateinit var btn_teacher_student_chat:MaterialButton
    lateinit var btn_student_list:MaterialButton
    lateinit var btn_parent_list:MaterialButton
    lateinit var btn_teacher_list:MaterialButton
    lateinit var btn_student_account:MaterialButton
    lateinit var btn_suggestion:MaterialButton
    lateinit var btn_complaint:MaterialButton
    lateinit var btn_teacher_account:MaterialButton

    lateinit var home_tab_rl: LinearLayout
    lateinit var record_tab_rl: LinearLayout
    lateinit var chat_tab_rl: LinearLayout
    lateinit var account_tab_rl: LinearLayout
    lateinit var suggestion_tab_rl: LinearLayout


    lateinit var bottom_nav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_institute_home)

        tv_Institute_name = findViewById(R.id.home_i_name)
        tv_Institute_code = findViewById(R.id.home_i_code)
        tv_Institute_email_add = findViewById(R.id.home_i_email_add)
        btn_edit_Institute = findViewById(R.id.btn_edit_institute)
        btn_teacher_chat = findViewById(R.id.btn_teacher_chat)
        btn_parent_institute_chat = findViewById(R.id.btn_parent_instiute_chat)
        btn_teacher_student_chat = findViewById(R.id.btn_student_teacher_chat)
        btn_student_list = findViewById(R.id.btn_student_List)
        btn_parent_list = findViewById(R.id.btn_parent_List)
        btn_teacher_list = findViewById(R.id.btn_teacher_List)
        btn_student_account = findViewById(R.id.btn_student_account)
        btn_suggestion = findViewById(R.id.btn_suggestion3)
        btn_complaint = findViewById(R.id.btn_complaint3)
        btn_teacher_account = findViewById(R.id.btn_teacher_account1)

        bottom_nav = findViewById<BottomNavigationView>(R.id.bottom_navigation_home)

        home_tab_rl = findViewById(R.id.home_tab)
        chat_tab_rl = findViewById(R.id.chat_tab)
        record_tab_rl = findViewById(R.id.record_tab)
        account_tab_rl = findViewById(R.id.account_tab)
        suggestion_tab_rl = findViewById(R.id.suggestion_tab_ll)


        home_tab_rl.isVisible = true
        chat_tab_rl.isVisible = false
        record_tab_rl.isVisible = false
        account_tab_rl.isVisible = false
        suggestion_tab_rl.isVisible = false


        bottom_nav.setOnNavigationItemSelectedListener {item->
            when(item.itemId){
                R.id.page_1->{
                    Log.d("mode","Home")
                    home_tab_rl.isVisible = true
                    chat_tab_rl.isVisible = false
                    record_tab_rl.isVisible = false
                    account_tab_rl.isVisible = false
                    suggestion_tab_rl.isVisible = false
                }

//                          ------------------------------------    Chat
//                R.id.page_2->{
//                    Log.d("mode","Chat")
//                    home_tab_rl.isVisible = false
//                    chat_tab_rl.isVisible = true
//                    record_tab_rl.isVisible = false
//                    account_tab_rl.isVisible = false
//                    suggestion_tab_rl.isVisible = false
//                }
                R.id.page_3->{
                    Log.d("mode","Record")
                    home_tab_rl.isVisible = false
                    chat_tab_rl.isVisible = false
                    record_tab_rl.isVisible = true
                    account_tab_rl.isVisible = false
                    suggestion_tab_rl.isVisible = false
                }
                R.id.page_4->{
                    Log.d("mode","Account")
                    home_tab_rl.isVisible = false
                    chat_tab_rl.isVisible = false
                    record_tab_rl.isVisible = false
                    account_tab_rl.isVisible = true
                    suggestion_tab_rl.isVisible = false
                }
                R.id.page_5->{
                    Log.d("mode","Suggestion")
                    home_tab_rl.isVisible = false
                    chat_tab_rl.isVisible = false
                    record_tab_rl.isVisible = false
                    account_tab_rl.isVisible = false
                    suggestion_tab_rl.isVisible = true
                }
                else->{

                }
            }
            true
        }


        btn_suggestion.setOnClickListener{
            sug_oor_com.sorcom = true
            val intent = Intent(this, Suggestion_activity::class.java)
            startActivity(intent)
        }

        btn_complaint.setOnClickListener{
            sug_oor_com.sorcom = false
            val intent = Intent(this, Suggestion_activity::class.java)
            startActivity(intent)
        }

        btn_student_account.setOnClickListener{
            val intent = Intent(this, Student_Account::class.java)
            startActivity(intent)
        }

        btn_teacher_account.setOnClickListener{
            val intent = Intent(this, TeacherAccount_Activity::class.java)
            startActivity(intent)
        }


        val institude_code_tv_string = "Institute Code: ${institute_loggedin.institute_codes}"
        val institute_email_add_tv_string= "Institute Email: ${institute_loggedin.institute_email}\nInstitute Address: ${institute_loggedin.institute_address}, ${institute_loggedin.institute_city}, ${institute_loggedin.institute_state}"

        tv_Institute_name.text = institute_loggedin.institute_name
        tv_Institute_code.text = institude_code_tv_string
        tv_Institute_email_add.text = institute_loggedin.institute_email

        replaceFragment(Principal_fragment(), R.id.principal_fragment)

        replaceFragment(NoticeFragment(), R.id.m_notice_fragment)

        btn_student_list.setOnClickListener{
            CommonThing.goFrom = "Student"
            val intent = Intent(this, Select_Standard::class.java)
            startActivity(intent)
        }

        btn_parent_list.setOnClickListener{
            CommonThing.goFrom = "Parent"
            val intent = Intent(this, Parent_List::class.java)
            startActivity(intent)
        }

        btn_teacher_list.setOnClickListener{
            CommonThing.goFrom = "Teacher"
            val intent = Intent(this, Teacher_List::class.java)
            startActivity(intent)
        }

        btn_teacher_chat.setOnClickListener{
            val intent = Intent(this, TeacherChat::class.java)
            startActivity(intent)
        }

        btn_teacher_student_chat.setOnClickListener{
            val intent = Intent(this, Teacher_Student_Chat::class.java)
            startActivity(intent)
        }

        btn_parent_institute_chat.setOnClickListener{
            val intent = Intent(this, Parent_Institute_Chat::class.java)
            startActivity(intent)
        }

        btn_edit_Institute.setOnClickListener{
            etInstituteDialog()
        }
    }

    override fun onPause() {
        super.onPause()
        institute_loggedin.login_state = false
    }

    override fun onResume() {
        super.onResume()
        institute_loggedin.login_state = true
    }

//    Function to replace fragment
    private fun replaceFragment(fragment: Fragment, i:Int){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(i, fragment)
        fragmentTransaction.commit()
    }

    private fun etInstituteDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.edit_institute_dialog)
        val et_i_name = dialog.findViewById<EditText>(R.id.et_edit_institute_name)
        val et_i_email = dialog.findViewById<EditText>(R.id.et_edit_institute_email)
        val et_i_p_name = dialog.findViewById<EditText>(R.id.et_edit_institute_pName)
        val et_i_p_con = dialog.findViewById<EditText>(R.id.et_edit_institute_pContact)
        val et_i_p_mail = dialog.findViewById<EditText>(R.id.et_edit_institute_pEmail)
        val et_i_add = dialog.findViewById<EditText>(R.id.et_edit_institute_address)
        val et_i_city = dialog.findViewById<EditText>(R.id.et_edit_institute_city)
        val et_i_state = dialog.findViewById<EditText>(R.id.et_edit_institute_state)
        val et_i_oldpass = dialog.findViewById<EditText>(R.id.et_edit_institute_oldpass)
        val et_i_newpass = dialog.findViewById<EditText>(R.id.et_edit_institute_newpass)
        val btn_edit_done = dialog.findViewById<MaterialButton>(R.id.btn_edit_institute)


        et_i_name.setText(institute_loggedin.institute_name)
        et_i_email.setText(institute_loggedin.institute_email)
        et_i_p_name.setText(institute_loggedin.institute_pName)
        et_i_p_con.setText(institute_loggedin.institute_pContact)
        et_i_p_mail.setText(institute_loggedin.institute_pEmail)
        et_i_add.setText(institute_loggedin.institute_address)
        et_i_city.setText(institute_loggedin.institute_city)
        et_i_state.setText(institute_loggedin.institute_state)

        btn_edit_done.setOnClickListener{
            if(et_i_oldpass.text.toString() == institute_loggedin.institute_pass){
//                If Old Password Matches
                val sno = 7
                val client = OkHttpClient()
                val url:String = "${Constants.BASE_URL}/updateinstituteprofile/${institute_loggedin.institute_codes}/${et_i_name.text.toString()}/${et_i_add.text.toString()}/${et_i_email.text.toString()}/${et_i_p_name.text.toString()}/${et_i_p_con.text.toString()}/${et_i_p_mail.text.toString()}/${et_i_city.text.toString()}/${et_i_state.text.toString()}"
                val request = Request.Builder()
                    .url(url)
                    .build();

                val url2 = "${Constants.BASE_URL}/updateinstitutepassword/${institute_loggedin.institute_codes}/${et_i_newpass.text.toString()}"
                val request2 = Request.Builder()
                    .url(url2)
                    .build();
//              Update Password
                client.newCall(request2).enqueue(object :Callback{
                    override fun onFailure(call: Call, e: IOException) {
                        e.printStackTrace()
                        Toast.makeText(applicationContext, "Failed to Update Password!", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call, response: Response) {
                        response.use {
                            if(response.code.toString() == "429"){
                                Handler(Looper.getMainLooper()).post {
                                    Toast.makeText(
                                        applicationContext,
                                        "Failed to Update2!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                            if(response.isSuccessful){
                                Handler(Looper.getMainLooper()).post {
                                    Toast.makeText(
                                        applicationContext,
                                        "Updated Successfully!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }else{
                                Handler(Looper.getMainLooper()).post {
                                    Toast.makeText(
                                        applicationContext,
                                        "Failed to Update3!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
                    }

                })

//                Update Profile
                client.newCall(request).enqueue(object :Callback{
                    override fun onFailure(call: Call, e: IOException) {
//                        if Fails
                        e.printStackTrace()
                        Toast.makeText(applicationContext, "Failed to Update1!", Toast.LENGTH_SHORT).show()
                    }
                    override fun onResponse(call: Call, response: Response) {
                        response.use {
                            if(response.code.toString() == "429"){
                                Handler(Looper.getMainLooper()).post {
                                    Toast.makeText(
                                        applicationContext,
                                        "Failed to Update2!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                            if(response.isSuccessful){
                                Handler(Looper.getMainLooper()).post {
                                    Toast.makeText(
                                        applicationContext,
                                        "Updated Successfully!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }else{
                                Handler(Looper.getMainLooper()).post {
                                    Toast.makeText(
                                        applicationContext,
                                        "Failed to Update3!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
                    }
                });
            }else{
                Toast.makeText(applicationContext, "Old Password is not matching!", Toast.LENGTH_SHORT).show()
            }
        }

        dialog.show()
    }
}