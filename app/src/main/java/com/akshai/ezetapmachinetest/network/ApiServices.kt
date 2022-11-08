package com.akshai.ezetapmachinetest.network

import com.akshai.ezetapmachinetest.entity.FetchUIResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {

    @GET("mobileapps/android_assignment.json")
    suspend fun fetchCustomUI() : Response<FetchUIResponse>

}