package co.za.shopping.list

data class GroceryCategory(
    val id: Int,
    val name: String
)

data class GroceryItem(
    val id: Int,
    val name: String,
    val price: Double,
    val categoryId: Int
)

val groceryList = mutableListOf<GroceryItem>()

val groceryCategories = listOf(
    GroceryCategory(id = 1, name = "Fruits & Vegetables"),
    GroceryCategory(id = 2, name = "Meat & Fish"),
    GroceryCategory(id = 3, name = "Dairy & Eggs"),
    GroceryCategory(id = 4, name = "Bakery & Bread"),
    GroceryCategory(id = 5, name = "Beverages"),
    GroceryCategory(id = 6, name = "Pantry Staples"),
    GroceryCategory(id = 7, name = "Snacks & Sweets"),
    GroceryCategory(id = 8, name = "Frozen Foods"),
    GroceryCategory(id = 9, name = "Condiments & Sauces"),
    GroceryCategory(id = 10, name = "Cereals & Breakfast"),
    GroceryCategory(id = 11, name = "Health & Wellness"),
    GroceryCategory(id = 12, name = "Household Essentials"),
    GroceryCategory(id = 13, name = "Personal Care"),
    GroceryCategory(id = 14, name = "Pet Supplies"),
    GroceryCategory(id = 15, name = "Baby Products"),
    GroceryCategory(id = 16, name = "Deli & Prepared Foods")
)



val groceryItems = listOf(
    GroceryItem(id = 1, name = "Apple", price = 0.99, categoryId = 1),
    GroceryItem(id = 2, name = "Banana", price = 0.59, categoryId = 1),
    GroceryItem(id = 3, name = "Chicken Breast", price = 5.99, categoryId = 2),
    GroceryItem(id = 4, name = "Salmon", price = 12.99, categoryId = 2),
    GroceryItem(id = 5, name = "Milk", price = 1.49, categoryId = 3),
    GroceryItem(id = 6, name = "Cheddar Cheese", price = 2.99, categoryId = 3),
    GroceryItem(id = 7, name = "Whole Wheat Bread", price = 2.49, categoryId = 4),
    GroceryItem(id = 8, name = "Croissant", price = 1.99, categoryId = 4),
    GroceryItem(id = 9, name = "Orange Juice", price = 3.99, categoryId = 5),
    GroceryItem(id = 10, name = "Coffee", price = 7.99, categoryId = 5),
    GroceryItem(id = 11, name = "Pasta", price = 1.29, categoryId = 6),
    GroceryItem(id = 12, name = "Rice", price = 0.89, categoryId = 6),
    GroceryItem(id = 13, name = "Potato Chips", price = 2.99, categoryId = 7),
    GroceryItem(id = 14, name = "Chocolate Bar", price = 1.49, categoryId = 7),
    GroceryItem(id = 15, name = "Frozen Pizza", price = 4.99, categoryId = 8),
    GroceryItem(id = 16, name = "Ice Cream", price = 3.99, categoryId = 8),
    GroceryItem(id = 17, name = "Ketchup", price = 2.49, categoryId = 9),
    GroceryItem(id = 18, name = "Olive Oil", price = 6.99, categoryId = 9),
    GroceryItem(id = 19, name = "Corn Flakes", price = 2.79, categoryId = 10),
    GroceryItem(id = 20, name = "Oatmeal", price = 3.49, categoryId = 10),
    GroceryItem(id = 21, name = "Multivitamins", price = 12.99, categoryId = 11),
    GroceryItem(id = 22, name = "Protein Powder", price = 24.99, categoryId = 11),
    GroceryItem(id = 23, name = "Dish Soap", price = 3.49, categoryId = 12),
    GroceryItem(id = 24, name = "Toilet Paper", price = 5.99, categoryId = 12),
    GroceryItem(id = 25, name = "Shampoo", price = 4.49, categoryId = 13),
    GroceryItem(id = 26, name = "Toothpaste", price = 2.99, categoryId = 13),
    GroceryItem(id = 27, name = "Dog Food", price = 19.99, categoryId = 14),
    GroceryItem(id = 28, name = "Cat Litter", price = 10.99, categoryId = 14),
    GroceryItem(id = 29, name = "Baby Formula", price = 15.99, categoryId = 15),
    GroceryItem(id = 30, name = "Diapers", price = 24.99, categoryId = 15),
    GroceryItem(id = 31, name = "Deli Ham", price = 6.99, categoryId = 16),
    GroceryItem(id = 32, name = "Prepared Salad", price = 4.49, categoryId = 16)
)
