package com.example.searchmicroservice.components


import android.content.Intent
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.searchmicroservice.CourseActivity
import com.example.searchmicroservice.MainActivity
import com.example.searchmicroservice.R
import com.example.searchmicroservice.models.Course
import java.io.File
import java.util.Base64


class CategoryAdapter1(private val context: MainActivity, private val courses: List<Course>) :
    RecyclerView.Adapter<ListItem2>(), ListAdapter {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListItem2{
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_item_layout, parent, false)
        return ListItem2(itemView)
    }


    override fun getItemCount(): Int = courses.size

    override fun onBindViewHolder(ListItem2:ListItem2, position: Int) {
        val course = courses[position]

        ListItem2.itemView.setOnClickListener{
            val intent = Intent(context, CourseActivity::class.java)
            if (course.image != null ) {
                val IMAGEfile = File(context.filesDir, "base.jpg")
                val ImageBytes = Base64.getDecoder().decode(course.image)
                IMAGEfile.writeBytes(ImageBytes)
                intent.putExtra("course4", IMAGEfile)
            }
            if (course.video != null ) {
                val Videofile = File(context.filesDir, "video.mp4")
                val videoBytes = Base64.getDecoder().decode(course.video)
                Videofile.writeBytes(videoBytes)
                intent.putExtra("course5", Videofile)
            }

            intent.putExtra("course", course.name)
            intent.putExtra("course1", course.duration)
            intent.putExtra("course2", course.instructor)
            intent.putExtra("course3", course.description)

            context.startActivity(intent)
        }
        ListItem2.nameTextView.text = course.name

        ListItem2.durationTextView.text = course.duration
        ListItem2.instructorTextView.text = course.instructor
        ListItem2.descriptionTextView.text = course.description
        ListItem2.locationTextView.text = course.location


    }

    override fun registerDataSetObserver(p0: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun unregisterDataSetObserver(p0: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(p0: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        TODO("Not yet implemented")
    }

    override fun getViewTypeCount(): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun areAllItemsEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEnabled(p0: Int): Boolean {
        TODO("Not yet implemented")
    }

}
