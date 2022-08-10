package com.faiq.github.ui.searchuser

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Adapter
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.faiq.github.R
import com.faiq.github.data.UsersResponseItem
import com.faiq.github.databinding.ActivitySearchUserBinding
import com.faiq.github.databinding.RowItemBinding.inflate
import com.faiq.github.ui.listuser.ListUserViewModel

class SearchUserActivity : AppCompatActivity() {

    private var _binding: ActivitySearchUserBinding? = null
    private val binding get() = _binding as ActivitySearchUserBinding

    private var _viewModel: SearchUserViewModel? = null
    private val viewModel get() = _viewModel as SearchUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySearchUserBinding.inflate(layoutInflater)
        _viewModel = ViewModelProvider(this)[SearchUserViewModel::class.java]
        setContentView(binding.root)

        searchUser()

        val viewModel = ViewModelProvider(this)[SearchUserViewModel::class.java]

        viewModel.getUserSearch().observe(this) {
            Log.i(TAG, "onCreate: $it, Nama Usernya -----> ${it.items?.get(0)?.login}")
            showUser(it.items)
        }


    }

    private fun showUser(data: List<UsersResponseItem>?) {
        Log.d("user", "ShowUser: $data")
        binding.listItem.apply {
            adapter = data?.let { SearchAdapter(it) }
            layoutManager = LinearLayoutManager(this@SearchUserActivity)
        }
    }

    private fun searchUser(){
        binding.svUser.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel?.searchUsers(it)
                }
                try {
                    val inputMethod = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                } catch (i : Throwable){
                    Log.e("searchUsers", "onQueryTextSubmit: $i", )
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }


}