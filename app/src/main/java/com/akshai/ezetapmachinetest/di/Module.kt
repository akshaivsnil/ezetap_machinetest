package com.akshai.ezetapmachinetest.di


import com.akshai.ezetapmachinetest.network.KTorHttpClient
import com.akshai.ezetapmachinetest.repo.MainRepository
import com.akshai.ezetapmachinetest.repo.MainRepositoryImpl
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)

object Module {

    @Singleton
    @Provides
    fun getHttpClient(httpClient: KTorHttpClient): HttpClient = httpClient.getHttpClient()

    @Provides
    fun getMainRepository(impl: MainRepositoryImpl): MainRepository = impl

}