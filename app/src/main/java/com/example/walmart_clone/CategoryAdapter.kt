package com.example.walmart_clone

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryAdapter: BaseAdapter{
    var categoryList = ArrayList<Category>()
    var context: Context? = null
    var user: User? = null
    constructor(context: Context, list: ArrayList<Category>, user: User):super(){
        this.context = context
        this.categoryList = list
        this.user = user
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val category = this.categoryList[p0]
        var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var categoryView = inflater.inflate(R.layout.category_item, null)
        categoryView.categoryImage.setImageResource(category.image!!)
        categoryView.categoryImage.setOnClickListener{
            Toast.makeText(context,"“You have chosen the ${category.name} category of shopping”.", Toast.LENGTH_LONG).show()
            val shoppingIntent = Intent(context, CategoryList::class.java)
            shoppingIntent.putExtra("currentUser", user)
            shoppingIntent.putExtra("currentCategory", category)
            context!!.startActivity(shoppingIntent)
        }
        categoryView.categoryName.text = category.name!!
        return categoryView
    }
    override fun getItem(p0: Int): Any = categoryList[p0]
    override fun getItemId(p0: Int): Long = p0.toLong()
    override fun getCount(): Int = categoryList.size
}