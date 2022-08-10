package com.faiq.github.ui.listuser

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faiq.github.data.UsersResponseItem
import com.faiq.github.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// View Model = untuk menampilkan data ke dalam ui
class ListUserViewModel : ViewModel() {
    // List user digunakan sebagai pemampung data setelah di ambil dari API
    private val listUser = MutableLiveData<List<UsersResponseItem>>()

    fun listUser() {
        ApiConfig.getApiService().getListUsers().enqueue(object :
            Callback<List<UsersResponseItem>> {
            override fun onResponse(
                call: Call<List<UsersResponseItem>>,
                // data sudah berada di parameter response ketika fungsi getListUser dipakai
                response: Response<List<UsersResponseItem>>
            ) {
                // Mengisi listUser yang masih kosong dengan data response
                listUser.value = response.body()
//                listUser.postValue(response.body())
            }

            // throwable isi pesan error
            override fun onFailure(call: Call<List<UsersResponseItem>>, t: Throwable) {
                Log.e("TAG", "onFailure: $t")
            }
        })
    }

    // fungsi yang bertugas untuk menyediakan data untuk di tampilkan/diobserve di UI controller
    fun getResulListUser(): LiveData<List<UsersResponseItem>> = listUser
}