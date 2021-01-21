package com.example.nasafit.View

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nasafit.R
import com.example.nasafit.ViewModel.MarsViewModel
import com.mercury.retrofitkotlintutorial.Adapter.MarsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var marsViewModel : MarsViewModel
    private lateinit var marsAdapter: MarsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        marsViewModel = ViewModelProvider(this).get(MarsViewModel::class.java)
    }

        private fun setUI(){
            setActionBar()
            getDataFromAPI()
        }



    private fun  setActionBar(){
        val actionBar : ActionBar? = supportActionBar
        actionBar?.title = "Mars Photos"
        actionBar?.elevation = 4.toFloat()
        actionBar?.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(this,R.color.design_default_color_primary)
            )
        )

    }

    private fun getDataFromAPI() {
        marsViewModel.data.observe(this, Observer { data ->
            marsAdapter = MarsAdapter(photos = data.photos)

            recyclerView.adapter = marsAdapter
            recyclerView.layoutManager = LinearLayoutManager(this)

        })
    }
}