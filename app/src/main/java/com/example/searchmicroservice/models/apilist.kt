package com.example.searchmicroservice.models


import retrofit2.Call
import retrofit2.http.GET

interface apilist {
        @GET("api/category")
         suspend fun getCategories(): List<Category>


    @GET("api/courses")
            fun getCourses(): Call<List<Course>>
}

