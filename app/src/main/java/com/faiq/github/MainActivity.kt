package com.faiq.github

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.faiq.github.databinding.ActivityMainBinding
import com.faiq.github.ui.listuser.ListUserActivity
import com.faiq.github.ui.searchrepo.SearchRepoActivity
import com.faiq.github.ui.searchuser.SearchUserActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnJson.setOnClickListener(this@MainActivity)
            btnListUser.setOnClickListener(this@MainActivity)
            btnRepo.setOnClickListener(this@MainActivity)
            btnSearhUser.setOnClickListener(this@MainActivity)
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_json -> startActivity(Intent(this, JsonActivity::class.java))
            R.id.btn_list_user -> startActivity(Intent(this, ListUserActivity::class.java))
            R.id.btn_repo -> startActivity(Intent(this, SearchRepoActivity::class.java))
            R.id.btn_searh_user -> startActivity(Intent(this, SearchUserActivity::class.java))
        }
    }
}