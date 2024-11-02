package com.yunpnzr.afapartmentapp.presentation.auth.forgetpassword

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yunpnzr.afapartmentapp.common.component.InputAuthNotPassword
import com.yunpnzr.afapartmentapp.common.screen.AppScreen
import com.yunpnzr.afapartmentapp.common.ui.theme.AppTheme

@Composable
fun ForgetPasswordScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(LocalConfiguration.current.screenHeightDp.dp*3/4)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF70A1D7),
                            Color(0xFFF1F6FC)
                        )
                    )
                )
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                AppBarForgetPassword(modifier = Modifier, navController)
                ForgetPasswordInputScreen(modifier = Modifier, navController)
            }
        }
    }
}

@Composable
fun ForgetPasswordInputScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
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
            text = "Lupa Password",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Silahkan masukkan email kamu untuk mengatur ulang kata sandi",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(
                    top = 4.dp,
                )
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background,
            )
        ) {
            Text(
                text = "Email",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        start = 24.dp,
                    )
            )

            val email = remember { mutableStateOf("") }

            BasicTextField(
                value = email.value,
                onValueChange = { email.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 8.dp,
                        bottom = 16.dp,
                        start = 24.dp,
                        end = 24.dp
                    )
                    .height(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = RoundedCornerShape(8.dp)
                    ),
                textStyle = MaterialTheme.typography.bodyMedium
            )
        }

        Button(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 48.dp)
                .height(40.dp),
            shape = RoundedCornerShape(16.dp),
            onClick = {

            }
        ) {
            Text(
                text = "Kirim",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun AppBarForgetPassword(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val activity = (LocalContext.current as? Activity)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = 32.dp,
                bottom = 64.dp,
                start = 24.dp,
                end = 24.dp
            )
    ) {
        Icon(
            modifier = modifier
                .clickable {
                    navController.navigate(AppScreen.Login.route){
                        popUpTo(AppScreen.ForgetPassword.route){
                            inclusive = true
                        }
                    }
                },
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            tint = MaterialTheme.colorScheme.primary,
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = modifier,
            text = "Lupa Kata Sandi",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun ForgetPasswordScreenPreview() {
    AppTheme {
        ForgetPasswordScreen(navController = rememberNavController())
    }
}
