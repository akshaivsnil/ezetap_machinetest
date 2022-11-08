package com.akshai.ezetapmachinetest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshai.ezetapmachinetest.entity.FetchUIResponse
import com.akshai.ezetapmachinetest.entity.UiResponse
import com.akshai.ezetapmachinetest.repo.MainRepository
import com.akshai.ezetapmachinetest.utils.DataHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
    ) : ViewModel() {

    private val _uiResponse = MutableStateFlow<DataHandler<UiResponse>>(DataHandler.LOADING())
    val uiResponse: StateFlow<DataHandler<UiResponse>> = _uiResponse

    fun fetchCustomUI() = viewModelScope.launch {
        _uiResponse.value = mainRepository.fetchCustomUIWithKTor()
    }


    private fun handleResponse(response: Response<FetchUIResponse>): DataHandler<FetchUIResponse> {
        if (response.isSuccessful) {
            response.body()?.let {
                return DataHandler.SUCCESS(
                    data = it
                )
            }
        }
        return DataHandler.ERROR(message = "Data not Found")
    }

}