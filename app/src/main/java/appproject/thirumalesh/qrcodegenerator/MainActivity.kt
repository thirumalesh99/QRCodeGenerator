package appproject.thirumalesh.qrcodegenerator

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.delay

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoadingScreenCheck(::isUserLoggedIn, this)
        }
    }

    private fun isUserLoggedIn(value: Int) {

        when (value) {
            1 -> {
                gotoHomeActivity(this)
            }

            2 -> {
                gotoSignInActivity(this)
            }

        }
    }
}

@Composable
fun LoadingScreenCheck(isUserLoggedIn: (value: Int) -> Unit, fragmentActivity: FragmentActivity) {
    var splashValue by remember { mutableStateOf(true) }

    val context = LocalContext.current as Activity


    LaunchedEffect(Unit) {
        delay(3000)
        splashValue = false
    }

    if (splashValue) {
        LoadingScreen()
    } else {
        val currentStatus = QRCodeGeneratorData.readLS(context)


        if (currentStatus) {
            val biometricManager = BiometricManager.from(fragmentActivity)
            if (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG) == BiometricManager.BIOMETRIC_SUCCESS) {
                val executor = ContextCompat.getMainExecutor(fragmentActivity)
                val biometricPrompt =
                    BiometricPrompt(
                        fragmentActivity,
                        executor,
                        object : BiometricPrompt.AuthenticationCallback() {
                            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                                super.onAuthenticationSucceeded(result)
                                isUserLoggedIn.invoke(1)
                            }

                            override fun onAuthenticationError(
                                errorCode: Int,
                                errString: CharSequence
                            ) {
                                super.onAuthenticationError(errorCode, errString)
                                Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG)
                                    .show()
                            }

                            override fun onAuthenticationFailed() {
                                super.onAuthenticationFailed()
                                Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG)
                                    .show()
                            }
                        })

                val promptInfo = BiometricPrompt.PromptInfo.Builder()
                    .setTitle("FingerPrint Verification")
                    .setSubtitle("Place your finger to continue")
                    .setNegativeButtonText("Close")
                    .build()

                biometricPrompt.authenticate(promptInfo)
            } else {
                Toast.makeText(
                    fragmentActivity,
                    "This device doesn't support fingerprint",
                    Toast.LENGTH_LONG
                ).show()
                isUserLoggedIn.invoke(1)

            }
        } else {
            isUserLoggedIn.invoke(2)
        }

    }
}


@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.color1))
            .padding(WindowInsets.systemBars.asPaddingValues()),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Spacer(modifier = Modifier.weight(1f))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "QR Code Generator",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(12.dp))


            Image(
                painter = painterResource(id = R.drawable.qrcode_generator),
                contentDescription = "QR Code Generator",
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "By",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Thirumalesh",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold
                )
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

fun gotoHomeActivity(context: Activity) {
    context.startActivity(Intent(context, QRCodeHomeActivity::class.java))
    context.finish()
}
