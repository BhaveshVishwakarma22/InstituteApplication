package com.lenovo.instituteapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
object sug_oor_com{
    var sorcom:Boolean = false
}
class Student_Mode_Main : AppCompatActivity() {

    lateinit var stu_home_tab:LinearLayout
    lateinit var stu_performance_tab:LinearLayout
    lateinit var stu_notes_tab:LinearLayout
    lateinit var stu_fees_tab:LinearLayout
    lateinit var stu_suggestion_tab:LinearLayout

    lateinit var notesWebView: WebView

    lateinit var bottom_nav: BottomNavigationView
    lateinit var suggestionButton :MaterialButton
    lateinit var complaintButton :MaterialButton
    lateinit var studentChatButton:MaterialButton

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_mode_main)

        stu_home_tab = findViewById(R.id.stu_home_tab)
        stu_performance_tab = findViewById(R.id.stu_perfomance_tab)
        stu_notes_tab = findViewById(R.id.stu_notes_tab)
        stu_fees_tab = findViewById(R.id.stu_fees_tab)
        stu_suggestion_tab = findViewById(R.id.stu_suggestion_tab_ll)
        suggestionButton = findViewById(R.id.stu_btn_suggestion)
        complaintButton = findViewById(R.id.stu_btn_complaint)
        bottom_nav = findViewById<BottomNavigationView>(R.id.stu2_bottom_navigation_home)
        studentChatButton = findViewById(R.id.stu_main_chat_btn)

        notesWebView = findViewById(R.id.notes_webView)

        notesWebView.webViewClient = WebViewClient()
        notesWebView.settings.javaScriptEnabled = true
        notesWebView.settings.setSupportZoom(true)

        replaceFragment(NoticeFragment(), R.id.stu_notice_fragment)


        suggestionButton.setOnClickListener{
            sug_oor_com.sorcom = true
            val intent = Intent(this, Suggestion_activity::class.java)
            startActivity(intent)
        }

        complaintButton.setOnClickListener{
            sug_oor_com.sorcom = false
            val intent = Intent(this, Suggestion_activity::class.java)
            startActivity(intent)
        }

        studentChatButton.setOnClickListener{
            val intent = Intent(this, Teacher_Student_Chat::class.java)
            startActivity(intent)
        }

        stu_suggestion_tab.isVisible = false
        stu_home_tab.isVisible = true
        stu_performance_tab.isVisible = false
        stu_notes_tab.isVisible = false
        stu_fees_tab.isVisible = false

        bottom_nav.setOnNavigationItemSelectedListener { item->
            when(item.itemId){
                R.id.stu_home->{
                    Log.d("Mode","Student Home")
                    stu_suggestion_tab.isVisible = false
                    stu_home_tab.isVisible = true
                    stu_performance_tab.isVisible = false
                    stu_notes_tab.isVisible = false
                    stu_fees_tab.isVisible = false
                }
                R.id.stu_performance->{
                    Log.d("Mode","Student Performance")
                    stu_suggestion_tab.isVisible = false
                    stu_home_tab.isVisible = false
                    stu_performance_tab.isVisible = true
                    stu_notes_tab.isVisible = false
                    stu_fees_tab.isVisible = false
                }
                R.id.stu_notes->{
                    Log.d("Mode","Student Notes")
                    stu_suggestion_tab.isVisible = false
                    stu_home_tab.isVisible = false
                    stu_performance_tab.isVisible = false
                    stu_notes_tab.isVisible = true
                    stu_fees_tab.isVisible = false

                    notesWebView.webViewClient = WebViewClient()
                    notesWebView.settings.javaScriptEnabled = true
                    notesWebView.settings.setSupportZoom(true)
                    val n_url = "https://drive.google.com/drive/folders/1yz88RHe2ENDprHaVi1j2IjvBs17_ZOmA"
                    notesWebView.loadUrl(n_url)
                }
                R.id.stu_sugg->{
                    Log.d("Mode","Student Suggestion")
                    stu_suggestion_tab.isVisible = true
                    stu_home_tab.isVisible = false
                    stu_performance_tab.isVisible = false
                    stu_notes_tab.isVisible = false
                    stu_fees_tab.isVisible = false
                }
                R.id.stu_fees->{
                    Log.d("Mode","Student Fees")
                    stu_suggestion_tab.isVisible = false
                    stu_home_tab.isVisible = false
                    stu_performance_tab.isVisible = false
                    stu_notes_tab.isVisible = false
                    stu_fees_tab.isVisible = true
                }
                else->{

                }
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment, i:Int){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(i, fragment)
        fragmentTransaction.commit()
    }
}