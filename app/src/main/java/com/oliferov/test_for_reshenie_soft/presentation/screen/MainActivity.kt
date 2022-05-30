package com.oliferov.test_for_reshenie_soft.presentation.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oliferov.test_for_reshenie_soft.R
import com.oliferov.test_for_reshenie_soft.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}