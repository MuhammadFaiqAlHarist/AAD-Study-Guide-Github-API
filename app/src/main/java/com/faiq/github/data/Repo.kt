package com.faiq.github.data

import com.google.gson.annotations.SerializedName

data class Repo(
    @field:SerializedName("items")
    val items: List<RepoItem>? = null
)

data class RepoItem(
    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("full_name")
    val fullName: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("topic")
    val topic: String? = null
)
