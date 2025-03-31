package com.example.qrcodegenerator

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.qrcodegenerator.ui.theme.QRCodeGeneratorTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoadingScreenCheck(::isUserLoggedIn)
        }
    }

    private fun isUserLoggedIn(value: Int) {

        when (value) {
            2 -> {
                gotoSignInActivity(this)
            }

        }
    }
}

@Composable
fun LoadingScreenCheck(isUserLoggedIn: (value: Int) -> Unit) {
    var splashValue by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(3000)
        splashValue = false
    }

    if (splashValue) {
        LoadingScreen()
    } else {
        isUserLoggedIn.invoke(2)
    }
}


@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.SkyBlue)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Spacer(modifier = Modifier.weight(1f))


            Image(
                painter = painterResource(id = R.drawable.qrcode_generator),
                contentDescription = "QR Code Generator",
            )

            Spacer(modifier = Modifier.weight(1f))


        }
    }

}


@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    LoadingScreen()
}

fun gotoSignInActivity(context: Activity) {
    context.startActivity(Intent(context, SignInActivity::class.java))
    context.finish()
}
