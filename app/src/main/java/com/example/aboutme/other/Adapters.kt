package com.example.aboutme.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aboutme.Main_Activities.MainViewModel
import com.example.aboutme.R
import com.example.aboutme.data.Person_Details
import kotlinx.android.synthetic.main.personviewmodel.view.*

class Adapters(
    var items: List<Person_Details>,
    private val viewModel: MainViewModel
): RecyclerView.Adapter<Adapters.PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.personviewmodel, parent, false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val curPersonDetails = items[position]

        holder.itemView.tvName.text = curPersonDetails.name
        holder.itemView.tvAge.text = "${curPersonDetails.age}"
        holder.itemView.tvCgpa.text="${curPersonDetails.cgpa}"
        holder.itemView.tvEducation.text=curPersonDetails.education
        holder.itemView.tvPhone.text=curPersonDetails.ph_number
        holder.itemView.tvAddress.text=curPersonDetails.address
        holder.itemView.button.setOnClickListener {
            viewModel.delete(curPersonDetails)
        }
    }

    inner class PersonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}