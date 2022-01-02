package com.example.aboutme.Main_Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aboutme.R
import com.example.aboutme.data.Person_Details
import com.example.aboutme.other.Adapters
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodein by kodein()
    private val factory: MainViewModelFactory by instance()
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
            val adapter = Adapters(this,listOf(), viewModel)
            rvPersonDetails.layoutManager = LinearLayoutManager(this)
            rvPersonDetails.adapter = adapter
            viewModel.getAllPersonsInfo().observe(this, Observer {
                adapter.items = it
                adapter.notifyDataSetChanged()
            })

            fab.setOnClickListener {
                AddPersonInfoDialog(
                    this,
                    object : AddPersonInfoListener {
                        override fun onAddButtonClicked(item: Person_Details) {
                            viewModel.upsert(item)
                        }
                    }).show()
            }
        }

    }