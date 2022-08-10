package com.faiq.github.ui.listuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.faiq.github.databinding.ActivityListUserBinding

class ListUserActivity : AppCompatActivity() {

    private var _binding : ActivityListUserBinding? = null
    private val binding get() = _binding as ActivityListUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityListUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[ListUserViewModel::class.java]

        viewModel.listUser()
        viewModel.getResulListUser().observe(this) {
            binding.rvlistUser.apply {
                adapter = ListAdapter(it)
                layoutManager = LinearLayoutManager(this@ListUserActivity)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
