package com.example.walmart_clone

import java.io.Serializable

class Category: Serializable {
    var name:String? = null
    var description:String? = null
    var image:Int? = null
    constructor(name:String, description:String, image:Int){
        this.name = name
        this.description = description
        this.image = image
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Category) return false
        return name == other.name
    }
}