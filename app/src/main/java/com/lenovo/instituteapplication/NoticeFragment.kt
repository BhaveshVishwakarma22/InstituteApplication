package com.lenovo.instituteapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lenovo.instituteapplication.model.NoticeItem
import com.lenovo.instituteapplication.model.NoticeItemItem
import com.lenovo.instituteapplication.repository.Repository

class NoticeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_notice, container, false)
        val songList = rootView.findViewById<RecyclerView>(R.id.notice_rv)
        val songObjects:MutableList<NoticeItemItem> = mutableListOf()
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getAllNotice(institute_loggedin.institute_codes)
        viewModel.NoticeResponse.observe(viewLifecycleOwner, Observer { response->
            if(response.isSuccessful){
                Log.d("Response", response.toString())
                for(res in response.body()!!){
                    Log.d("Response", res.notice)
                    Log.d("Response", res.notice_publisher)
                    songObjects.add(NoticeItemItem(institute_loggedin.institute_codes, res.notice, res.notice_date, res.notice_publisher, res.sno))

                    songList.adapter = MyAdapter(songObjects)
                    songList.layoutManager = LinearLayoutManager(parentFragment?.context)
                }
            }else{
                Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
            }
        })
        return rootView
    }
}