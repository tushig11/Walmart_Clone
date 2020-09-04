package com.example.walmart_clone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun forgetPassword(view: View){
        Toast.makeText(this, "Ooh, I don't know your password too", Toast.LENGTH_LONG).show()
    }

    fun signIn(view: View){
        Toast.makeText(this, "Successfully signed in", Toast.LENGTH_LONG).show()
    }

    fun signUp(view: View){
        Toast.makeText(this, "New account created", Toast.LENGTH_LONG).show()
    }
}