import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
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

    MaterialTheme(colors = colors) {
        content()
    }
}

@Composable
fun HeadingText(text: String, textColer: Color = MaterialTheme.colors.onBackground) {
    Text(
        text,
        style = MaterialTheme.typography.h5,
    )
}


val colorsLight = lightColors(
    primary = Primary,
    primaryVariant = Accent,
    secondaryVariant = SubtleAccent,
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

val colorsDark = darkColors(
    primary = Primary,
    primaryVariant = Accent,
    secondaryVariant = SubtleAccent,
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

