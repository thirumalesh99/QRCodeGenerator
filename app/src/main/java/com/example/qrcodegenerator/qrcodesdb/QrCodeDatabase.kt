package com.example.qrcodegenerator.qrcodesdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [QrCodeEntity::class], version = 1)
abstract class QrCodeDatabase : RoomDatabase() {
    abstract fun qrCodeDao(): QrCodeDao
}
