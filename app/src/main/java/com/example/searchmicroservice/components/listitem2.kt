package com.example.searchmicroservice.components

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.searchmicroservice.R


class ListItem2(itemView: View) : ViewHolder(itemView) {

    val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
    val durationTextView: TextView = itemView.findViewById(R.id.durationTextView)
    val instructorTextView: TextView = itemView.findViewById(R.id.instructorTextView)
    val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    val locationTextView: TextView = itemView.findViewById(R.id.locationTextView)

}