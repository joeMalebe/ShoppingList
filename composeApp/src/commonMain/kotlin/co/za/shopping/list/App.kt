package co.za.shopping.list

import GotToGetTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import co.za.shopping.list.ui.ViewAllListsScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    GotToGetTheme {
        Navigator(screen = ViewAllListsScreen())
    }
}