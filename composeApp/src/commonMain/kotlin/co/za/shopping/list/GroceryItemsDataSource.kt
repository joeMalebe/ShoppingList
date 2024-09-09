package co.za.shopping.list

import androidx.compose.runtime.Stable
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Stable
data class GroceryCategory(
    val id: Int,
    val name: String,
    val groceryItems: PersistentList<GroceryItem> = persistentListOf()
)

@Stable
data class GroceryItem(
    val id: Int,
    val name: String,
    val price: Double,
    val categoryId: Int
)

val groceryCategories = listOf(
    GroceryCategory(id = 1, name = "Fruits & Vegetables", persistentListOf(GroceryItem(id = 1, name = "Apple", price = 0.99, categoryId = 1),
        GroceryItem(id = 2, name = "Banana", price = 0.59, categoryId = 1),
        GroceryItem(id = 3, name = "Carrot", price = 0.89, categoryId = 1),
        GroceryItem(id = 4, name = "Broccoli", price = 1.79, categoryId = 1),
        GroceryItem(id = 5, name = "Strawberries", price = 3.49, categoryId = 1),
        GroceryItem(id = 6, name = "Spinach", price = 2.29, categoryId = 1),
        GroceryItem(id = 7, name = "Tomato", price = 1.19, categoryId = 1),
        GroceryItem(id = 8, name = "Bell Pepper", price = 1.49, categoryId = 1),
        GroceryItem(id = 9, name = "Potato", price = 0.79, categoryId = 1),)),

    GroceryCategory(id = 2, name = "Meat & Fish", persistentListOf(GroceryItem(id = 10, name = "Chicken Breast", price = 5.99, categoryId = 2),
        GroceryItem(id = 11, name = "Salmon", price = 12.99, categoryId = 2),
        GroceryItem(id = 12, name = "Ground Beef", price = 4.99, categoryId = 2),
        GroceryItem(id = 13, name = "Bacon", price = 3.99, categoryId = 2),
        GroceryItem(id = 14, name = "Pork Chops", price = 6.99, categoryId = 2),
        GroceryItem(id = 15, name = "Shrimp", price = 8.99, categoryId = 2),
        GroceryItem(id = 16, name = "Turkey", price = 7.49, categoryId = 2),
        GroceryItem(id = 17, name = "Tuna", price = 2.99, categoryId = 2),)),

    GroceryCategory(id = 3, name = "Dairy & Eggs", persistentListOf(GroceryItem(id = 18, name = "Milk", price = 1.49, categoryId = 3),
        GroceryItem(id = 19, name = "Cheddar Cheese", price = 2.99, categoryId = 3),
        GroceryItem(id = 20, name = "Yogurt", price = 0.89, categoryId = 3),
        GroceryItem(id = 21, name = "Eggs", price = 2.19, categoryId = 3),
        GroceryItem(id = 22, name = "Butter", price = 3.49, categoryId = 3),
        GroceryItem(id = 23, name = "Cottage Cheese", price = 2.59, categoryId = 3),
        GroceryItem(id = 24, name = "Cream Cheese", price = 1.79, categoryId = 3),)),

    GroceryCategory(id = 4, name = "Bakery & Bread", persistentListOf(GroceryItem(id = 25, name = "Whole Wheat Bread", price = 2.49, categoryId = 4),
        GroceryItem(id = 26, name = "Croissant", price = 1.99, categoryId = 4),
        GroceryItem(id = 27, name = "Bagel", price = 1.29, categoryId = 4),
        GroceryItem(id = 28, name = "Muffin", price = 1.49, categoryId = 4),
        GroceryItem(id = 29, name = "Baguette", price = 2.19, categoryId = 4),
        GroceryItem(id = 30, name = "Pita Bread", price = 1.79, categoryId = 4),
        GroceryItem(id = 31, name = "Dinner Roll", price = 0.89, categoryId = 4),
        GroceryItem(id = 32, name = "Sourdough Bread", price = 3.29, categoryId = 4),)),

    GroceryCategory(id = 5, name = "Beverages", persistentListOf(GroceryItem(id = 33, name = "Orange Juice", price = 3.99, categoryId = 5),
        GroceryItem(id = 34, name = "Coffee", price = 7.99, categoryId = 5),
        GroceryItem(id = 35, name = "Tea", price = 2.99, categoryId = 5),
        GroceryItem(id = 36, name = "Soda", price = 1.29, categoryId = 5),
        GroceryItem(id = 37, name = "Bottled Water", price = 0.99, categoryId = 5),
        GroceryItem(id = 38, name = "Energy Drink", price = 2.49, categoryId = 5),
        GroceryItem(id = 39, name = "Milkshake", price = 3.49, categoryId = 5),
        GroceryItem(id = 40, name = "Smoothie", price = 4.99, categoryId = 5),)),

    GroceryCategory(id = 6, name = "Pantry Staples", persistentListOf(// Pantry Staples (Category 6)
        GroceryItem(id = 41, name = "Pasta", price = 1.29, categoryId = 6),
        GroceryItem(id = 42, name = "Rice", price = 0.89, categoryId = 6),
        GroceryItem(id = 43, name = "Flour", price = 1.49, categoryId = 6),
        GroceryItem(id = 44, name = "Sugar", price = 1.39, categoryId = 6),
        GroceryItem(id = 45, name = "Olive Oil", price = 6.99, categoryId = 6),
        GroceryItem(id = 46, name = "Vinegar", price = 2.49, categoryId = 6),
        GroceryItem(id = 47, name = "Salt", price = 0.59, categoryId = 6),
        GroceryItem(id = 48, name = "Honey", price = 3.99, categoryId = 6),
        GroceryItem(id = 49, name = "Peanut Butter", price = 2.99, categoryId = 6),)),

    GroceryCategory(id = 7, name = "Snacks & Sweets", persistentListOf(GroceryItem(id = 50, name = "Potato Chips", price = 2.99, categoryId = 7),
        GroceryItem(id = 51, name = "Chocolate Bar", price = 1.49, categoryId = 7),
        GroceryItem(id = 52, name = "Cookies", price = 3.29, categoryId = 7),
        GroceryItem(id = 53, name = "Candy", price = 1.19, categoryId = 7),
        GroceryItem(id = 54, name = "Popcorn", price = 2.49, categoryId = 7),
        GroceryItem(id = 55, name = "Pretzels", price = 1.99, categoryId = 7),
        GroceryItem(id = 56, name = "Ice Cream Cone", price = 1.79, categoryId = 7),
        GroceryItem(id = 57, name = "Gummy Bears", price = 1.49, categoryId = 7),)),


    GroceryCategory(id = 8, name = "Frozen Foods", persistentListOf(GroceryItem(id = 58, name = "Frozen Pizza", price = 4.99, categoryId = 8),
        GroceryItem(id = 59, name = "Ice Cream", price = 3.99, categoryId = 8),
        GroceryItem(id = 60, name = "Frozen Vegetables", price = 2.79, categoryId = 8),
        GroceryItem(id = 61, name = "Frozen Fries", price = 2.99, categoryId = 8),
        GroceryItem(id = 62, name = "Frozen Waffles", price = 3.29, categoryId = 8),
        GroceryItem(id = 63, name = "Frozen Berries", price = 4.49, categoryId = 8),
        GroceryItem(id = 64, name = "Frozen Burritos", price = 5.99, categoryId = 8),)),

    GroceryCategory(id = 9, name = "Condiments & Sauces", persistentListOf(GroceryItem(id = 65, name = "Ketchup", price = 2.49, categoryId = 9),
        GroceryItem(id = 66, name = "Olive Oil", price = 6.99, categoryId = 9),
        GroceryItem(id = 67, name = "Mustard", price = 1.49, categoryId = 9),
        GroceryItem(id = 68, name = "Mayonnaise", price = 3.29, categoryId = 9),
        GroceryItem(id = 69, name = "Soy Sauce", price = 1.99, categoryId = 9),
        GroceryItem(id = 70, name = "Hot Sauce", price = 2.29, categoryId = 9),
        GroceryItem(id = 71, name = "Barbecue Sauce", price = 2.99, categoryId = 9),)),

    GroceryCategory(id = 10, name = "Cereals & Breakfast", persistentListOf(GroceryItem(id = 72, name = "Corn Flakes", price = 2.79, categoryId = 10),
        GroceryItem(id = 73, name = "Oatmeal", price = 3.49, categoryId = 10),
        GroceryItem(id = 74, name = "Granola", price = 4.29, categoryId = 10),
        GroceryItem(id = 75, name = "Pancake Mix", price = 2.99, categoryId = 10),
        GroceryItem(id = 76, name = "Maple Syrup", price = 5.49, categoryId = 10),
        GroceryItem(id = 77, name = "Breakfast Bars", price = 3.99, categoryId = 10),
        GroceryItem(id = 78, name = "Waffles", price = 2.79, categoryId = 10),)),

    GroceryCategory(id = 11, name = "Health & Wellness", persistentListOf(GroceryItem(id = 79, name = "Multivitamins", price = 12.99, categoryId = 11),
        GroceryItem(id = 80, name = "Protein Powder", price = 24.99, categoryId = 11),
        GroceryItem(id = 81, name = "Vitamin C", price = 8.99, categoryId = 11),
        GroceryItem(id = 82, name = "Fish Oil", price = 9.99, categoryId = 11),
        GroceryItem(id = 83, name = "Aspirin", price = 4.49, categoryId = 11),
        GroceryItem(id = 84, name = "First Aid Kit", price = 14.99, categoryId = 11),
        GroceryItem(id = 85, name = "Hand Sanitizer", price = 2.99, categoryId = 11),
        GroceryItem(id = 86, name = "Face Mask", price = 0.99, categoryId = 11),)),

    GroceryCategory(id = 12, name = "Household Essentials", persistentListOf(GroceryItem(id = 87, name = "Dish Soap", price = 3.49, categoryId = 12),
        GroceryItem(id = 88, name = "Toilet Paper", price = 5.99, categoryId = 12),
        GroceryItem(id = 89, name = "Laundry Detergent", price = 7.49, categoryId = 12),
        GroceryItem(id = 90, name = "Paper Towels", price = 4.49, categoryId = 12),
        GroceryItem(id = 91, name = "Trash Bags", price = 5.99, categoryId = 12),
        GroceryItem(id = 92, name = "Bleach", price = 2.49, categoryId = 12),
        GroceryItem(id = 93, name = "Disinfectant Spray", price = 4.99, categoryId = 12),)),

    GroceryCategory(id = 13, name = "Personal Care", persistentListOf(GroceryItem(id = 94, name = "Shampoo", price = 4.49, categoryId = 13),
        GroceryItem(id = 95, name = "Toothpaste", price = 2.99, categoryId = 13),
        GroceryItem(id = 96, name = "Body Wash", price = 3.79, categoryId = 13),
        GroceryItem(id = 97, name = "Deodorant", price = 2.49, categoryId = 13),
        GroceryItem(id = 98, name = "Lotion", price = 3.29, categoryId = 13),
        GroceryItem(id = 99, name = "Shaving Cream", price = 2.99, categoryId = 13),
        GroceryItem(id = 100, name = "Razor Blades", price = 9.99, categoryId = 13),)),

    GroceryCategory(id = 14, name = "Pet Supplies", persistentListOf(GroceryItem(id = 101, name = "Dog Food", price = 19.99, categoryId = 14),
        GroceryItem(id = 102, name = "Cat Litter", price = 10.99, categoryId = 14),
        GroceryItem(id = 103, name = "Dog Treats", price = 4.99, categoryId = 14),
        GroceryItem(id = 104, name = "Cat Food", price = 8.49, categoryId = 14),
        GroceryItem(id = 105, name = "Bird Seed", price = 6.99, categoryId = 14),
        GroceryItem(id = 106, name = "Pet Shampoo", price = 5.99, categoryId = 14),
        GroceryItem(id = 107, name = "Pet Toys", price = 7.49, categoryId = 14),)),

    GroceryCategory(id = 15, name = "Baby Products", persistentListOf(GroceryItem(id = 108, name = "Baby Formula", price = 15.99, categoryId = 15),
        GroceryItem(id = 109, name = "Diapers", price = 24.99, categoryId = 15),
        GroceryItem(id = 110, name = "Baby Wipes", price = 3.99, categoryId = 15),
        GroceryItem(id = 111, name = "Baby Lotion", price = 4.49, categoryId = 15),
        GroceryItem(id = 112, name = "Baby Shampoo", price = 3.79, categoryId = 15),
        GroceryItem(id = 113, name = "Baby Food", price = 1.29, categoryId = 15),
        GroceryItem(id = 114, name = "Baby Blanket", price = 12.99, categoryId = 15),)),

    GroceryCategory(id = 16, name = "Deli & Prepared Foods", persistentListOf(GroceryItem(id = 115, name = "Deli Ham", price = 6.99, categoryId = 16),
        GroceryItem(id = 116, name = "Prepared Salad", price = 4.49, categoryId = 16),
        GroceryItem(id = 117, name = "Rotisserie Chicken", price = 7.99, categoryId = 16),
        GroceryItem(id = 118, name = "Sushi", price = 9.99, categoryId = 16),
        GroceryItem(id = 119, name = "Deli Turkey", price = 5.99, categoryId = 16),
        GroceryItem(id = 120, name = "Meatballs", price = 4.99, categoryId = 16),
        GroceryItem(id = 121, name = "Chicken Salad", price = 3.99, categoryId = 16),
        GroceryItem(id = 122, name = "Stuffed Peppers", price = 6.49, categoryId = 16)))
)

