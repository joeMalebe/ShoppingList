package co.za.shopping.list

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList

data class ListCart(val id: String, val name: String, ) {
    private val _items = mutableListOf<GroceryItem>()
    val items: ImmutableList<GroceryItem> get() = _items.toPersistentList()

    fun updateItems(items: ImmutableList<GroceryItem>) {
        _items.clear()
        _items.addAll(items)
    }
}
data class Carts(private val carts: MutableList<ListCart> = mutableListOf()) {
    fun addCart(cart: ListCart) {
        carts.add(cart)
    }

    fun getAllCarts(): ImmutableList<ListCart> {
        return carts.toPersistentList()
    }

    fun getCartById(id: String): ListCart? {
        return carts.find { it.id == id }
    }
}