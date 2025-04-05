package com.example.qrcodegenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class QRCodeHomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QRCodeHomeScreen()
        }
    }
}


@Composable
fun QRCodeHomeScreen() {
//    val context = LocalContext.current as Activity

    var showDialog by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.soft_peach))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(id = R.color.crimson_red)
                )
                .padding(vertical = 6.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "QR Code Home",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = Color.White,
            )
            Spacer(modifier = Modifier.weight(1f))

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(color = Color.White)
                .padding(12.dp)

        ) {
            Text(
                text = "QR Code Management",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Column(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clickable {

                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_qrcode),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(36.dp)
                            .width(36.dp)
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Generate QR",
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Column(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clickable {

                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_qrcode),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(36.dp)
                            .width(36.dp)
                    )
                    Spacer(modifier = Modifier.height(6.dp))


                    Text(
                        text = "Scan QR",
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Column(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clickable {

                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_qrcode),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(36.dp)
                            .width(36.dp)
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Edit QR",
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }


            }

            Text(
                text = "Account Management",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {


                Column(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clickable {
                            showDialog = true
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_qrcode),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(36.dp)
                            .width(36.dp)
                    )
                    Spacer(modifier = Modifier.height(6.dp))


                    Text(
                        text = "Summary",
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Column(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clickable {

                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_qrcode),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(36.dp)
                            .width(36.dp)
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "My Profile",
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Column(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clickable {

                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_qrcode),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(36.dp)
                            .width(36.dp)
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Logout",
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }


            }

            Spacer(modifier = Modifier.height(12.dp))



        }
    }
}