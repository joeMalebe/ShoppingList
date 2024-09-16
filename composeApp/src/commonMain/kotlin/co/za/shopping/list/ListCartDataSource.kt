package co.za.shopping.list

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList

data class ListCart(val id: Int, val name: String, val items: ImmutableList<GroceryItem>)
data class Carts(private val carts: MutableList<ListCart> = mutableListOf()) {
    fun addCart(cart: ListCart) {
        carts.add(cart)
    }

    fun getAllCarts(): ImmutableList<ListCart> {
        return carts.toPersistentList()
    }

    fun getCartById(id: Int): ListCart? {
        return carts.find { it.id == id }
    }
}