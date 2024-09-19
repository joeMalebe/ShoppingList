package co.za.shopping.list.ui

import CustomSnackbarVisuals
import GroceryCategoryText
import GroceryItemText
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentCompositeKeyHash
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import co.za.shopping.list.viewModel.ItemViewModel
import co.za.shopping.list.viewModel.CartViewModel
import co.za.shopping.list.viewModel.State
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ConfigureListScreen(private val cartID: String) : Screen {

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

        val categories = remember {
            state.groceryCategories
        }
        val scope = rememberCoroutineScope()

        val items = cartViewModel.getCart(cartID).items.toMutableStateList()


        Screen(
            items = items,
            scope = scope,
            cartName = cartViewModel.getCart(id = cartID).name,
            state = state,
            onDoneClick = {
                cartViewModel.updateCartItems(id = cartID, items.toPersistentList())
                navigator.pop()
            },
            onBackPressed = { navigator.pop() }
        )

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun Screen(
        items: SnapshotStateList<GroceryItem>,
        scope: CoroutineScope,
        cartName: String,
        state: State,
        onDoneClick: () -> Unit,
        onBackPressed: () -> Unit
    ) {

        val snackbarHostState = remember { SnackbarHostState() }
        Scaffold(topBar = {
            TopAppBar(
                title = { Text(cartName) },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = onDoneClick) {
                        Icon(Icons.Default.Done, contentDescription = "Done")
                    }
                }
            )
        }, snackbarHost = {
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

            when {
                state.loading -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(50.dp),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                state.groceryCategories.isNotEmpty() -> {
                    Box {
                        Content(
                            modifier = Modifier.padding(it),
                            groceries = items,
                            categories = state.groceryCategories,
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
        Box {
            val categoriesWithExpandedState = categories.map {
                var expanded by remember { mutableStateOf(false) }
                Triple(it, expanded) { expanded = !expanded }
            }
            LazyVerticalGrid(
                columns = GridCells.Adaptive(100.dp),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = spacedBy(16.dp),
                verticalArrangement = spacedBy(16.dp),
                modifier = modifier.animateContentSize()
            ) {

                if (groceries.isNotEmpty()) {
                    items(groceries, key = {
                        it.name
                    }) { item ->
                        GroceryItem(
                            item = item,
                            onClick = { onRemoveGroceryItem(item) },
                            cardColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                } else {
                    item(span = { GridItemSpan(3) }) {
                        GroceryCategoryText("Add new items to $cartName")
                    }
                }

                categoriesWithExpandedState.forEach { (category, expanded, onExpandedToggle) ->
                    item(span = { GridItemSpan(3) }) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            GroceryCategoryText(category.name)

                            IconButton(onClick = { onExpandedToggle() }) {
                                if (expanded) {

                                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Displaying ${category.name} items")

                                } else {
                                    Icon(Icons.Filled.KeyboardArrowRight, contentDescription = "Hidden ${category.name} items")
                                }
                            }
                        }
                    }
                    val g = category.groceryItems
                    items(g, key = {
                        buildString {
                            append(category.name)
                            append(it.id)
                        }
                    }) { item ->
                        AnimatedVisibility(visible = expanded) {
                            // todo add tick to indicate item is in list
                            GroceryItem(item = item, onClick = { onAddGroceryItem(item) })
                        }
                    }
                }

            }
        }
    }

    @Composable
    fun GroceryItem(
        item: GroceryItem,
        modifier: Modifier = Modifier,
        onClick: (() -> Unit)? = null,
        cardColor: Color = MaterialTheme.colorScheme.onSecondaryContainer
    ) {
        Card(
            modifier = modifier.size(100.dp).clickable { onClick?.invoke() },
            colors = CardDefaults.cardColors(containerColor = cardColor),
        ) {
            Column(
                verticalArrangement = Center,
                modifier = Modifier.padding(4.dp).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GroceryItemText(
                    item.name,
                    textAlign = TextAlign.Center
                )
                /*Text(
                    item.price.toString(),
                    color = MaterialTheme.colorScheme.onSecondary,
                    textAlign = TextAlign.Center
                )*/
            }
        }
    }
}