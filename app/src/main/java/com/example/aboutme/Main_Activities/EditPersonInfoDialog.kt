package com.example.aboutme.Main_Activities

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.aboutme.R
import com.example.aboutme.data.Person_Details
import kotlinx.android.synthetic.main.dialoghai.*

class EditPersonInfoDialog (item:Person_Details,context: Context, var addDialogListener: EditPersonInfoListener) :
    AppCompatDialog(context) {
    val p=item
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialoghai)

        button2.setOnClickListener {

            val name = eName.text.toString()
            val age = eAge.text.toString().toInt()
            val cgpa=eCgpa.text.toString().toInt()
            val address=eAddress.text.toString()
            val education=eEducation.text.toString()
            val ph_number=ePh.text.toString()
            if(name.isEmpty() or address.isEmpty() or education.isEmpty() or ph_number.isEmpty()) {
                Toast.makeText(context, "Please enter data in All Fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val pitem = Person_Details(name = name, age = age, address = address, cgpa = cgpa, education = education, ph_number =ph_number)
            addDialogListener.onAddButtonClicked(p,pitem)
            dismiss()
        }

        button1.setOnClickListener {
            cancel()
        }
    }
}