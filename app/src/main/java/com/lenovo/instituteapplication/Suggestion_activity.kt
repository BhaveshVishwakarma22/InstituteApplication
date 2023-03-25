package com.lenovo.instituteapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lenovo.instituteapplication.MyAdapterss.SuggestionAdapter
import com.lenovo.instituteapplication.model.ParentModelItem
import com.lenovo.instituteapplication.model.SuggestionModelItem
import com.lenovo.instituteapplication.repository.Repository
import com.lenovo.instituteapplication.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL

class Suggestion_activity : AppCompatActivity() {

    lateinit var suggestion_rv:RecyclerView
    private lateinit var viewModel: MainViewModel
    lateinit var addSuggestion:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggestion)

        val songObjects:MutableList<SuggestionModelItem> = mutableListOf()

        suggestion_rv = findViewById(R.id.rv_suggestion)
        addSuggestion = findViewById(R.id.btn_add_sugg)


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        if(sug_oor_com.sorcom){
            viewModel.getAllSuggestion(institute_loggedin.institute_codes)
        }else{
            viewModel.getAllComplaint(institute_loggedin.institute_codes)
        }

        viewModel.SuggestionResponse.observe(this, Observer {response ->
            if(response.isSuccessful){
                for(res in response.body()!!) {
                    Log.d("Response", res.message)
                    songObjects.add(
                        SuggestionModelItem(
                            college_code = institute_loggedin.institute_codes,
                            message = res.message,
                            sender = res.sender,
                            sno = res.sno
                        )
                    )
                    suggestion_rv.adapter = SuggestionAdapter(songObjects)
                    suggestion_rv.layoutManager = LinearLayoutManager(applicationContext)
                }
            }else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        })

        suggestion_rv.adapter = SuggestionAdapter(songObjects)
        suggestion_rv.layoutManager = LinearLayoutManager(this)
    }
}