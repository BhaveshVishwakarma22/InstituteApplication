package com.lenovo.instituteapplication.repository

import com.lenovo.instituteapplication.api.RetrofitInstance
import com.lenovo.instituteapplication.model.*
import retrofit2.Response
import retrofit2.http.Path


class Repository {

    suspend fun getAllInstitute(): Response<List<InstituteDetailsItem>>{
        return RetrofitInstance.api.getAllInstitute()
    }

    suspend fun getAllNotice(c_code:String): Response<List<NoticeItemItem>> {
        return RetrofitInstance.api.getAllNotice(c_code)
    }

    suspend fun getAllTChatMsg(c_code:String): Response<List<TeacherChatItem>> {
        return RetrofitInstance.api.getAllTChatMsg(c_code)
    }

    suspend fun getAllPIChatMsg(c_code:String): Response<List<TeacherChatItem>> {
        return RetrofitInstance.api.getAllPIChatMsg(c_code)
    }

    suspend fun getAllTSChatMsg(c_code:String): Response<List<TeacherChatItem>> {
        return RetrofitInstance.api.getAllTSChatMsg(c_code)
    }

    suspend fun getAllStudents(c_code:String): Response<List<StudentModelItem>> {
        return RetrofitInstance.api.getAllStudents(c_code)
    }

    suspend fun getAllParents(c_code:String): Response<List<ParentModelItem>> {
        return RetrofitInstance.api.getAllParents(c_code)
    }

    suspend fun getAllTeachers(c_code:String): Response<List<TeacherModelItem>> {
        return RetrofitInstance.api.getAllTeachers(c_code)
    }

    suspend fun getAllAccountStudent(c_code:String): Response<List<StudentAccountItem>> {
        return RetrofitInstance.api.getAllAccountStudent(c_code)
    }

    suspend fun getAllSuggestion(c_code:String): Response<List<SuggestionModelItem>> {
        return RetrofitInstance.api.getAllSuggestion(c_code)
    }

    suspend fun getAllComplaint(c_code:String): Response<List<SuggestionModelItem>> {
        return RetrofitInstance.api.getAllComplaint(c_code)
    }

    suspend fun getAllAccountTeacher(c_code:String): Response<List<TeacherAccountMModelItem>> {
        return RetrofitInstance.api.getAllAccountTeacher(c_code)
    }
}