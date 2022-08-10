package com.faiq.github.network

import com.faiq.github.data.Repo
import com.faiq.github.data.RepoItem
import com.faiq.github.data.UsersResponse
import com.faiq.github.data.UsersResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun getListUsers(): Call<List<UsersResponseItem>>

    @GET("search/users")
    fun searchUser(@Query("q") username: String): Call<UsersResponse>

    @GET("search/repositories")
    fun searchRepo(@Query("q") repositories: String): Call<Repo>
}
