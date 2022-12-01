package com.antgut.moviesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.antgut.moviesapp.databinding.ActivityMainBinding

class Activity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
    }

    fun setupBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }
}