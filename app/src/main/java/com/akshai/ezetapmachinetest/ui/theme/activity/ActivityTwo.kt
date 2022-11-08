package com.akshai.ezetapmachinetest.ui.theme.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.akshai.ezetapmachinetest.model.UiDataModel
import com.akshai.ezetapmachinetest.ui.theme.EzetapMachineTestTheme
import com.akshai.ezetapmachinetest.ui.theme.components.SimpleImage
import com.akshai.mylibrary.Constants.UI_COMPONENTS

class ActivityTwo : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val model: UiDataModel =
            intent.extras?.getParcelable<UiDataModel>(UI_COMPONENTS) as UiDataModel

        setContent {
            EzetapMachineTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        SimpleImage(model.imageUrl)
                        Text(
                            text = "User Name - : ${model.name} ",
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = "User Phone No. - :  ${model.phone}",
                            modifier = Modifier.padding(top = 10.dp)
                        )
                        Text(
                            text = "User City - : ${model.city}",
                            modifier = Modifier.padding(top = 10.dp)
                        )
                    }

                }
            }

        }
    }
}