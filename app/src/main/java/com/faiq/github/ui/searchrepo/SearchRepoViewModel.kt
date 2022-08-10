package com.faiq.github.ui.searchrepo

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faiq.github.data.Repo
import com.faiq.github.data.RepoItem
import com.faiq.github.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchRepoViewModel: ViewModel() {

    private var searchRepo = MutableLiveData<Repo>()

    fun searchRepos(u : String){
        ApiConfig.getApiService().searchRepo(u).enqueue(object : Callback<Repo> {
            override fun onResponse(call: Call<Repo>, response: Response<Repo>) {
                searchRepo.value = response.body()
            }

            override fun onFailure(call: Call<Repo>, t: Throwable) {
                Log.e(TAG, "onFailure: $t", )

            }

        })
    }

    fun getSearchRepo() : LiveData<Repo> = searchRepo
}