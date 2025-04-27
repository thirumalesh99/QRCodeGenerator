package appproject.thirumalesh.qrcodegenerator

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class UserProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserProfileScreen()
        }
    }
}

@Composable
fun UserProfileScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .padding(12.dp)
                .size(36.dp)
                .clickable {
                    (context as Activity).finish()
                },
            painter = painterResource(id = R.drawable.baseline_arrow_back_36),
            contentDescription = "Qr Code"
        )

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "User Profile",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall.copy(
                color = colorResource(id = R.color.color1),
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Your account details",
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

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "User Name\n${QRCodeGeneratorData.readUserName(context)}",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleSmall.copy(
                    color = colorResource(id = R.color.color1),
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "User Email\n${QRCodeGeneratorData.readMail(context)}",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleSmall.copy(
                    color = colorResource(id = R.color.color1),
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}