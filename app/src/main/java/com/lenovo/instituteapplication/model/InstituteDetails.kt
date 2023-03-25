package com.lenovo.instituteapplication.model

import com.google.gson.annotations.SerializedName

data class InstituteDetails(

	@field:SerializedName("Response")
	val response: List<InstituteDetailsItem?>? = null
)

data class InstituteDetailsItem(

	@field:SerializedName("college_email")
	val collegeEmail: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("sno")
	val sno: Int? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("college_code")
	val collegeCode: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("principal_name")
	val principalName: String? = null,

	@field:SerializedName("state")
	val state: String? = null,

	@field:SerializedName("principal_email")
	val principalEmail: String? = null,

	@field:SerializedName("principal_contact")
	val principalContact: Int? = null
)


class NoticeItem : ArrayList<NoticeItemItem>()

data class NoticeItemItem(
    var college_code: String,
    var notice: String,
    var notice_date: String,
    var notice_publisher: String,
    var sno: Int
)

class TeacherChat : ArrayList<TeacherChatItem>()

data class TeacherChatItem(
	val college_code: String,
	val message: String,
	val sender: String,
	val sno: Int
)


class StudentModel : ArrayList<StudentModelItem>()

data class StudentModelItem(
    var address: String,
    var attendence: String,
    var bus_fee: Int,
    var canteen_due: Int,
    var college_code: String,
    var contact_number: Int,
    var fee_due: Int,
    var gender: String,
    var hostel_fee: Int,
    var name: String,
    var parents_contact: Int,
    var parents_name: String,
    var password: String,
    var performance: String,
    var roll_number: Int,
    var sno: Int,
    var standard: String,
    var total_fee: Int,
    var tution_fee: Int
)

class ParentModel : ArrayList<ParentModelItem>()

data class ParentModelItem(
    var bus_fee: Int,
    var canteen_due: Int,
    var child_name: String,
    var college_code: String,
    var contact: Int,
    var email: String,
    var fee_due: Int,
    var hostel_fee: Int,
    var name: String,
    var password: String,
    var roll_no: Int,
    var sno: Int,
    var total_fee: Int,
    var tution_fee: Int
)

class TeacherModel : ArrayList<TeacherModelItem>()

data class TeacherModelItem(
    var address: String,
    var attendence: String,
    var branch: String,
    var canteen_due: Int,
    var college_code: String,
    var contact: Int,
    var email: String,
    var faculty_id: String,
    var mess_fee: Int,
    var name: String,
    var password: String,
    var performance: String,
    var salary: Int,
    var sno: Int
)

class StudentAccount : ArrayList<StudentAccountItem>()

data class StudentAccountItem(
    var bus_fee: Int,
    var canteen_due: Int,
    var college_code: String,
    var fee_due: Int,
    var hostel_fee: Int,
    var roll_no: Int,
    var sno: Int,
    var totall_fee: Int,
    var tution_fee: Int
)

class TeacherAccountMModel : ArrayList<TeacherAccountMModelItem>()

data class TeacherAccountMModelItem(
    var canteen_due: Int,
    var college_code: String,
    var faculty_id: String,
    var mess_fee: Int,
    var payment: Int,
    var payment_due: Int,
    var sno: Int
)

class SuggestionModel : ArrayList<SuggestionModelItem>()

data class SuggestionModelItem(
    var college_code: String,
    var message: String,
    var sender: String,
    var sno: Int
)