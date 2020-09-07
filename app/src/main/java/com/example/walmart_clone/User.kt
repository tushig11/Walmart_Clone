package com.example.walmart_clone
import java.io.Serializable

data class User(var email: String, var password: String):Serializable{
    lateinit var firstName: String
    lateinit var lastName: String
    constructor(firstName: String, lastName: String, email: String, password: String): this(email, password) {
        this.firstName = firstName
        this.lastName = lastName
    }
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is User) return false
        return email == other.email && password == other.password
    }
    override fun toString(): String {
        return "Email: $email"
    }
}