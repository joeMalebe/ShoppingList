package co.za.shopping.list.viewModel

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import co.za.shopping.list.GroceryCategory
import co.za.shopping.list.GroceryItem
import co.za.shopping.list.groceryCategories
import co.za.shopping.list.groceryItems
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableMap
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class ItemViewModel : StateScreenModel<State>(State(loading = true)) {

    private val _groceryList = mutableListOf<GroceryItem>()

    val _viewState: MutableStateFlow<State> = MutableStateFlow(State(loading = true))
    val viewState: StateFlow<State> = _viewState.asStateFlow()

    val groceryList: ImmutableList<GroceryItem> = _groceryList.toPersistentList()

    fun addGroceryItem(item: GroceryItem): Boolean {
        if(viewState.value.itemsInList.contains(item)) return false
        viewState.value.itemsInList.add(item)
        //_viewState.value = viewState.value.copy(itemsInList = _groceryList.toPersistentList())
        return true
    }

    val groceriesByCategory = groceryItems.groupBy { it.categoryId }.toImmutableMap()

    fun loadData() {
        screenModelScope.launch {
          delay(600)

        mutableState.value = state.value.copy(
            loading = false,
            groceriesItems = groceryItems.toPersistentList(),
            categoriesIds = getCategoriesIds(),
            groceryCategories = groceryCategories.toPersistentList(),
        )}
    }

    fun getGroceryByCategory(id: Int): PersistentList<GroceryItem> =
        groceriesByCategory[id]?.toPersistentList() ?: persistentListOf()

    fun getCategoriesIds(): PersistentList<Int> = groceriesByCategory.keys.toPersistentList()

    fun getCategoryById(id: Int, groceryCategories: PersistentList<GroceryCategory>) =
        groceryCategories.find { it.id == id } ?: GroceryCategory(0, "Unknown")

    fun getItemsInCategory(id: Int,groceries: PersistentList<GroceryItem>): PersistentList<GroceryItem> =
        groceries.filter { it.categoryId == id }.toPersistentList()

    fun removeGroceryItem(item: GroceryItem) {
        _groceryList.remove(item)
        //state.value = viewState.value.copy(itemsInList = _groceryList.toPersistentList())
    }
}

data class State(
    val itemsInList: MutableList<GroceryItem> = mutableListOf(),
    val categoriesIds: PersistentList<Int> = persistentListOf(),
    val groceriesItems: PersistentList<GroceryItem> = persistentListOf(),
    val groceryCategories: PersistentList<GroceryCategory> = persistentListOf(),
    val loading: Boolean = false)

