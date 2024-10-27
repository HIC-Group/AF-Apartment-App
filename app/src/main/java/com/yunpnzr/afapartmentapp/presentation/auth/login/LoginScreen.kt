package com.yunpnzr.afapartmentapp.presentation.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yunpnzr.afapartmentapp.common.component.InputAuthNotPassword
import com.yunpnzr.afapartmentapp.common.component.InputAuthPassword
import com.yunpnzr.afapartmentapp.common.ui.theme.AppTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF70A1D7),
                        Color(0xFFF1F6FC)
                    )
                )
            )
    ) {
        LoginInputScreen()
    }
}

@Composable
fun LoginInputScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
            .background(MaterialTheme.colorScheme.background)
            .padding(
                top = 32.dp,
                bottom = 32.dp,
                start = 24.dp,
                end = 24.dp
            )
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Halo, silahkan isi data untuk masuk",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(
                    top = 4.dp,
                    bottom = 8.dp
                )
        )

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        InputAuthNotPassword(
            title = "Email",
            placeholder = "Enter your email",
            valueInput = email,
            onValueChange = { email = it },
            padding = 16
        )

        InputAuthPassword(
            title = "Password",
            placeholder = "Enter your password",
            valueInput = password,
            onValueChange = { password = it },
            padding = 8
        )

        Row(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )

            Text(
                text = "Lupa Password?",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(
                    top = 8.dp,
                    bottom = 8.dp
                )
            )
        }

        Button(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
                .height(40.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Belum punya akun?",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Daftar",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            HorizontalDivider(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
            )
            Text(
                text = "Atau",
                modifier = Modifier.padding(horizontal = 8.dp),
                style = MaterialTheme.typography.bodyMedium
            )
            HorizontalDivider(
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    AppTheme {
        LoginScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun LoginInputScreenPreview(){
    AppTheme {
        LoginInputScreen()
    }
}