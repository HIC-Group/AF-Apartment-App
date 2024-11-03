package com.yunpnzr.afapartmentapp.presentation.auth.register

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yunpnzr.afapartmentapp.R
import com.yunpnzr.afapartmentapp.common.component.InputAuthNotPassword
import com.yunpnzr.afapartmentapp.common.component.InputAuthPassword
import com.yunpnzr.afapartmentapp.common.ui.theme.AppTheme
import com.yunpnzr.afapartmentapp.presentation.auth.login.AppBarLogin
import com.yunpnzr.afapartmentapp.presentation.auth.login.LoginInputScreen

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
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
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            AppBarRegister()
            RegisterInputScreen(modifier = Modifier, navController)
        }
    }
}

@Composable
fun RegisterInputScreen(
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
            text = "Hallo!",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Silahkan buat akun terlebih dahulu",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(
                    top = 4.dp,
                    bottom = 8.dp
                )
        )

        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        InputAuthNotPassword(
            title = "Nama",
            placeholder = "Nama",
            valueInput = name,
            onValueChange = { name = it },
            padding = 48
        )

        InputAuthNotPassword(
            title = "Email",
            placeholder = "Email",
            valueInput = email,
            onValueChange = { email = it },
            padding = 16
        )

        InputAuthPassword(
            title = "Password",
            placeholder = "Password",
            valueInput = password,
            onValueChange = { password = it },
            padding = 16
        )

        Button(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 56.dp)
                .height(40.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Buat Akun",
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
                text = "Sudah punya akun?",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Masuk",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .clickable {

                    }
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

        OutlinedButton(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
                .height(40.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = MaterialTheme.colorScheme.onBackground
            ),
            onClick = { /*TODO*/ }
        ){
            Image(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(24.dp),
                painter = painterResource(R.drawable.ic_google),
                contentDescription = "Google"
            )

            Text(
                text = "Daftar Dengan Akun Google",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
fun AppBarRegister(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = 32.dp,
                bottom = 64.dp,
                start = 24.dp,
                end = 24.dp
            ),
        horizontalArrangement = Arrangement.Center
    ) {

        val activity = (LocalContext.current as? Activity)

        /*Icon(
            modifier = modifier
                .clickable {
                    activity?.finish()
                },
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            tint = MaterialTheme.colorScheme.primary,
        )

        Spacer(modifier = Modifier.weight(1f))*/

        Text(
            modifier = modifier,
            text = "Daftar Akun",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
        )

        /*Spacer(modifier = Modifier.weight(1f))

        Icon(
            modifier = modifier
                .clickable {
                    activity?.finish()
                },
            painter = painterResource(R.drawable.ic_close),
            contentDescription = "Back",
            tint = MaterialTheme.colorScheme.primary,
        )*/
    }
}

@Composable
@Preview(showBackground = true)
fun RegisterScreenPreview(){
    AppTheme {
        RegisterScreen(navController = rememberNavController())
    }
}