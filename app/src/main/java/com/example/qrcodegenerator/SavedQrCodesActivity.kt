package com.example.qrcodegenerator

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.qrcodegenerator.qrcodesdb.QrCodeDatabase
import com.example.qrcodegenerator.qrcodesdb.QrCodeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SavedQrCodesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SavedQrCodesScreen()
        }
    }
}

@Composable
fun SavedQrCodesScreen(context: Context = LocalContext.current) {
    val qrCodeList = remember { mutableStateListOf<QrCodeEntity>() }

    LaunchedEffect(Unit) {
        val db = Room.databaseBuilder(
            context,
            QrCodeDatabase::class.java,
            "qr_code_db"
        ).build()

        val data = withContext(Dispatchers.IO) {
            db.qrCodeDao().getAllQrCodes()
        }

        qrCodeList.addAll(data)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(qrCodeList.size) { qr ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Content: ${qrCodeList[qr].content}", fontWeight = FontWeight.Bold)
                    Text(text = "Type: ${qrCodeList[qr].type}")
                    Spacer(modifier = Modifier.height(8.dp))

                    val bitmap = BitmapFactory.decodeByteArray(qrCodeList[qr].image, 0, qrCodeList[qr].image.size)
                    Image(
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier.size(150.dp)
                    )
                }
            }
        }
    }
}
