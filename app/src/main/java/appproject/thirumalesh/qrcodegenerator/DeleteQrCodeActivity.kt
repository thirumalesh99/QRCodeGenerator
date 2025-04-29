package appproject.thirumalesh.qrcodegenerator

import android.app.Activity
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import appproject.thirumalesh.qrcodegenerator.qrcodedatabase.QrCodeDatabase
import appproject.thirumalesh.qrcodegenerator.qrcodedatabase.QrCodeEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DeleteQrCodeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeleteQRCode(this)
        }
    }
}

@Composable
fun DeleteQRCode(context: Context = LocalContext.current) {
    val qrCodeList = remember { mutableStateListOf<QrCodeEntity>() }

    LaunchedEffect(Unit) {
        val db = QrCodeDatabase.getDatabase(context)
        val data = withContext(Dispatchers.IO) {
            db.qrCodeDao().getAllQrCodes()
        }
        qrCodeList.addAll(data)
    }

    fun deleteQrCode(qrCode: QrCodeEntity) {
        val db = QrCodeDatabase.getDatabase(context)
        CoroutineScope(Dispatchers.IO).launch {
            db.qrCodeDao().deleteQrCode(qrCode)
            withContext(Dispatchers.Main) {
                qrCodeList.remove(qrCode)
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(WindowInsets.systemBars.asPaddingValues())) {
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
            modifier = Modifier.fillMaxWidth(),
            text = "Saved QR Codes",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall.copy(
                color = colorResource(id = R.color.color1),
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "List of QR Codes you saved",
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
            if (qrCodeList.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    items(qrCodeList) { qrCode ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                val bitmap = BitmapFactory.decodeByteArray(
                                    qrCode.image,
                                    0,
                                    qrCode.image.size
                                )
                                Image(
                                    bitmap = bitmap.asImageBitmap(),
                                    contentDescription = null,
                                    modifier = Modifier.size(150.dp)
                                )

                                Spacer(modifier = Modifier.width(12.dp))

                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = "Content: ${qrCode.content}",
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(text = "Type: ${qrCode.type}")
                                }

                                IconButton(onClick = { deleteQrCode(qrCode) }) {
                                    Icon(
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = "Delete QR Code",
                                        tint = Color.Red
                                    )
                                }
                            }
                        }
                    }
                }
            } else {
                Text(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth(),
                    text = "No Qr Code Saved",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

