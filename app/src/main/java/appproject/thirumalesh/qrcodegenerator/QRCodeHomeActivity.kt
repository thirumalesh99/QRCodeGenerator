package appproject.thirumalesh.qrcodegenerator

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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



@Preview(showBackground = true)
@Composable
fun QRCodeHomeScreen() {

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().padding(WindowInsets.systemBars.asPaddingValues())
    ) {

        Image(
            modifier = Modifier
                .padding(12.dp)
                .size(36.dp),
            painter = painterResource(id = R.drawable.ic_qrcode),
            contentDescription = "Qr Code"
        )

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "QR Code Generator",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall.copy(
                color = colorResource(id = R.color.color1),
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Generate , Scan , Customise QR Codes",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleSmall.copy(
                color = colorResource(id = R.color.color1)
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = colorResource(id = R.color.color2),
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.color2),
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .clickable {
                            context.startActivity(
                                Intent(
                                    context,
                                    GenerateQRCodeActivity::class.java
                                )
                            )

                        }
                        .weight(1f)
                        .background(
                            color = colorResource(id = R.color.white),
                            shape = RoundedCornerShape(6.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(12.dp))

                    Image(
                        modifier = Modifier
                            .size(48.dp),
                        painter = painterResource(id = R.drawable.ic_qrcode),
                        contentDescription = "Qr Code"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = colorResource(id = R.color.color1),
                                shape = RoundedCornerShape(bottomStart = 6.dp, bottomEnd = 6.dp)
                            )
                            .border(
                                width = 2.dp,
                                color = colorResource(id = R.color.color1),
                                shape = RoundedCornerShape(6.dp)
                            ),
                        text = "Generate QR Code",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            context.startActivity(
                                Intent(
                                    context,
                                    ScanQRCodeActivity::class.java
                                )
                            )
                        }
                        .background(
                            color = colorResource(id = R.color.white),
                            shape = RoundedCornerShape(6.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(12.dp))

                    Image(
                        modifier = Modifier
                            .size(48.dp),
                        painter = painterResource(id = R.drawable.ic_qrcode),
                        contentDescription = "Qr Code"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = colorResource(id = R.color.color1),
                                shape = RoundedCornerShape(bottomStart = 6.dp, bottomEnd = 6.dp)
                            )
                            .border(
                                width = 2.dp,
                                color = colorResource(id = R.color.color1),
                                shape = RoundedCornerShape(6.dp)
                            ),
                        text = "Scan QR Code",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .background(
                            color = colorResource(id = R.color.white),
                            shape = RoundedCornerShape(6.dp)
                        )
                        .clickable {
                            context.startActivity(
                                Intent(
                                    context,
                                    SavedQrCodeActivity::class.java
                                )
                            )
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(12.dp))

                    Image(
                        modifier = Modifier
                            .size(48.dp),
                        painter = painterResource(id = R.drawable.ic_qrcode),
                        contentDescription = "Qr Code"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = colorResource(id = R.color.color1),
                                shape = RoundedCornerShape(bottomStart = 6.dp, bottomEnd = 6.dp)
                            )
                            .border(
                                width = 2.dp,
                                color = colorResource(id = R.color.color1),
                                shape = RoundedCornerShape(6.dp)
                            ),
                        text = "Saved QR Codes",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .background(
                            color = colorResource(id = R.color.white),
                            shape = RoundedCornerShape(6.dp)
                        )
                        .clickable {
                            context.startActivity(
                                Intent(
                                    context,
                                    DeleteQrCodeActivity::class.java
                                )
                            )
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(12.dp))

                    Image(
                        modifier = Modifier
                            .size(48.dp),
                        painter = painterResource(id = R.drawable.ic_qrcode),
                        contentDescription = "Qr Code"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = colorResource(id = R.color.color1),
                                shape = RoundedCornerShape(bottomStart = 6.dp, bottomEnd = 6.dp)
                            )
                            .border(
                                width = 2.dp,
                                color = colorResource(id = R.color.color1),
                                shape = RoundedCornerShape(6.dp)
                            ),
                        text = "Delete QR Code",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .background(
                            color = colorResource(id = R.color.white),
                            shape = RoundedCornerShape(6.dp)
                        )
                        .clickable {
                            SelectedFile.selectedOption=1

                            context.startActivity(
                                Intent(
                                    context,
                                    AboutUsActivity::class.java
                                )
                            )
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(12.dp))

                    Image(
                        modifier = Modifier
                            .size(48.dp),
                        painter = painterResource(id = R.drawable.ic_qrcode),
                        contentDescription = "Qr Code"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = colorResource(id = R.color.color1),
                                shape = RoundedCornerShape(bottomStart = 6.dp, bottomEnd = 6.dp)
                            )
                            .border(
                                width = 2.dp,
                                color = colorResource(id = R.color.color1),
                                shape = RoundedCornerShape(6.dp)
                            ),
                        text = "Contact Us",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .background(
                            color = colorResource(id = R.color.white),
                            shape = RoundedCornerShape(6.dp)
                        )
                        .clickable {
                            SelectedFile.selectedOption=2
                            context.startActivity(
                                Intent(
                                    context,
                                    AboutUsActivity::class.java
                                )
                            )
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(12.dp))

                    Image(
                        modifier = Modifier
                            .size(48.dp),
                        painter = painterResource(id = R.drawable.ic_qrcode),
                        contentDescription = "Qr Code"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = colorResource(id = R.color.color1),
                                shape = RoundedCornerShape(bottomStart = 6.dp, bottomEnd = 6.dp)
                            )
                            .border(
                                width = 2.dp,
                                color = colorResource(id = R.color.color1),
                                shape = RoundedCornerShape(6.dp)
                            ),
                        text = "About Us",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .background(
                            color = colorResource(id = R.color.white),
                            shape = RoundedCornerShape(6.dp)
                        )
                        .clickable {
                            context.startActivity(
                                Intent(
                                    context,
                                    UserProfileActivity::class.java
                                )
                            )
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(12.dp))

                    Image(
                        modifier = Modifier
                            .size(48.dp),
                        painter = painterResource(id = R.drawable.ic_qrcode),
                        contentDescription = "Qr Code"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = colorResource(id = R.color.color1),
                                shape = RoundedCornerShape(bottomStart = 6.dp, bottomEnd = 6.dp)
                            )
                            .border(
                                width = 2.dp,
                                color = colorResource(id = R.color.color1),
                                shape = RoundedCornerShape(6.dp)
                            ),
                        text = "Profile",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .background(
                            color = colorResource(id = R.color.white),
                            shape = RoundedCornerShape(6.dp)
                        )
                        .clickable {
                            QRCodeGeneratorData.writeLS(context, false)

                            context.startActivity(
                                Intent(
                                    context,
                                    SignInActivity::class.java
                                )
                            )
                            (context as Activity).finish()
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(12.dp))

                    Image(
                        modifier = Modifier
                            .size(48.dp),
                        painter = painterResource(id = R.drawable.ic_qrcode),
                        contentDescription = "Qr Code"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = colorResource(id = R.color.color1),
                                shape = RoundedCornerShape(bottomStart = 6.dp, bottomEnd = 6.dp)
                            )
                            .border(
                                width = 2.dp,
                                color = colorResource(id = R.color.color1),
                                shape = RoundedCornerShape(6.dp)
                            ),
                        text = "Logout",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }
            }

        }

    }
}