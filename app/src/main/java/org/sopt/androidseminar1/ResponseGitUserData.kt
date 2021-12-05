package org.sopt.androidseminar1

import com.google.gson.annotations.SerializedName

data class ResponseGitUserData(
    @SerializedName("login")
    val name: String = "",
    @SerializedName("bio")
    val introduction: String = "",
    @SerializedName("avatar_url")
    val image: String = "",
)