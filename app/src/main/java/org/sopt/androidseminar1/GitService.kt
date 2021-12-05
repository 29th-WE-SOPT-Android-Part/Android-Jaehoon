package org.sopt.androidseminar1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface GitService {
    @Headers("Content-Type:application/json")
    @GET("/users/{username}")
    fun getUser(
        @Path("username") userName : String
    ) : Call<ResponseGitUserData>

    @Headers("Content-Type:application/json")
    @GET("/users/{username}/followers")
    fun getGitFollowers(
        @Path("username") userName : String
    ) : Call<List<ResponseGitUserData>>
}