package com.example.walmart_clone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_category_list.*
import kotlinx.android.synthetic.main.activity_shopping.*
import kotlinx.android.synthetic.main.activity_shopping.categoryText
import kotlinx.android.synthetic.main.activity_shopping.displayUserEmail

class CategoryList : AppCompatActivity() {
    private lateinit var user: User
    var productList = ArrayList<Product>()

    private fun createStaticProducts(){
        //Categories
        val electronic = Category("Electronic", "Electronic devices", R.drawable.electronic)
        val clothing = Category("Clothing", "Clothes", R.drawable.clothes)
//        val food = Category("Food", "Foods", R.drawable.food)
//        val beauty = Category("Beauty", "Beauty tools", R.drawable.beauty)
        //Products
        val jeansBlack = Product("0", "Black Jeans", 100.0, "black", "jeans-black", "Flexible jeans with black color", clothing)
        val jeansBlue = Product("1", "Blue Jeans", 80.0, "blue", "jeans-blue", "Flexible jeans with blue color", clothing)
        val hoodiePink = Product("2", "Pink Hoodie", 20.0, "pink", "hoodie-pink", "Nice hoodie for girls", clothing)
        val hoodieBlue = Product("3", "Blue Hoodie", 25.0, "blue", "hoodie-blue", "Nice hoodie for boys", clothing)
        val tShirt = Product("4", "Red T-shirt", 15.0, "red", "t-shirt-red", "Simple T-Shirt for everyone", clothing)
        val headset = Product("5", "Headset", 60.0, "pink", "headset", "Headset with inline microphone", electronic)

        productList = arrayListOf(jeansBlack, jeansBlue, hoodiePink, hoodieBlue, tShirt, headset)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)
        createStaticProducts()
        user = intent.getSerializableExtra("currentUser") as User
        displayUserEmail.text = "Hello ${user.email}"
        val category = intent.getSerializableExtra("currentCategory") as Category
        categoryText.text = "Products of ${category.name}"

        var filteredProducts = productList.filter { product -> product.category == category }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, filteredProducts)
        productListView.adapter = adapter

        productListView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "${filteredProducts[position].desc}", Toast.LENGTH_SHORT).show()
        }
    }



}