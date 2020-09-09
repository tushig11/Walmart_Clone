package com.example.walmart_clone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    private lateinit var user: User
    var categoryList = ArrayList<Category>()

    private fun createStaticCategories(){
        val electronic = Category("Electronic", "Electronic devices", R.drawable.electronic)
        val clothing = Category("Clothing", "Clothes", R.drawable.clothes)
        val food = Category("Food", "Foods", R.drawable.food)
        val beauty = Category("Beauty", "Beauty tools", R.drawable.beauty)
        categoryList = arrayListOf(electronic, clothing, food, beauty)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        user = intent.getSerializableExtra("currentUser") as User
        displayUserEmail.text = "Hello ${user.email}"
        createStaticCategories()
        categoryGrid.adapter = CategoryAdapter(this, categoryList, user)
    }
}