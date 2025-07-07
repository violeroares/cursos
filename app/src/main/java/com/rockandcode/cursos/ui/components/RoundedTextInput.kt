import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun RoundedTextInput(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    icon: ImageVector = Icons.Default.Edit, // Cambiá por Icons.Default.Check si querés
    iconDescription: String = "Editar",
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
) {
    var isFocused by remember { mutableStateOf(false) }

    Box(
        modifier =
            modifier
                .fillMaxWidth()
                .shadow(8.dp, shape = RoundedCornerShape(50))
                .background(Color.White, shape = RoundedCornerShape(50))
                .border(
                    width = 1.dp,
                    color = if (isFocused) Color(0xFF7B2FC5) else Color.LightGray,
                    shape = RoundedCornerShape(50),
                ).padding(horizontal = 16.dp, vertical = 13.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                enabled = enabled,
                textStyle =
                    MaterialTheme.typography.bodyLarge.copy(
                        color = if (enabled) Color.Black else Color.Gray,
                    ),
                singleLine = true,
                modifier =
                    Modifier
                        .weight(1f)
                        .onFocusChanged { isFocused = it.isFocused },
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = TextStyle(color = Color.Gray),
                        )
                    }
                    innerTextField()
                },
            )

            Spacer(Modifier.width(8.dp))

            Icon(
                imageVector = icon,
                contentDescription = iconDescription,
                tint = if (enabled) Color(0xFF7B2FC5) else Color.Gray,
                modifier = Modifier.size(20.dp),
            )
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}
