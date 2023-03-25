package com.lenovo.instituteapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lenovo.instituteapplication.model.*

import com.lenovo.instituteapplication.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {

    val myResponse: MutableLiveData<Response<List<InstituteDetailsItem>>> = MutableLiveData()
    val NoticeResponse: MutableLiveData<Response<List<NoticeItemItem>>> = MutableLiveData()
    var Tc_MsgResponse: MutableLiveData<Response<List<TeacherChatItem>>> = MutableLiveData()
    var PIc_MsgResponse: MutableLiveData<Response<List<TeacherChatItem>>> = MutableLiveData()
    var TS_MsgResponse: MutableLiveData<Response<List<TeacherChatItem>>> = MutableLiveData()
    var StdutendtResponse: MutableLiveData<Response<List<StudentModelItem>>> = MutableLiveData()
    var ParentsLResponse: MutableLiveData<Response<List<ParentModelItem>>> = MutableLiveData()
    var TeacherLResponse: MutableLiveData<Response<List<TeacherModelItem>>> = MutableLiveData()
    var StudentAccountResponse: MutableLiveData<Response<List<StudentAccountItem>>> = MutableLiveData()
    var SuggestionResponse: MutableLiveData<Response<List<SuggestionModelItem>>> = MutableLiveData()
    var TeacherAccountResponse: MutableLiveData<Response<List<TeacherAccountMModelItem>>> = MutableLiveData()

    fun getAllInstitute(){
        viewModelScope.launch {
            val response = repository.getAllInstitute()
            myResponse.value= response
        }
    }

    fun getAllNotice(c_code: String){
        viewModelScope.launch {
            val response = repository.getAllNotice(c_code)
            NoticeResponse.value = response
        }
    }

    fun getAllTChatMsg(c_code: String){
        viewModelScope.launch {
            val response = repository.getAllTChatMsg(c_code)
            Tc_MsgResponse.value = response
        }
    }

    fun getAllPIChatMsg(c_code: String){
        viewModelScope.launch {
            val response = repository.getAllPIChatMsg(c_code)
            PIc_MsgResponse.value = response
        }
    }

    fun getAllTSChatMsg(c_code: String){
        viewModelScope.launch {
            val response = repository.getAllTSChatMsg(c_code)
            TS_MsgResponse.value = response
        }
    }

    fun getAllStudents(c_code: String){
        viewModelScope.launch {
            val response = repository.getAllStudents(c_code)
            StdutendtResponse.value = response
        }
    }

    fun getAllParents(c_code: String){
        viewModelScope.launch {
            val response = repository.getAllParents(c_code)
            ParentsLResponse.value = response
        }
    }

    fun getAllTeachers(c_code: String){
        viewModelScope.launch {
            val response = repository.getAllTeachers(c_code)
            TeacherLResponse.value = response
        }
    }

    fun getAllAccountStudent(c_code: String){
        viewModelScope.launch {
            val response = repository.getAllAccountStudent(c_code)
            StudentAccountResponse.value = response
        }
    }

    fun getAllSuggestion(c_code: String){
        viewModelScope.launch {
            val response = repository.getAllSuggestion(c_code)
            SuggestionResponse.value = response
        }
    }


    fun getAllComplaint(c_code: String){
        viewModelScope.launch {
            val response = repository.getAllComplaint(c_code)
            SuggestionResponse.value = response
        }
    }

    fun getAllAccountTeacher(c_code: String){
        viewModelScope.launch {
            val response = repository.getAllAccountTeacher(c_code)
            TeacherAccountResponse.value = response
        }
    }
}