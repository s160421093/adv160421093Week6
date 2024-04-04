package com.ubaya.adv160421093week6.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ubaya.adv160421093week6.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}