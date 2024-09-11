import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.ui.graphics.Color
import co.za.shopping.list.ErrorColor

data class CustomSnackbarVisuals(
    override val message: String,
    override val duration: SnackbarDuration = SnackbarDuration.Indefinite,
    val containerColor: Color = ErrorColor,
    val contentColor: Color = Color.White,
    override val actionLabel: String? = null,
    override val withDismissAction: Boolean = false
) : SnackbarVisuals
