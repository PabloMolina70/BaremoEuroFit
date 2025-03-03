package com.example.baremoeurofitpablomolina

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyDualStatusCheckBox() {
    var option1 by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    var option2 by rememberSaveable { mutableStateOf(ToggleableState.Off) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(state = option1, onClick = {
                option1 = when (option1) {
                    ToggleableState.On -> ToggleableState.Off
                    ToggleableState.Off -> ToggleableState.On
                    ToggleableState.Indeterminate -> ToggleableState.On
                }
                if (option1 == ToggleableState.On) {
                    option2 = ToggleableState.Off
                }
            })
            Text(text = "Opcion 1")
        }

        Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(state = option2, onClick = {
                option2 = when (option2) {
                    ToggleableState.On -> ToggleableState.Off
                    ToggleableState.Off -> ToggleableState.On
                    ToggleableState.Indeterminate -> ToggleableState.On
                }
                if (option2 == ToggleableState.On) {
                    option1 = ToggleableState.Off
                }
            })
            Text(text = "Opcion 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyDualStatusCheckBoxPreview() {
    MyDualStatusCheckBox()
}
