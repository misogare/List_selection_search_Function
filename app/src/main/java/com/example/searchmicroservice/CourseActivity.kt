package com.example.searchmicroservice

import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import java.io.File


class CourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)
        val course = intent.getSerializableExtra("course") as String
        val course1 = intent.getSerializableExtra("course1") as String
        val course2 = intent.getSerializableExtra("course2") as String
        val course3 = intent.getSerializableExtra("course3") as String
        val imagebytes = intent.getSerializableExtra("course4") as File
        val videobytes = intent.getSerializableExtra("course5") as File
        Log.d("mvp", "onCreate: $course")
        val courseNameTextView = findViewById<TextView>(R.id.meow3)
        val courseDescriptionTextView = findViewById<TextView>(R.id.wew3)
        val courseDurationTextView = findViewById<TextView>(R.id.wew7)
        val courseLocationTextView = findViewById<TextView>(R.id.wew5)
        val imageTextView = findViewById<ImageView>(R.id.kalp)
        val videoTextView = findViewById<VideoView>(R.id.kalpe)

        courseNameTextView.text = course
        courseDescriptionTextView.text = course1
        courseDurationTextView.text = course2
        courseLocationTextView.text = course3

        if (imagebytes != null) {
            imageTextView.setVisibility(View.VISIBLE);
            val bitmap = BitmapFactory.decodeByteArray(
                imagebytes.readBytes(),
                0,
                imagebytes.readBytes().size
            )
            imageTextView.setImageBitmap(bitmap)
        }

            if ( videobytes != null) {
                videoTextView.setVisibility(View.VISIBLE);
                videoTextView.setVideoURI(Uri.parse(videobytes.toString()))
            videoTextView.start()
        }

    }
}