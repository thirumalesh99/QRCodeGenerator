package com.example.qrcodegenerator

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QRCodeSignUp()
        }
    }
}

@Composable
fun QRCodeSignUp() {
    var fullname by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var confirmpassword by remember { mutableStateOf("") }

    val context = LocalContext.current as Activity

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.SkyBlue))// Background color for the entire screen
    ) {
        // Top section with an image and blue background

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(id = R.drawable.qrcode_generator),
            contentDescription = "QRCode",
        )


        // Bottom section with email, password fields, and sign-in button on a white background
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = colorResource(id = R.color.SkyBlue))// Background color for the entire screen
                .padding(16.dp), // Padding for the fields
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(listOf(Color.Gray, Color.Gray)),
                        shape = RoundedCornerShape(16.dp)
                    ),
                value = fullname,
                onValueChange = { fullname = it },
                label = { Text("Enter FullName") }
            )

            Spacer(modifier = Modifier.height(6.dp)) // Space between fields


            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(listOf(Color.Gray, Color.Gray)),
                        shape = RoundedCornerShape(16.dp)
                    ),
                value = email,
                onValueChange = { email = it },
                label = { Text("Enter Your Email") }
            )

            Spacer(modifier = Modifier.height(6.dp)) // Space between fields

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(listOf(Color.Gray, Color.Gray)),
                        shape = RoundedCornerShape(16.dp)
                    ),
                value = country,
                onValueChange = { country = it },
                label = { Text("Enter Your Country") }
            )

            Spacer(modifier = Modifier.height(6.dp)) // Space between fields

            // Password Text Field
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(listOf(Color.Gray, Color.Gray)),
                        shape = RoundedCornerShape(16.dp)
                    ),
                value = password,
                onValueChange = { password = it },
                label = { Text("Enter Your Password") }
            )

            Spacer(modifier = Modifier.height(6.dp)) // Space between fields

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(listOf(Color.Gray, Color.Gray)),
                        shape = RoundedCornerShape(16.dp)
                    ),
                value = confirmpassword,
                onValueChange = { confirmpassword = it },
                label = { Text("Confirm Password") }
            )

            Spacer(modifier = Modifier.height(24.dp)) // Space between fields and button

            // Sign In Button
            Button(
                onClick = { /* TODO: Sign In action */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.PureWhite),
                    contentColor = colorResource(
                        id = R.color.SkyBlue
                    )
                )
            ) {
                Text(text = "Sign Up", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.weight(1f)) // Space between form section and sign-up text

            // Sign Up text section
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "You are an old tourist ?", fontSize = 14.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Sign In",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.PureWhite), // Blue text color for "Sign Up"
                    modifier = Modifier.clickable {
                        context.startActivity(Intent(context, SignInActivity::class.java))
                        context.finish()
                    }
                )
            }

            Spacer(modifier = Modifier.height(24.dp)) // Space between fields and button

        }

    }
}