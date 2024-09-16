package co.za.shopping.list.ui

import cafe.adriel.voyager.core.model.StateScreenModel
import co.za.shopping.list.Carts
import co.za.shopping.list.ListCart
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

class ViewAllListsScreenModel(private val carts: Carts = Carts()) :
    StateScreenModel<ViewAllListsScreenState>(ViewAllListsScreenState(loading = true)) {
    fun loadData() {
        mutableState.value = state.value.copy(
            loading = false,
            lists = carts.getAllCarts(),
            noList = carts.getAllCarts().isEmpty()
        )
    }
}

data class ViewAllListsScreenState(
    val loading: Boolean = false,
    val lists: ImmutableList<ListCart> = persistentListOf(),
    val noList: Boolean = true
)


