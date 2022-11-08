package com.akshai.ezetapmachinetest.ui.theme.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.akshai.ezetapmachinetest.entity.Uidata
import com.akshai.ezetapmachinetest.utils.UIType

@Composable
fun FormUiComponent(
    ui: Uidata,
    onChangeTextField: (name: String, key: String) -> Unit,
    onSubmitForm: () -> Unit,
) {

    var text by remember { mutableStateOf(TextFieldValue("")) }

    return when (ui.uitype) {

        UIType.label.name -> Text(text = ui.value)

        UIType.edittext.name -> OutlinedTextField(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp),
            value = text,
            label = { Text(text = ui.hint) },
            onValueChange = { newText ->
                text = newText
                onChangeTextField.invoke(text.text, ui.key)
            })

        UIType.button.name ->
            Button(
                onClick = {
                    onSubmitForm.invoke()
                },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp),
            ) {
                Text(text = "Submit")
            }

        else -> {}
    }
}