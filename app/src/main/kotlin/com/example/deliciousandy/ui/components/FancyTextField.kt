package com.example.deliciousandy.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FancyTextField(
    value: String,
    placeHolderText: String,
    maxLines: Int = 1,
    keyboardType: KeyboardOptions = KeyboardOptions.Default,
    onValueChange: (String) -> Unit

) {
    TextField(
        value = value,

        label = { Text(text = placeHolderText) },
        maxLines = maxLines,
        keyboardOptions = keyboardType,
        onValueChange = onValueChange

    )
}

@Preview
@Composable
fun FancyTextFieldPreview() {
    FancyTextField(value = "", placeHolderText = "Fancy Text Field", onValueChange = {})
}
