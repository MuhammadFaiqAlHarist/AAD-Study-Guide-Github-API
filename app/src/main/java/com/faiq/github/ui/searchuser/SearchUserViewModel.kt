package com.faiq.github.ui.searchuser

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faiq.github.data.RepoItem
import com.faiq.github.data.UsersResponse
import com.faiq.github.data.UsersResponseItem
import com.faiq.github.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchUserViewModel : ViewModel() {

    private var searchUser = MutableLiveData<UsersResponse>()

    fun searchUsers(username : String){
        ApiConfig.getApiService().searchUser(username).enqueue(object : Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                searchUser.postValue(response.body())
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                Log.e("TAG","OnFailure: $t")
            }

        })
    }
    fun getUserSearch(): LiveData<UsersResponse> = searchUser
}