package com.example.walmart_clone

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        createBtn.setOnClickListener() { createAccount() }

        logInBtn.setOnClickListener(){
            val mainIntent = Intent(this,MainActivity::class.java)
            startActivity(mainIntent)
        }
    }

    private fun createAccount(){
        val email = register_emailInput.text.toString()
        val firstName = register_firstNameInput.text.toString()
        val lastName = register_lastNameInput.text.toString()
        val password = register_passwordInput.text.toString()

        if(email.isNotEmpty() && firstName.isNotEmpty() && lastName.isNotEmpty() && password.isNotEmpty()){
            val data = Intent()
            data.putExtra("newUser", User(firstName,lastName,email,password))
            setResult(Activity.RESULT_OK, data)
            finish()
        }else{
            Toast.makeText(this, "Fill the required fields before create an account", Toast.LENGTH_LONG).show()
        }

    }
}