package com.faiq.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.faiq.github.databinding.ActivityJsonBinding

class JsonActivity : AppCompatActivity() {

    private var _binding : ActivityJsonBinding? = null
    private val binding get() = _binding as ActivityJsonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityJsonBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}