package co.za.shopping.list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.lifecycle.rememberScreenLifecycleOwner
import co.za.shopping.list.GroceryCategory
import co.za.shopping.list.GroceryItem
import co.za.shopping.list.ViewData
import kotlinx.collections.immutable.PersistentList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ConfigureListScreen : Screen {

    @Composable
    override fun Content() {
        val viewData: ViewData = rememberScreenModel { ViewData() }

        //todo add a fab or button to begin the shopping experience. in the experience the user can remove items from the list as they shop
        // they can also add new items and update the quantity of items they want to buy


        val state by viewData.state.collectAsState()

        LaunchedEffect(currentCompositeKeyHash) {
            viewData.loadData()
        }

        when {
            state.loading -> {
                Text("Loading")
            }

            else -> {
                val categories = remember {
                    state.groceryCategories
                }
                val scope = rememberCoroutineScope()
                val scaffoldState = rememberScaffoldState()

                val items = state.itemsInList.toMutableStateList()

                Screen(
                    scaffoldState = scaffoldState,
                    items = items,
                    categories = categories,
                    scope = scope
                )
            }
        }
    }

    @Composable
    private fun Screen(
        scaffoldState: ScaffoldState,
        items: SnapshotStateList<GroceryItem>,
        categories: PersistentList<GroceryCategory>,
        scope: CoroutineScope
    ) {
        Scaffold(scaffoldState = scaffoldState, snackbarHost = {
            SnackbarHost(it) { data ->
                Snackbar(
                    backgroundColor = MaterialTheme.colors.error,
                    contentColor = MaterialTheme.colors.onError,
                    snackbarData = data
                )
            }
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
                        } else
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar(message = "${item.name} already in list")
                            }
                    },
                )
            }
        }
    }

    @Composable
    private fun Content(
        groceries: SnapshotStateList<GroceryItem>,
        categories: PersistentList<GroceryCategory>,
        onRemoveGroceryItem: (GroceryItem) -> Unit,
        modifier: Modifier = Modifier,
        onAddGroceryItem: (GroceryItem) -> Unit
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
                    HeadingText("Grocery List")

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
    private fun HeadingText(text: String) {
        Text(
            text,
            style = MaterialTheme.typography.h5,
        )
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