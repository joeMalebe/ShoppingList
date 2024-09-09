package co.za.shopping.list

import GotToGetTheme
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    GotToGetTheme {
        var showContent by remember { mutableStateOf(false) }
        //var groceries = mutableStateListOf<GroceryItem>(groceryItems)
        Scaffold {

            LazyVerticalGrid(
                columns = GridCells.Adaptive(100.dp),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = spacedBy(16.dp),
                verticalArrangement = spacedBy(16.dp)
            ) {

                groceryCategories.take(3).forEach {

                    item(span = { GridItemSpan(3) }) {
                        Text(
                            it.name,
                            style = MaterialTheme.typography.h5,
                        )
                    }

                    items(groceryItems.take(7)) { item ->

                        GroceryItem(item = item)
                        /*LazyHorizontalGrid(
                            rows = GridCells.Adaptive(100.dp),
                            contentPadding = PaddingValues(16.dp),
                            horizontalArrangement = spacedBy(16.dp),
                            verticalArrangement = spacedBy(16.dp)
                        ) {
                            items(groceryItems.take(5)) { item ->
                                GroceryItem(item = item)
                            }
                        }*/

                    }
                }

            }
        }

    }
}

@Composable
fun GroceryItem(item: GroceryItem, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.size(100.dp),
        backgroundColor = MaterialTheme.colors.secondaryVariant
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