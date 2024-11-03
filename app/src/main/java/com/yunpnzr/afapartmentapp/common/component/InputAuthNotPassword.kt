package com.yunpnzr.afapartmentapp.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun InputAuthNotPassword(
    modifier: Modifier = Modifier,
    title: String,
    placeholder: String,
    valueInput: String,
    onValueChange: (String) -> Unit,
    padding: Int
){

    //var value by remember { mutableStateOf(valueInput) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = padding.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            //modifier = Modifier.padding(top = padding.dp)
        )

        BasicTextField(
            value = valueInput,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.background)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onBackground,
                    shape = RoundedCornerShape(8.dp)
                ),
            textStyle = MaterialTheme.typography.bodyMedium,
            decorationBox = { innerTextField ->
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    //verticalAlignment = Alignment.CenterVertically
                ) {
                    if (valueInput.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
                        )
                    }
                    innerTextField()
                }
            }
        )
    }
}