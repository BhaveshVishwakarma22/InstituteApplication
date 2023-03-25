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
import kotlin.properties.Delegates

object BossObj{
    var dataBoss = true
}

class Teacher_Mode_Main : AppCompatActivity() {


    lateinit var tea_home_tab:LinearLayout
    lateinit var tea_tt_tab:LinearLayout
    lateinit var tea_chat_tab:LinearLayout
    lateinit var tea_money_tab:LinearLayout
    lateinit var tea_notes_tab:LinearLayout

    lateinit var btn_ts_chat:MaterialButton
    lateinit var btn_t_chat:MaterialButton

    lateinit var tea_nav_bar:BottomNavigationView
    lateinit var tea_note_webview:WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_mode_main)

        tea_home_tab = findViewById(R.id.tea_home_tab)
        tea_tt_tab = findViewById(R.id.tea_tt_tab)
        tea_nav_bar = findViewById(R.id.tea_bottom_navigation_home)
        tea_chat_tab = findViewById(R.id.t_mode_chat_tab)
        tea_money_tab = findViewById(R.id.t_mode_money_tab)
        tea_notes_tab = findViewById(R.id.t_mode_notes_tab)
        tea_note_webview = findViewById(R.id.notes_webView2)
        btn_ts_chat = findViewById(R.id.btn_student_teacher_chat7)
        btn_t_chat = findViewById(R.id.btn_teacher_chat7)

        tea_home_tab.isVisible = true
        tea_tt_tab.isVisible = false
        tea_chat_tab.isVisible = false
        tea_notes_tab.isVisible = false
        tea_money_tab.isVisible = false

        btn_ts_chat.setOnClickListener{
            BossObj.dataBoss = true
            val intent = Intent(applicationContext, Teacher_Student_Chat::class.java)
            startActivity(intent)
        }

        btn_t_chat.setOnClickListener{
            BossObj.dataBoss = false
            val intent = Intent(applicationContext, Teacher_Student_Chat::class.java)
            startActivity(intent)
        }

        tea_nav_bar.setOnNavigationItemSelectedListener { item->
            when(item.itemId){
                R.id.tea_home->{
                    Log.d("Mode", "Home")
                    tea_home_tab.isVisible = true
                    tea_tt_tab.isVisible = false
                    tea_chat_tab.isVisible = false
                    tea_notes_tab.isVisible = false
                    tea_money_tab.isVisible = false
                }
                R.id.tea_tt->{
                    Log.d("Mode", "Time Table")
                    tea_home_tab.isVisible = false
                    tea_tt_tab.isVisible = true
                    tea_chat_tab.isVisible = false
                    tea_notes_tab.isVisible = false
                    tea_money_tab.isVisible = false
                }
                R.id.tea_chat->{
                    Log.d("Mode", "Chat")
                    tea_home_tab.isVisible = false
                    tea_tt_tab.isVisible = false
                    tea_chat_tab.isVisible = true
                    tea_notes_tab.isVisible = false
                    tea_money_tab.isVisible = false
                }
                R.id.tea_notes->{
                    Log.d("Mode", "Notes")
                    tea_home_tab.isVisible = false
                    tea_tt_tab.isVisible = false
                    tea_chat_tab.isVisible = false
                    tea_notes_tab.isVisible = true
                    tea_money_tab.isVisible = false

                    tea_note_webview.webViewClient = WebViewClient()
                    tea_note_webview.settings.javaScriptEnabled = true
                    tea_note_webview.settings.setSupportZoom(true)
                    val n_url = "https://drive.google.com/drive/folders/1RvVrw2o1__aYPJbnZ55HpQEyzxhhrQAF?usp=sharing"
                    tea_note_webview.loadUrl(n_url)
                }
                R.id.tea_money->{
                    Log.d("Mode", "Money")
                    tea_home_tab.isVisible = false
                    tea_tt_tab.isVisible = false
                    tea_chat_tab.isVisible = false
                    tea_notes_tab.isVisible = false
                    tea_money_tab.isVisible = true
                }
            }
            true
        }

    }

}