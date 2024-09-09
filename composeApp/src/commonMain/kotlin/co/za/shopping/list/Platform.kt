package co.za.shopping.list

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform