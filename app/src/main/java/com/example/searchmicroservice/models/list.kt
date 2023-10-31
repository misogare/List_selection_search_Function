package com.example.searchmicroservice.models




import java.io.Serializable

data class Category(val name: String, val courses: List<Course>, val image: String, var checked: Boolean = false):
    Serializable


data class Course(val name: String, val duration: String , val instructor : String,val description : String , val location: String, val image : String, val video : String ):Serializable




