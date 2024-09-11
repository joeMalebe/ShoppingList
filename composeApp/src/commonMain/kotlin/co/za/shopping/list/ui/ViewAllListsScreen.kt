package co.za.shopping.list.ui

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class ViewAllListsScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        Button(onClick = { navigator?.push(ConfigureListScreen()) }) {
            Text("Create list")
        }
    }

}