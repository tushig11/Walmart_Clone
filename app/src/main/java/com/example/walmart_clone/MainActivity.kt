package com.example.walmart_clone

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var userList: ArrayList<User>

    private fun createStaticUsers(){
        val john = User("John", "Lawal","john@gmail.com", "john")
        val karl = User("Karl", "Hudson","karl@gmail.com", "karl")
        val marcus = User("Marcus", "Smart","marcus@gmail.com", "marcus")
        val smart = User("Smart", "Johnson","smart@gmail.com", "smart")
        val kane = User("Kane","Williams","kane@gmail.com", "kane")
        userList = arrayListOf(john,karl,marcus,smart,kane)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createStaticUsers()
    }

    fun forgetPassword(view: View){
        val userEmail = emailInput.text.toString()
        val currentUser = userList.filter{ user -> user.email == userEmail }
        if(currentUser.isNotEmpty()) sendEmail(currentUser[0])
        else Toast.makeText(this, "User not found", Toast.LENGTH_LONG).show()
    }

    fun signIn(view: View){
        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()
        if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) Toast.makeText(this, "Enter your email and password ", Toast.LENGTH_LONG).show()
        else{
            val currentUser = User(email,password)
            if(userList.contains(currentUser)){
                val shoppingIntent = Intent(this, ShoppingActivity::class.java)
                shoppingIntent.putExtra("currentUser", currentUser)
                startActivity(shoppingIntent)
            } else Toast.makeText(this, "Check your credential", Toast.LENGTH_LONG).show()
        }
    }

    fun signUp(view: View){
        val registerIntent = Intent(this, RegisterActivity::class.java)
        startActivityForResult(registerIntent, 200)
    }

    fun checkUser(user:User): List<User>{
        return userList.filter { value -> value == user}
    }

    private fun sendEmail(user:User){
        val mailIntent = Intent(Intent.ACTION_SEND)
        mailIntent.data = Uri.parse("mailto:")
        mailIntent.type = "text/plain"
        mailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(user.email))
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Password Recovery")
        mailIntent.putExtra(Intent.EXTRA_TEXT, "Your password is ${user.password}")
        try{
            startActivity(Intent.createChooser(mailIntent, "Choose email client ..."))
        }catch(e:Exception){
            Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 200){
            if(resultCode == Activity.RESULT_OK){
                val newUser = data?.getSerializableExtra("newUser") as User
                userList.add(newUser)
                Toast.makeText(this,"Account created successfully", Toast.LENGTH_LONG).show()
            }
        }
    }
}