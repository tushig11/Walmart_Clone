package com.example.walmart_clone

class Category {
    var name:String? = null
    var description:String? = null
    var image:Int? = null
    constructor(name:String, description:String, image:Int){
        this.name = name
        this.description = description
        this.image = image
    }
}