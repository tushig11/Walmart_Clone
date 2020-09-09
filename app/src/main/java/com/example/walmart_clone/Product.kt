package com.example.walmart_clone

data class Product(var id:String, var title:String, var price:Double, var color:String, var image:String, var desc:String, var category:Category){
    override fun toString(): String {
        return "$title / Price: $price"
    }
}