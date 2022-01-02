package com.example.aboutme.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aboutme.Main_Activities.*
import com.example.aboutme.R
import com.example.aboutme.data.Person_Details
import kotlinx.android.synthetic.main.personviewmodel.view.*

class Adapters(
    val activity: MainActivity,
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
        holder.itemView.imageButton.setOnClickListener{
            if(holder.itemView.textView.text.isEmpty()){holder.itemView.textView.text = "Age:${curPersonDetails.age}\nAddress:${curPersonDetails.address}\nBatch:${curPersonDetails.education}\nPhone Number:${curPersonDetails.ph_number}"}
            else{holder.itemView.textView.text=""}
        }
        holder.itemView.Button.setOnClickListener {
            viewModel.delete(curPersonDetails)
        }
        holder.itemView.imageButton2.setOnClickListener{
            EditPersonInfoDialog(curPersonDetails,
                activity,
                object : EditPersonInfoListener {

                    override fun onAddButtonClicked(item1: Person_Details, item: Person_Details) {
                        viewModel.delete(curPersonDetails)
                        viewModel.upsert(item)
                    }
                }).show()
            if(holder.itemView.textView.text.isEmpty()){holder.itemView.textView.text = "Age:${curPersonDetails.age}\nAddress:${curPersonDetails.address}\nBatch:${curPersonDetails.education}\nPhone Number:${curPersonDetails.ph_number}"}
            else{holder.itemView.textView.text=""}

        }
    }

    inner class PersonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}