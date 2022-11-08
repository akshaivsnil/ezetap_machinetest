package com.akshai.ezetapmachinetest.repo

import com.akshai.ezetapmachinetest.entity.UiResponse
import com.akshai.ezetapmachinetest.utils.DataHandler

interface MainRepository {

    suspend fun fetchCustomUIWithKTor() : DataHandler<UiResponse>

}