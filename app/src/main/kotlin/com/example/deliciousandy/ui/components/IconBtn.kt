package com.example.deliciousandy.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IconBtn(
    imageVector: ImageVector,
    tint: Color,
    contentDescription: String,
    onClick: () -> Unit,
) = IconButton(
    onClick = onClick,
    modifier = Modifier.padding(8.dp)
) {
    Icon(
        imageVector = imageVector,
        tint = tint,
        contentDescription = contentDescription
    )
}

@Composable
@Preview(showBackground = true)
fun IconBtnPreview() {
    IconBtn(
        imageVector = Icons.Default.Edit,
        tint = Color.Black,
        contentDescription = "",
    ) {
        // On Click Action
    }
}