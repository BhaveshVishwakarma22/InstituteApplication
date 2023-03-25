package com.lenovo.instituteapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.lenovo.instituteapplication.repository.Repository

class MainActivity : AppCompatActivity() {


//    private lateinit var viewModel: MainViewModel

    lateinit var logintabbtn:MaterialButton
    lateinit var registertabbtn:MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        --------------
/*
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getAllInstitute()
        viewModel.myResponse.observe(this, Observer {response ->
            if(response.isSuccessful){
                for(res in response.body()!!) {
                    Log.d("Response", res.state.toString())
                }
            }

        })

*/
//        --------------

        logintabbtn = findViewById(R.id.lg_tab)
        registertabbtn = findViewById(R.id.reg_tab)

        replaceFragment(LoginFragment())

        logintabbtn.setOnClickListener(){
            replaceFragment(LoginFragment())
        }

        registertabbtn.setOnClickListener(){
            replaceFragment(RegisterFragment())
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentLogin_Signup, fragment)
        fragmentTransaction.commit()
    }
}