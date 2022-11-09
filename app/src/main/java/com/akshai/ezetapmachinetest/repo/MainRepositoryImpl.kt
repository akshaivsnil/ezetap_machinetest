package com.akshai.ezetapmachinetest.repo

import com.akshai.ezetapmachinetest.entity.UiResponse
import com.akshai.mylibrary.Constants.BASE_URL
import com.akshai.mylibrary.Constants.END_POINT_UI_COMPONENT
import com.akshai.ezetapmachinetest.utils.DataHandler
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
) : MainRepository {

    override suspend fun fetchCustomUI(): DataHandler<UiResponse> {
        return try {
            DataHandler.SUCCESS(
                httpClient.get {
                    url("$BASE_URL$END_POINT_UI_COMPONENT")
                }
            )

        } catch (e: Exception) {
            e.printStackTrace()
            DataHandler.ERROR(message = e.toString())
        }
    }

}