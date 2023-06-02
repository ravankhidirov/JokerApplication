package com.ravankhidirov.jokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ravankhidirov.jokeapp.databinding.ActivityMainBinding
import com.ravankhidirov.jokeapp.view_model.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        binding.button.setOnClickListener {
            viewModel.getJoke(this)
        }

        viewModel.observeJoke().observe(this, Observer { joke->
            binding.setup.text = joke.setup
            binding.delivery.text = joke.delivery
        })

    }
}