package co.za.shopping.list.viewModel

import cafe.adriel.voyager.core.model.StateScreenModel
import co.za.shopping.list.Carts
import co.za.shopping.list.GroceryItem
import co.za.shopping.list.ListCart
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

class CartViewModel(private val carts: Carts = Carts()) :
    StateScreenModel<ViewAllListsScreenState>(ViewAllListsScreenState(loading = true)) {
    fun loadData() {
        mutableState.value = state.value.copy(
            loading = false,
            lists = carts.getAllCarts(),
            noList = carts.getAllCarts().isEmpty()
        )
    }

    fun addCart(name: String) {
        if (name.isEmpty()) return
        carts.addCart(ListCart(id = name, name = name))
    }

    fun getCart(id: String): ListCart {
        carts.getCartById(id)?.let {
            return it
        }
        throw IllegalArgumentException("Cart with id $id not found")
    }

    fun updateCartItems(id: String, items: ImmutableList<GroceryItem>) {
        val cart = getCart(id)
        cart.updateItems(items)
    }
}

data class ViewAllListsScreenState(
    val loading: Boolean = false,
    val lists: ImmutableList<ListCart> = persistentListOf(),
    val noList: Boolean = true
)


