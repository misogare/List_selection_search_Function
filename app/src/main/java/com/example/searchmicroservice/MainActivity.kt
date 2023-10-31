package com.example.searchmicroservice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.searchmicroservice.components.CategoryAdapter1
import com.example.searchmicroservice.components.CategoryAdapter3
import com.example.searchmicroservice.models.Course
import com.example.searchmicroservice.models.apilist
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MainActivity : ComponentActivity() {
    private lateinit var navigateButton: SearchView



        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val retrofit = Retrofit.Builder()
                .baseUrl("https://4682-103-44-33-226.ngrok-free.app/") // Replace with your API's base URL
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            val service = retrofit.create(apilist::class.java)
            CoroutineScope(Dispatchers.Main).launch {
                try {

                    val apiCategories = service.getCategories()
                    Log.d("wow", "onCreate: $apiCategories")
                    val recyclerView = findViewById<RecyclerView>(R.id.sam1)
                    val adapter = CategoryAdapter3(this@MainActivity, apiCategories)
                    recyclerView.adapter = adapter
                } catch (e: Exception) {
                    // Handle the error
                }
            }

            val call =  service.getCourses()
            call.enqueue(object : Callback<List<Course>> {
                override fun onResponse(call: Call<List<Course>>, response: Response<List<Course>>) {
                    if (response.isSuccessful) {
                        val apiCategories = response.body()
                        if (apiCategories != null) {

                            val recyclerView = findViewById<RecyclerView>(R.id.sam2)
                            val adapter = CategoryAdapter1(this@MainActivity, apiCategories)
                            recyclerView.adapter = adapter
                        }
                    }
                }

                override fun onFailure(call: Call<List<Course>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

        })

            val intentToNavigateTothirds = Intent(this, MainActivity2::class.java)

            navigateButton = findViewById(R.id.mad)

            navigateButton.setOnClickListener {

                startActivity(intentToNavigateTothirds)
    }
}

}