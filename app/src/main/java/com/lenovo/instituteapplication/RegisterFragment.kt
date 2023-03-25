package com.lenovo.instituteapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.lenovo.instituteapplication.util.Constants.Companion.BASE_URL
import okhttp3.*
import java.io.IOException

class RegisterFragment: Fragment() {

    lateinit var reg_institute_code:EditText
    lateinit var reg_institute_name:EditText
    lateinit var reg_institute_email:EditText
    lateinit var reg_institute_address:EditText
    lateinit var reg_institute_pName:EditText
    lateinit var reg_institute_pContact:EditText
    lateinit var reg_institute_pEmail:EditText
    lateinit var reg_institute_city:EditText
    lateinit var reg_institute_state:EditText
    lateinit var reg_institute_pass:EditText
    lateinit var reg_institute_re_pass:EditText
    lateinit var reg_btn:MaterialButton

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rView:View = inflater.inflate(R.layout.institute_register_fragment, container, false)

        reg_institute_code = rView.findViewById(R.id.et_register_institute_code)
        reg_institute_name = rView.findViewById(R.id.et_register_institute_name)
        reg_institute_email = rView.findViewById(R.id.et_register_institute_email)
        reg_institute_address = rView.findViewById(R.id.et_register_institute_address)
        reg_institute_pName = rView.findViewById(R.id.et_register_institute_pName)
        reg_institute_pContact = rView.findViewById(R.id.et_register_institute_pContact)
        reg_institute_pEmail = rView.findViewById(R.id.et_register_institute_pEmail)
        reg_institute_city = rView.findViewById(R.id.et_register_institute_city)
        reg_institute_state = rView.findViewById(R.id.et_register_institute_state)
        reg_institute_pass = rView.findViewById(R.id.et_register_institute_pass)
        reg_institute_re_pass= rView.findViewById(R.id.et_register_institute_re_pass)
        reg_btn = rView.findViewById(R.id.btn_register_institute)


        reg_btn.setOnClickListener{
            val i_code = reg_institute_code.text.toString()
            val i_name = reg_institute_name.text.toString()
            val i_email = reg_institute_email.text.toString()
            val i_add = reg_institute_address.text.toString()
            val p_name = reg_institute_pName.text.toString()
            val p_con = reg_institute_pContact.text.toString()
            val p_mail = reg_institute_pEmail.text.toString()
            val city = reg_institute_city.text.toString()
            val state = reg_institute_state.text.toString()
            val pass = reg_institute_pass.text.toString()
            val re_pas = reg_institute_re_pass.text.toString()


//          Code for registering Institute

            if(!(i_add.isEmpty() || i_code.isEmpty() || i_email.isEmpty() || i_name.isEmpty() || p_name.isEmpty() || p_con.isEmpty() || p_mail.isEmpty() || city.isEmpty() || state.isEmpty() || pass.isEmpty() || re_pas.isEmpty())){
                if(pass == re_pas){
//                    To Do if pass is same
                    val sno = 7
//                    OkHttp setup
                    val client = OkHttpClient()
                    val url:String = "$BASE_URL/add_institute/${sno}/${i_code}/${i_name}/${i_add}/${i_email}/${p_name}/${p_con}/${p_mail}/${city}/${state}/${pass}"
                    val request = Request.Builder()
                        .url(url)
                        .build();

                    client.newCall(request).enqueue(object :Callback{
                        override fun onFailure(call: Call, e: IOException) {
                            e.printStackTrace()
                            Toast.makeText(activity, "Error Registering Institute", Toast.LENGTH_SHORT).show()
                        }

                        override fun onResponse(call: Call, response: Response) {
                            response.use {
                                if(response.code.toString() == "429"){
//                                    Checking status code
                                    Handler(Looper.getMainLooper()).post{
                                        Toast.makeText(activity, "Institute with same code exists!", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                if(response.isSuccessful){
//                                    To Do if Response is successful
                                    Handler(Looper.getMainLooper()).post{
                                        Toast.makeText(activity, "Institute Registered Successfully!", Toast.LENGTH_SHORT).show()
                                    }

                                }else{
//                                    To Do if Response is not successful
                                    Handler(Looper.getMainLooper()).post{
                                        Toast.makeText(activity, "Error Registering Institute!", Toast.LENGTH_SHORT).show()
                                    }

                                }
                            }
                        }
                    })
                }else{
                    Toast.makeText(activity, "Password is not matching!", Toast.LENGTH_SHORT).show()
                }
            }else{
//                To do if any field is empty
                Toast.makeText(activity, "Empty Field!", Toast.LENGTH_SHORT).show()
            }
        }
        return rView
    }
}