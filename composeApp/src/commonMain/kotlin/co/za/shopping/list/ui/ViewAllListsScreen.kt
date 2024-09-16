package co.za.shopping.list.ui

import HeadingText
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class ViewAllListsScreen : Screen {


    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { ViewAllListsScreenModel() }
        val state = viewModel.state.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(Unit) {
            viewModel.loadData()
        }
        when {
            state.value.loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Loading...")
                }
            }

            state.value.noList -> {
                LazyColumn {
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            AddNewCart(modifier = Modifier.fillMaxWidth()) {
                                navigator.push(ConfigureListScreen())
                            }
                        }
                    }
                }
            }

            else -> {
                LazyColumn {
                    items(state.value.lists) { cart ->
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Card(Modifier.clickable {
                                navigator.push(ConfigureListScreen())
                            }) {
                                Text(cart.name)
                            }
                        }
                    }
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            AddNewCart(modifier = Modifier.fillMaxWidth()) {
                                navigator.push(ConfigureListScreen())
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun AddNewCart(modifier: Modifier, onNewCartClick: () -> Unit, ) {
        Card(modifier.clickable(onClick = onNewCartClick)) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                HeadingText("Create List")
            }
        }
    }
}