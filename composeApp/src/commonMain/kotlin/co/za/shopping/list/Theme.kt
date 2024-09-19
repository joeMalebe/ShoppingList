import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import co.za.shopping.list.Accent
import co.za.shopping.list.DarkBackground
import co.za.shopping.list.DarkTextColor
import co.za.shopping.list.ErrorColor
import co.za.shopping.list.LightBackground
import co.za.shopping.list.LightTextColor
import co.za.shopping.list.Primary
import co.za.shopping.list.Secondary
import co.za.shopping.list.SubtleAccent
import co.za.shopping.list.TextOnPrimaryDark
import co.za.shopping.list.TextOnPrimaryLight
import co.za.shopping.list.TextOnSecondaryDark
import co.za.shopping.list.TextOnSecondaryLight
import co.za.shopping.list.White

@Composable
fun GotToGetTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        colorsDark
    } else {
        colorsLight
    }

    MaterialTheme(colorScheme = colors) {
        content()
    }
}

@Composable
fun HeadingText(text: String, textColer: Color = MaterialTheme.colorScheme.onBackground) {
    Text(
        text,
        color = textColer,
        style = MaterialTheme.typography.headlineMedium,
    )
}

@Composable
fun GroceryCategoryText(text: String, textColer: Color = MaterialTheme.colorScheme.onBackground) {
    Text(
        text,
        color = textColer,
        style = MaterialTheme.typography.titleLarge,
    )
}

@Composable
fun GroceryItemText(text: String, textColer: Color = MaterialTheme.colorScheme.onSecondary, textAlign: TextAlign = TextAlign.Center) {
    Text(
        text,
        style = MaterialTheme.typography.titleMedium,
        color = textColer,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign
    )
}


val colorsLight = lightColorScheme(
    primary = Primary,
    onPrimaryContainer = Accent,
    onSecondaryContainer = SubtleAccent,
    secondary = Secondary,
    background = LightBackground,
    onBackground = LightTextColor,
    onPrimary = TextOnPrimaryLight,
    onSecondary = TextOnSecondaryLight,
    surface = LightBackground,
    onSurface = LightTextColor,
    error =  ErrorColor,
    onError = White,

)

val colorsDark = darkColorScheme(
    primary = Primary,
    onPrimaryContainer = Accent,
    onSecondaryContainer = SubtleAccent,
    secondary = Secondary,
    background = DarkBackground,
    onBackground = DarkTextColor,
    onPrimary = TextOnPrimaryDark,
    onSecondary = TextOnSecondaryDark,
    surface = DarkBackground,
    onSurface = DarkTextColor,
    error = ErrorColor,
    onError = White
)

