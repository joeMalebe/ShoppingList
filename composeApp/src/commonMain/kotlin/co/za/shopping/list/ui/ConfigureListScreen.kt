package co.za.shopping.list.ui

import CustomSnackbarVisuals
import HeadingText
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme

import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentCompositeKeyHash
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberNavigatorScreenModel
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import co.za.shopping.list.GroceryCategory
import co.za.shopping.list.GroceryItem
import co.za.shopping.list.Success
import co.za.shopping.list.ItemViewModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ConfigureListScreen(private val cartID:String) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val cartViewModel = navigator.rememberNavigatorScreenModel { CartViewModel() }
        val itemViewModel: ItemViewModel = rememberScreenModel { ItemViewModel() }

        //todo add a fab or button to begin the shopping experience. in the experience the user can remove items from the list as they shop
        // they can also add new items and update the quantity of items they want to buy


        val state by itemViewModel.state.collectAsState()

        LaunchedEffect(currentCompositeKeyHash) {
            itemViewModel.loadData()
        }

        when {
            state.loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(modifier = Modifier.size(50.dp), color = MaterialTheme.colors.primary)
                }
            }

            else -> {
                val categories = remember {
                    state.groceryCategories
                }
                val scope = rememberCoroutineScope()

                val items = state.itemsInList.toMutableStateList()

                Screen(
                    items = items,
                    categories = categories,
                    scope = scope,
                    cartName = cartViewModel.getCart(id = cartID).name
                )
            }
        }
    }

    @Composable
    private fun Screen(
        items: SnapshotStateList<GroceryItem>,
        categories: PersistentList<GroceryCategory>,
        scope: CoroutineScope,
        cartName: String
    ) {

        val snackbarHostState = remember { SnackbarHostState() }
        Scaffold(snackbarHost  = {
            SnackbarHost(hostState = snackbarHostState, snackbar = { snackbarData ->
                val customVisuals = snackbarData.visuals as? CustomSnackbarVisuals
                if (customVisuals != null) {
                    Snackbar(
                        containerColor = customVisuals.containerColor,
                        contentColor = customVisuals.contentColor,
                        snackbarData = snackbarData
                    )
                }
            })
        }) {

            Box {
                Content(
                    groceries = items,
                    categories = categories,
                    onRemoveGroceryItem = { item ->
                        items.remove(item)
                    },
                    onAddGroceryItem = { item ->
                        if (!items.contains(item)) {
                            items.add(item)
                            scope.launch {
                                val job = scope.launch {
                                    snackbarHostState.showSnackbar(
                                        CustomSnackbarVisuals(
                                            containerColor = Success,
                                            contentColor = Color.White,
                                            message = "${item.name} added to list"
                                        )
                                    )
                                }
                                delay(1000)
                                job.cancel()
                            }

                        } else
                            scope.launch {
                                val job = scope.launch {
                                snackbarHostState.showSnackbar(
                                    CustomSnackbarVisuals(message = "${item.name} already in list")
                                )
                            }
                                delay(1000)
                                job.cancel()
                            }
                    },
                    cartName = cartName,
                )
            }
        }
    }

    @Composable
    private fun Content(
        cartName: String,
        groceries: SnapshotStateList<GroceryItem>,
        categories: PersistentList<GroceryCategory>,
        onRemoveGroceryItem: (GroceryItem) -> Unit,
        modifier: Modifier = Modifier,
        onAddGroceryItem: (GroceryItem) -> Unit,
    ) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(100.dp),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = spacedBy(16.dp),
            verticalArrangement = spacedBy(16.dp),
            modifier = modifier
        ) {

            if (groceries.isNotEmpty()) {
                item(span = { GridItemSpan(3) }) {
                    HeadingText(cartName)

                }

                items(groceries, key = {
                    it.name
                }) { item ->
                    GroceryItem(
                        item = item,
                        onClick = { onRemoveGroceryItem(item) },
                        cardColor = MaterialTheme.colors.primaryVariant
                    )
                }
            } else {
                item(span = { GridItemSpan(3) }) {
                    HeadingText("Add new items to your list")
                }
            }

            categories.forEach { category ->
                item(span = { GridItemSpan(3) }) {
                    HeadingText(category.name)
                }
                val g = category.groceryItems
                items(g, key = {
                    buildString {
                        append(category.name)
                        append(it.id)
                    }
                }) { item ->

                    // todo add tick to indicate item is in list
                    GroceryItem(item = item, onClick = { onAddGroceryItem(item) })

                }
            }

        }
    }

    @Composable
    fun GroceryItem(
        item: GroceryItem,
        modifier: Modifier = Modifier,
        onClick: (() -> Unit)? = null,
        cardColor: Color = MaterialTheme.colors.secondaryVariant
    ) {
        Card(
            modifier = modifier.size(100.dp).clickable { onClick?.invoke() },
            backgroundColor = cardColor
        ) {
            Column(
                verticalArrangement = spacedBy(4.dp),
                modifier = Modifier.padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(item.name, color = MaterialTheme.colors.onSecondary, textAlign = TextAlign.Center)
                Text(item.price.toString(), color = MaterialTheme.colors.onSecondary)
            }
        }
    }
}