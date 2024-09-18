package co.za.shopping.list.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import cafe.adriel.voyager.core.model.rememberNavigatorScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class CreateListScreen : Screen {

@Composable
override fun Content() {
    val navigator = LocalNavigator.currentOrThrow
    val viewModel = navigator.rememberNavigatorScreenModel {   CartViewModel() }
    var name by remember { mutableStateOf(TextFieldValue("")) }
    Surface {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Column {
                OutlinedTextField(
                    value = name,
                    label = { Text("List Name") },
                    placeholder = { Text("E.g Groceries") },
                    onValueChange = { name = it },
                )

                Button(onClick = {
                    if (name.text.isEmpty()) return@Button
                    viewModel.addCart(name.text)
                    navigator.pop()
                }) {

                    Text("Create List")
                }
            }
        }
    }
}
}