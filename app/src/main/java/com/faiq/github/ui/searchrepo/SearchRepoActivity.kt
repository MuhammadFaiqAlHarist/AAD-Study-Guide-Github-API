package com.faiq.github.ui.searchrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.faiq.github.R
import com.faiq.github.ui.listuser.ListUserViewModel

class SearchRepoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_repo)

        val u = "saya"

        val viewModel = ViewModelProvider(this)[SearchRepoViewModel::class.java]
        viewModel.searchRepos(u)
        viewModel.getSearchRepo().observe(this) {
            Log.i("ListUser", "onCreate: $it")
        }
    }
}