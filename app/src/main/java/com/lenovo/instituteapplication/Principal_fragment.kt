package com.lenovo.instituteapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/* Use the [Principal_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class Principal_fragment : Fragment() {

    lateinit var princi_info: TextView
    lateinit var princi_name: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val rootView:View = inflater.inflate((R.layout.fragment_principal_fragment), container, false)
        princi_info = rootView.findViewById(R.id.principal_info)
        princi_name = rootView.findViewById(R.id.principal_name)

        princi_name.text ="Principal : ${institute_loggedin.institute_pName}"
        princi_info.text = "Contact: ${institute_loggedin.institute_pContact}\nEmail Address: ${institute_loggedin.institute_pEmail}"

        return rootView
    }
}