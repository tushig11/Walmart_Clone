package com.example.walmart_clone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryAdapter: BaseAdapter{
    var categoryList = ArrayList<Category>()
    var context: Context? = null
    constructor(context: Context, list: ArrayList<Category>):super(){
        this.context = context
        this.categoryList = list
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val category = this.categoryList[p0]
        var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var categoryView = inflater.inflate(R.layout.category_item, null)
        categoryView.categoryImage.setImageResource(category.image!!)
        categoryView.categoryImage.setOnClickListener{
            Toast.makeText(context,"“You have chosen the ${category.name} category of shopping”.", Toast.LENGTH_LONG).show()
        }
        categoryView.categoryName.text = category.name!!
        return categoryView
    }
    override fun getItem(p0: Int): Any = categoryList[p0]
    override fun getItemId(p0: Int): Long = p0.toLong()
    override fun getCount(): Int = categoryList.size
}