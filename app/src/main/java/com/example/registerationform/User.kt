package com.example.registerationform

import java.io.Serializable

data class User(
    var title: String,
    var firstName: String,
    var lastName: String,
    var email: String,
    var phoneNumber: String,
    var password: String
) : Serializable {

    fun getUserName() = "Hello $title $firstName $lastName"
}
