package com.akshai.ezetapmachinetest.ui.theme.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.akshai.mylibrary.Constants.UI_COMPONENTS
import com.akshai.ezetapmachinetest.model.UiDataModel
import com.akshai.ezetapmachinetest.ui.theme.EzetapMachineTestTheme
import com.akshai.ezetapmachinetest.ui.theme.components.CircularLoader
import com.akshai.ezetapmachinetest.ui.theme.components.FormUiComponent
import com.akshai.ezetapmachinetest.ui.theme.components.SimpleImage
import com.akshai.ezetapmachinetest.utils.DataHandler
import com.akshai.ezetapmachinetest.utils.UIKey
import com.akshai.ezetapmachinetest.utils.toast
import com.akshai.ezetapmachinetest.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EzetapMachineTestTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    GenerateUi(mainViewModel)
                }
            }
        }
        mainViewModel.fetchCustomUI()
    }
}

@Composable
fun GenerateUi(mainViewModel: MainViewModel) {

    val uiDataModel: UiDataModel by remember { mutableStateOf(UiDataModel()) }
    val uiResponse = mainViewModel.uiResponse.collectAsState()
    val context = LocalContext.current

    uiResponse.value.let {
        when (it) {
            is DataHandler.ERROR -> context.toast(it.message!!)

            is DataHandler.LOADING -> CircularLoader()

            is DataHandler.SUCCESS -> Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SimpleImage(it.data!!.logoUrl)
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    items(it.data.uidata) { ui ->
                        FormUiComponent(ui,
                            onChangeTextField = { text, key ->

                                when (key) {
                                    UIKey.text_name.name -> uiDataModel.name = text
                                    UIKey.text_phone.name -> uiDataModel.phone = text
                                    UIKey.text_city.name -> uiDataModel.city = text
                                }

                            }
                        ) {
                            uiDataModel.imageUrl = it.data.logoUrl
                            val intent: Intent =
                                Intent(context, ActivityTwo::class.java).apply {
                                    putExtra(UI_COMPONENTS, uiDataModel)
                                }
                            context.startActivity(intent)
                        }
                    }
                }
            }

        }
    }

}





