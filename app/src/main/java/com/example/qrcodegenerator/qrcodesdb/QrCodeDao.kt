package com.example.qrcodegenerator.qrcodesdb

import androidx.room.OnConflictStrategy

@Dao
interface QrCodeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQrCode(qrCode: QrCodeEntity)

    @Query("SELECT * FROM qr_codes")
    suspend fun getAllQrCodes(): List<QrCodeEntity>
}
