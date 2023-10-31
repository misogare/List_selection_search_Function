package com.example.searchmicroservice.components


import android.database.DataSetObserver
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.searchmicroservice.MainActivity
import com.example.searchmicroservice.R
import com.example.searchmicroservice.models.Category
import java.util.Base64


class CategoryAdapter3(private val context: MainActivity, private val Categories: List<Category>) :
    RecyclerView.Adapter<ListItem1>(), ListAdapter {
    private val selectedCategories = HashSet<Category>()



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListItem1{
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return ListItem1(itemView)
    }


    override fun getItemCount(): Int = Categories.size

    override fun onBindViewHolder(ListItem1:ListItem1 ,position: Int) {
        val category = Categories[position]

        ListItem1.categoryTextView1.text = category.name
        if (category.image != null) {
            val imageBytes = Base64.getDecoder().decode(category.image)
            val bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            ListItem1.categoryimage.setImageBitmap(bitmap)
        }
//        ListItem1.categoryCheckBox.isChecked = category in selectedCategories
//
//        ListItem1.categoryCheckBox.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                selectedCategories.add(category)
//            } else {
//                selectedCategories.remove(category)
//            }
//        }


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
