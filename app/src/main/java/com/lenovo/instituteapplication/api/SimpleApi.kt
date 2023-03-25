package com.lenovo.instituteapplication.api


import com.lenovo.instituteapplication.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {

    @GET("read_institute")
    suspend fun getAllInstitute(): Response<List<InstituteDetailsItem>>


    @GET("/read_notice_ccode/{c_code}")
    suspend fun getAllNotice(@Path("c_code") c_code: String): Response<List<NoticeItemItem>>

    @GET("/read_tchat_table_by_ccode/{c_code}")
    suspend fun getAllTChatMsg(@Path("c_code") c_code: String): Response<List<TeacherChatItem>>

    @GET("/read_pichat_table_by_ccode/{c_code}")
    suspend fun getAllPIChatMsg(@Path("c_code") c_code: String): Response<List<TeacherChatItem>>

    @GET("/read_tschat_table_by_ccode/{c_code}")
    suspend fun getAllTSChatMsg(@Path("c_code") c_code: String): Response<List<TeacherChatItem>>

    @GET("/read_row_students_table_by_ccode/{c_code}")
    suspend fun getAllStudents(@Path("c_code") c_code: String): Response<List<StudentModelItem>>

    @GET("/read_row_pass_parents_table_by_ccode/{c_code}")
    suspend fun getAllParents(@Path("c_code") c_code: String): Response<List<ParentModelItem>>

    @GET("/read_row_teachers_table_by_ccode/{c_code}")
    suspend fun getAllTeachers(@Path("c_code") c_code: String): Response<List<TeacherModelItem>>

    @GET("/read_student_account_by_ccode/{c_code}")
    suspend fun getAllAccountStudent(@Path("c_code") c_code: String): Response<List<StudentAccountItem>>

    @GET("/read_suggestion_table_by_ccode/{c_code}")
    suspend fun getAllSuggestion(@Path("c_code") c_code: String): Response<List<SuggestionModelItem>>

    @GET("/read_complaint_table_by_ccode/{c_code}")
    suspend fun getAllComplaint(@Path("c_code") c_code: String): Response<List<SuggestionModelItem>>

    @GET("/select_account_teachers_using_clgcode/{c_code}")
    suspend fun getAllAccountTeacher(@Path("c_code") c_code: String): Response<List<TeacherAccountMModelItem>>

    @GET("add_institute/{c_code}/{name}/{address}/{c_email}/{p_name}/{p_contact}/{p_email}/{city}/{state}/{pass}")
    suspend fun addInstitute(@Path("c_code") c_code:String, @Path("name") name:String, @Path("address") address:String, @Path("c_email") c_email:String, @Path("p_name") p_name:String, @Path("p_contact") p_contact:String, @Path("p_email") p_email:String, @Path("city") city:String, @Path("state") state:String, @Path("pass") pass:String)
}