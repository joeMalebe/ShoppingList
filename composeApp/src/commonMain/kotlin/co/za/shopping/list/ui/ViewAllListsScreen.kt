package co.za.shopping.list.ui

import HeadingText
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberNavigatorScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import co.za.shopping.list.ListCart
import co.za.shopping.list.viewModel.CartViewModel

class ViewAllListsScreen : Screen {


    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = navigator.rememberNavigatorScreenModel { CartViewModel() }
        val state by viewModel.state.collectAsState()


            LaunchedEffect(Unit) {
                viewModel.loadData()
            }
        Scaffold(modifier = Modifier.fillMaxSize()) {
            when {
                state.loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Loading...")
                    }
                }

                /*state.noList -> {
                    LazyColumn {
                        item {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                AddNewCart(modifier = Modifier.fillMaxWidth()) {
                                    navigator.push(CreateListScreen())
                                }
                            }
                        }
                    }
                }
*/
                else -> {
                    LazyColumn(verticalArrangement = spacedBy(16.dp), modifier = Modifier.padding(16.dp)) {
                        items(state.lists) { cart ->
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                CartItem(cart = cart, onClick = {
                                    navigator.push(ConfigureListScreen(cart.id))
                                })
                            }
                        }
                        if (state.lists.isNotEmpty()) {
                            item { Divider() }
                        }
                        item {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                AddNewCart(modifier = Modifier.fillMaxWidth()) {
                                    navigator.push(CreateListScreen())
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun AddNewCart(modifier: Modifier, onNewCartClick: () -> Unit, ) {
        Card(modifier.clickable(onClick = onNewCartClick), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                HeadingText("Create List")
            }
        }
    }

    @Composable
    private fun CartItem(cart: ListCart, modifier: Modifier = Modifier, onClick: () -> Unit ) {
        Card(modifier.clickable(onClick = onClick)) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                HeadingText(cart.name)
            }
        }
    }
}