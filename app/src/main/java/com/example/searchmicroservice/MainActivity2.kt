package com.example.searchmicroservice


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.searchmicroservice.components.CategoryAdapter2
import com.example.searchmicroservice.models.Course
import com.example.searchmicroservice.models.apilist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MainActivity2 : AppCompatActivity() {


    private val searchView: androidx.appcompat.widget.SearchView by lazy {
        findViewById(R.id.categoryImageView1)
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://4682-103-44-33-226.ngrok-free.app/") // Replace with your API's base URL
            .addConverterFactory(MoshiConverterFactory.create())
            .build()


        val service = retrofit.create(apilist::class.java)
        val call =  service.getCourses()
        call.enqueue(object : Callback<List<Course>> {
            override fun onResponse(call: Call<List<Course>>, response: Response<List<Course>>) {
                if (response.isSuccessful) {
                    val apiCategories = response.body()
                    if (apiCategories != null) {
                        // Now you have the data, you can pass it to your RecyclerView adapter
                        val recyclerView = findViewById<RecyclerView>(R.id.sam4)
                        val adapter = CategoryAdapter2(this@MainActivity2, apiCategories)
                        recyclerView.adapter = adapter

                        searchView.setOnQueryTextListener(object :
                            androidx.appcompat.widget.SearchView.OnQueryTextListener {
                            override fun onQueryTextSubmit(query: String?): Boolean {
//                searchQuery.value = query
                                return true
                            }

                            override fun onQueryTextChange(newText: String?): Boolean {
                                if (newText != null) {
                                    adapter.filter(newText)
                                }
//                searchQuery.value = newText
                                return true

                            }
                        }

                        )
                        adapter.notifyDataSetChanged()

                    }
                }
            }

            override fun onFailure(call: Call<List<Course>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })




    }


}
