package com.antgut.moviesapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.antgut.moviesapp.databinding.ActivityListBinding

class Activity : AppCompatActivity() {

    private var binding: ActivityListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
    }

    fun setupBinding(){
        binding = ActivityListBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }
}