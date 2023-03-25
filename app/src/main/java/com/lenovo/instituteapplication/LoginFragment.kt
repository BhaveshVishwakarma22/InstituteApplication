package com.lenovo.instituteapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.lenovo.instituteapplication.institute_loggedin.institute_address
import com.lenovo.instituteapplication.institute_loggedin.institute_city
import com.lenovo.instituteapplication.institute_loggedin.institute_codes
import com.lenovo.instituteapplication.institute_loggedin.institute_email
import com.lenovo.instituteapplication.institute_loggedin.institute_name
import com.lenovo.instituteapplication.institute_loggedin.institute_pContact
import com.lenovo.instituteapplication.institute_loggedin.institute_pEmail
import com.lenovo.instituteapplication.institute_loggedin.institute_pName
import com.lenovo.instituteapplication.institute_loggedin.institute_pass
import com.lenovo.instituteapplication.institute_loggedin.institute_sno
import com.lenovo.instituteapplication.institute_loggedin.institute_state
import com.lenovo.instituteapplication.institute_loggedin.login_state
import com.lenovo.instituteapplication.repository.Repository

object institute_loggedin{
    var institute_codes:String = "c-123"
    var institute_name:String= "default"
    var institute_email:String= "default"
    var institute_address:String= "default"
    var institute_pName:String= "default"
    var institute_pEmail:String= "default"
    var institute_pContact:String= "default"
    var institute_city:String= "default"
    var institute_state:String= "default"
    var institute_sno:String= "default"
    var institute_pass:String= "default"

    var login_state:Boolean = false
}

class LoginFragment: Fragment() {

    private lateinit var viewModel: MainViewModel

    lateinit var etInstitutecode:EditText
    lateinit var etInstitutename:EditText
    lateinit var etInstituteemail:EditText
    lateinit var etInstitutepass:EditText

    lateinit var loginButton:MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView:View = inflater.inflate(R.layout.institute_login_fragment, container, false)

        etInstitutecode = rootView.findViewById(R.id.et_login_institute_code)
        etInstitutename = rootView.findViewById(R.id.et_login_institute_name)
        etInstituteemail = rootView.findViewById(R.id.et_login_institute_email)
        etInstitutepass = rootView.findViewById(R.id.et_login_institute_pass)
        loginButton = rootView.findViewById(R.id.btn_login_institute)

        loginButton.setOnClickListener{

            institute_codes = "123"
            institute_name = "123"
            institute_email = "123"
            institute_address = "123"
            institute_pName = "123"
            institute_pEmail = "123"
            institute_pContact = "123"
            institute_city = "123"
            institute_state = "123"
            institute_sno = "123"
            institute_pass = "123"

            var errReson:String = ""
            val repository = Repository()
            val viewModelFactory = MainViewModelFactory(repository)
            viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
            viewModel.getAllInstitute()
            viewModel.myResponse.observe(viewLifecycleOwner, Observer {response ->
                if(response.isSuccessful){
                    for(res in response.body()!!) {
                        if(res.collegeCode.toString() == etInstitutecode.text.toString()){
                            if(res.name.toString() == etInstitutename.text.toString()){
                                if(res.password.toString()== etInstitutepass.text.toString() && res.collegeEmail.toString() == etInstituteemail.text.toString()){
                                    login_state = true
//                                Storing Data in object
                                    institute_codes = res.collegeCode.toString()
                                    institute_name = res.name.toString()
                                    institute_email = res.collegeEmail.toString()
                                    institute_address = res.address.toString()
                                    institute_pName = res.principalName.toString()
                                    institute_pEmail = res.principalEmail.toString()
                                    institute_pContact = res.principalContact.toString()
                                    institute_city = res.city.toString()
                                    institute_state = res.state.toString()
                                    institute_sno = res.sno.toString()
                                    institute_pass = res.password.toString()
                                    Toast.makeText(activity, "Successfully Logged In", Toast.LENGTH_SHORT).show()
                                    break

                                }else{
                                    errReson = "Incorrect Password or Email!"
                                }
                            }else if(errReson!="Incorrect Password or Email!"){
                                errReson = "Incorrect Institute Name!"
                            }
                        }else if(errReson!="Incorrect Password or Email!" && errReson!="Incorrect Institute Name!"){
                            errReson = "Invalid Institute Code!"
                        }
                    }
                    if(!login_state){
                        Toast.makeText(activity, errReson, Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(activity, "Connection Error", Toast.LENGTH_SHORT).show()
                }
            })
            if(login_state){
                val intent = Intent(activity, Institute_home::class.java)
                startActivity(intent)
            }
        }
        return rootView
    }
}