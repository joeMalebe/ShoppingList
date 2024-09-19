package co.za.shopping.list.ui

import GotToGetTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class ThemedScreen(private val screen: Screen) {

    @Composable
    fun ThemedContent() {
        GotToGetTheme {
            screen.Content()
        }
    }
}