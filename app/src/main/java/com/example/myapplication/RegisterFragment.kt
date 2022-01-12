package com.example.myapplication

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class RegisterFragment:Fragment() {

    private lateinit var email : EditText
    private lateinit var password : EditText
    private  lateinit var  cnfpassword : EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.register_page, container )

        email = view.findViewById(R.id.editTextEmail)
        password = view.findViewById(R.id.editTextPassword)
        cnfpassword =view.findViewById(R.id.editTextCNFPassword)

        view.findViewById<Button>(R.id.buttonRegister).setOnClickListener {
            emptyForm()
        }

    }

    private fun emptyForm(){
        when{
            TextUtils.isEmpty(email.text.toString().trim())->{
                email.setError("Please enter your email")
            }
            TextUtils.isEmpty(password.text.toString().trim())->{
                password.setError("Please enter your password")
            }
            TextUtils.isEmpty(cnfpassword.text.toString().trim())->{
                cnfpassword.setError("Please enter your password")
            }
        }

        if(email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty() && cnfpassword.text.toString().isNotEmpty()) {

                    if (email.text.toString().matches(regex =  "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))
                    {
                        if (password.text.toString().length >= 6){
                            if (password.text.toString() == cnfpassword.text.toString()){

                            }else{
                                cnfpassword.setError("passwords doesent match")
                            }

                        }else{
                            password.setError("please set a pasword with 6 or more characters")
                        }
                    }else{
                        email.setError("please enter valid email")
                    }
        }

    }
}

private fun Any.matches(regex: String): Boolean {

}