val groceryItems = listOf(
    // Fruits & Vegetables (Category 1)
    GroceryItem(id = 1, name = "Apple", price = 0.99, categoryId = 1),
    GroceryItem(id = 2, name = "Banana", price = 0.59, categoryId = 1),
    GroceryItem(id = 3, name = "Carrot", price = 0.89, categoryId = 1),
    GroceryItem(id = 4, name = "Broccoli", price = 1.79, categoryId = 1),
    GroceryItem(id = 5, name = "Strawberries", price = 3.49, categoryId = 1),
    GroceryItem(id = 6, name = "Spinach", price = 2.29, categoryId = 1),
    GroceryItem(id = 7, name = "Tomato", price = 1.19, categoryId = 1),
    GroceryItem(id = 8, name = "Bell Pepper", price = 1.49, categoryId = 1),
    GroceryItem(id = 9, name = "Potato", price = 0.79, categoryId = 1),

    // Meat & Fish (Category 2)
    GroceryItem(id = 10, name = "Chicken Breast", price = 5.99, categoryId = 2),
    GroceryItem(id = 11, name = "Salmon", price = 12.99, categoryId = 2),
    GroceryItem(id = 12, name = "Ground Beef", price = 4.99, categoryId = 2),
    GroceryItem(id = 13, name = "Bacon", price = 3.99, categoryId = 2),
    GroceryItem(id = 14, name = "Pork Chops", price = 6.99, categoryId = 2),
    GroceryItem(id = 15, name = "Shrimp", price = 8.99, categoryId = 2),
    GroceryItem(id = 16, name = "Turkey", price = 7.49, categoryId = 2),
    GroceryItem(id = 17, name = "Tuna", price = 2.99, categoryId = 2),

    // Dairy & Eggs (Category 3)
    GroceryItem(id = 18, name = "Milk", price = 1.49, categoryId = 3),
    GroceryItem(id = 19, name = "Cheddar Cheese", price = 2.99, categoryId = 3),
    GroceryItem(id = 20, name = "Yogurt", price = 0.89, categoryId = 3),
    GroceryItem(id = 21, name = "Eggs", price = 2.19, categoryId = 3),
    GroceryItem(id = 22, name = "Butter", price = 3.49, categoryId = 3),
    GroceryItem(id = 23, name = "Cottage Cheese", price = 2.59, categoryId = 3),
    GroceryItem(id = 24, name = "Cream Cheese", price = 1.79, categoryId = 3),

    // Bakery & Bread (Category 4)
    GroceryItem(id = 25, name = "Whole Wheat Bread", price = 2.49, categoryId = 4),
    GroceryItem(id = 26, name = "Croissant", price = 1.99, categoryId = 4),
    GroceryItem(id = 27, name = "Bagel", price = 1.29, categoryId = 4),
    GroceryItem(id = 28, name = "Muffin", price = 1.49, categoryId = 4),
    GroceryItem(id = 29, name = "Baguette", price = 2.19, categoryId = 4),
    GroceryItem(id = 30, name = "Pita Bread", price = 1.79, categoryId = 4),
    GroceryItem(id = 31, name = "Dinner Roll", price = 0.89, categoryId = 4),
    GroceryItem(id = 32, name = "Sourdough Bread", price = 3.29, categoryId = 4),

    // Beverages (Category 5)
    GroceryItem(id = 33, name = "Orange Juice", price = 3.99, categoryId = 5),
    GroceryItem(id = 34, name = "Coffee", price = 7.99, categoryId = 5),
    GroceryItem(id = 35, name = "Tea", price = 2.99, categoryId = 5),
    GroceryItem(id = 36, name = "Soda", price = 1.29, categoryId = 5),
    GroceryItem(id = 37, name = "Bottled Water", price = 0.99, categoryId = 5),
    GroceryItem(id = 38, name = "Energy Drink", price = 2.49, categoryId = 5),
    GroceryItem(id = 39, name = "Milkshake", price = 3.49, categoryId = 5),
    GroceryItem(id = 40, name = "Smoothie", price = 4.99, categoryId = 5),

    // Pantry Staples (Category 6)
    GroceryItem(id = 41, name = "Pasta", price = 1.29, categoryId = 6),
    GroceryItem(id = 42, name = "Rice", price = 0.89, categoryId = 6),
    GroceryItem(id = 43, name = "Flour", price = 1.49, categoryId = 6),
    GroceryItem(id = 44, name = "Sugar", price = 1.39, categoryId = 6),
    GroceryItem(id = 45, name = "Olive Oil", price = 6.99, categoryId = 6),
    GroceryItem(id = 46, name = "Vinegar", price = 2.49, categoryId = 6),
    GroceryItem(id = 47, name = "Salt", price = 0.59, categoryId = 6),
    GroceryItem(id = 48, name = "Honey", price = 3.99, categoryId = 6),
    GroceryItem(id = 49, name = "Peanut Butter", price = 2.99, categoryId = 6),

    // Snacks & Sweets (Category 7)
    GroceryItem(id = 50, name = "Potato Chips", price = 2.99, categoryId = 7),
    GroceryItem(id = 51, name = "Chocolate Bar", price = 1.49, categoryId = 7),
    GroceryItem(id = 52, name = "Cookies", price = 3.29, categoryId = 7),
    GroceryItem(id = 53, name = "Candy", price = 1.19, categoryId = 7),
    GroceryItem(id = 54, name = "Popcorn", price = 2.49, categoryId = 7),
    GroceryItem(id = 55, name = "Pretzels", price = 1.99, categoryId = 7),
    GroceryItem(id = 56, name = "Ice Cream Cone", price = 1.79, categoryId = 7),
    GroceryItem(id = 57, name = "Gummy Bears", price = 1.49, categoryId = 7),

    // Frozen Foods (Category 8)
    GroceryItem(id = 58, name = "Frozen Pizza", price = 4.99, categoryId = 8),
    GroceryItem(id = 59, name = "Ice Cream", price = 3.99, categoryId = 8),
    GroceryItem(id = 60, name = "Frozen Vegetables", price = 2.79, categoryId = 8),
    GroceryItem(id = 61, name = "Frozen Fries", price = 2.99, categoryId = 8),
    GroceryItem(id = 62, name = "Frozen Waffles", price = 3.29, categoryId = 8),
    GroceryItem(id = 63, name = "Frozen Berries", price = 4.49, categoryId = 8),
    GroceryItem(id = 64, name = "Frozen Burritos", price = 5.99, categoryId = 8),

    // Condiments & Sauces (Category 9)
    GroceryItem(id = 65, name = "Ketchup", price = 2.49, categoryId = 9),
    GroceryItem(id = 66, name = "Olive Oil", price = 6.99, categoryId = 9),
    GroceryItem(id = 67, name = "Mustard", price = 1.49, categoryId = 9),
    GroceryItem(id = 68, name = "Mayonnaise", price = 3.29, categoryId = 9),
    GroceryItem(id = 69, name = "Soy Sauce", price = 1.99, categoryId = 9),
    GroceryItem(id = 70, name = "Hot Sauce", price = 2.29, categoryId = 9),
    GroceryItem(id = 71, name = "Barbecue Sauce", price = 2.99, categoryId = 9),

    // Cereals & Breakfast (Category 10)
    GroceryItem(id = 72, name = "Corn Flakes", price = 2.79, categoryId = 10),
    GroceryItem(id = 73, name = "Oatmeal", price = 3.49, categoryId = 10),
    GroceryItem(id = 74, name = "Granola", price = 4.29, categoryId = 10),
    GroceryItem(id = 75, name = "Pancake Mix", price = 2.99, categoryId = 10),
    GroceryItem(id = 76, name = "Maple Syrup", price = 5.49, categoryId = 10),
    GroceryItem(id = 77, name = "Breakfast Bars", price = 3.99, categoryId = 10),
    GroceryItem(id = 78, name = "Waffles", price = 2.79, categoryId = 10),

    // Health & Wellness (Category 11)
    GroceryItem(id = 79, name = "Multivitamins", price = 12.99, categoryId = 11),
    GroceryItem(id = 80, name = "Protein Powder", price = 24.99, categoryId = 11),
    GroceryItem(id = 81, name = "Vitamin C", price = 8.99, categoryId = 11),
    GroceryItem(id = 82, name = "Fish Oil", price = 9.99, categoryId = 11),
    GroceryItem(id = 83, name = "Aspirin", price = 4.49, categoryId = 11),
    GroceryItem(id = 84, name = "First Aid Kit", price = 14.99, categoryId = 11),
    GroceryItem(id = 85, name = "Hand Sanitizer", price = 2.99, categoryId = 11),
    GroceryItem(id = 86, name = "Face Mask", price = 0.99, categoryId = 11),

    // Household Essentials (Category 12)
    GroceryItem(id = 87, name = "Dish Soap", price = 3.49, categoryId = 12),
    GroceryItem(id = 88, name = "Toilet Paper", price = 5.99, categoryId = 12),
    GroceryItem(id = 89, name = "Laundry Detergent", price = 7.49, categoryId = 12),
    GroceryItem(id = 90, name = "Paper Towels", price = 4.49, categoryId = 12),
    GroceryItem(id = 91, name = "Trash Bags", price = 5.99, categoryId = 12),
    GroceryItem(id = 92, name = "Bleach", price = 2.49, categoryId = 12),
    GroceryItem(id = 93, name = "Disinfectant Spray", price = 4.99, categoryId = 12),

    // Personal Care (Category 13)
    GroceryItem(id = 94, name = "Shampoo", price = 4.49, categoryId = 13),
    GroceryItem(id = 95, name = "Toothpaste", price = 2.99, categoryId = 13),
    GroceryItem(id = 96, name = "Body Wash", price = 3.79, categoryId = 13),
    GroceryItem(id = 97, name = "Deodorant", price = 2.49, categoryId = 13),
    GroceryItem(id = 98, name = "Lotion", price = 3.29, categoryId = 13),
    GroceryItem(id = 99, name = "Shaving Cream", price = 2.99, categoryId = 13),
    GroceryItem(id = 100, name = "Razor Blades", price = 9.99, categoryId = 13),

    // Pet Supplies (Category 14)
    GroceryItem(id = 101, name = "Dog Food", price = 19.99, categoryId = 14),
    GroceryItem(id = 102, name = "Cat Litter", price = 10.99, categoryId = 14),
    GroceryItem(id = 103, name = "Dog Treats", price = 4.99, categoryId = 14),
    GroceryItem(id = 104, name = "Cat Food", price = 8.49, categoryId = 14),
    GroceryItem(id = 105, name = "Bird Seed", price = 6.99, categoryId = 14),
    GroceryItem(id = 106, name = "Pet Shampoo", price = 5.99, categoryId = 14),
    GroceryItem(id = 107, name = "Pet Toys", price = 7.49, categoryId = 14),

    // Baby Products (Category 15)
    GroceryItem(id = 108, name = "Baby Formula", price = 15.99, categoryId = 15),
    GroceryItem(id = 109, name = "Diapers", price = 24.99, categoryId = 15),
    GroceryItem(id = 110, name = "Baby Wipes", price = 3.99, categoryId = 15),
    GroceryItem(id = 111, name = "Baby Lotion", price = 4.49, categoryId = 15),
    GroceryItem(id = 112, name = "Baby Shampoo", price = 3.79, categoryId = 15),
    GroceryItem(id = 113, name = "Baby Food", price = 1.29, categoryId = 15),
    GroceryItem(id = 114, name = "Baby Blanket", price = 12.99, categoryId = 15),

    // Deli & Prepared Foods (Category 16)
    GroceryItem(id = 115, name = "Deli Ham", price = 6.99, categoryId = 16),
    GroceryItem(id = 116, name = "Prepared Salad", price = 4.49, categoryId = 16),
    GroceryItem(id = 117, name = "Rotisserie Chicken", price = 7.99, categoryId = 16),
    GroceryItem(id = 118, name = "Sushi", price = 9.99, categoryId = 16),
    GroceryItem(id = 119, name = "Deli Turkey", price = 5.99, categoryId = 16),
    GroceryItem(id = 120, name = "Meatballs", price = 4.99, categoryId = 16),
    GroceryItem(id = 121, name = "Chicken Salad", price = 3.99, categoryId = 16),
    GroceryItem(id = 122, name = "Stuffed Peppers", price = 6.49, categoryId = 16)
)
