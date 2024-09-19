package co.za.shopping.list.ui

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberNavigatorScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import co.za.shopping.list.viewModel.CartViewModel

class CreateListScreen : Screen {

@Composable
override fun Content() {
    val navigator = LocalNavigator.currentOrThrow
    val viewModel = navigator.rememberNavigatorScreenModel {   CartViewModel() }
    var name by remember { mutableStateOf(TextFieldValue("")) }
    val onDoneClick = {
        if (name.text.isNotEmpty()) {
            viewModel.addCart(name.text)
            navigator.pop()
        }
    }

    Surface {
        val focusREquester = remember { FocusRequester() }
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Column(verticalArrangement = spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    value = name,
                    modifier = Modifier.focusRequester(focusREquester),
                    label = { Text("List Name") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = { onDoneClick() }),
                    placeholder = { Text("E.g Groceries") },
                    onValueChange = { name = it },
                )

                Button(onClick = onDoneClick) {
                    Text("Done")
                }
            }
        }
    }
}
}