package com.example.helpforcleanarchitecture.PhotoFeature.Data.Local.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.helpforcleanarchitecture.PhotoFeature.Data.Local.Dao.PhotoDao
import com.example.helpforcleanarchitecture.PhotoFeature.Data.Local.Entity.PhotoEntity

@Database(entities = [PhotoEntity::class],version = 1)
abstract class PhotoDatabase : RoomDatabase() {
    abstract fun PhotoDao(): PhotoDao

}