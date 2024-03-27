package com.example.retrofitdb.Database;

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class PostDatabase : RoomDatabase(){
    abstract val postDatabaseDAO:PostDatabaseDAO

    companion object{
        @Volatile
        private var INSTANCE: PostDatabase? = null

        fun getInstance(context: Context): PostDatabase {
            var instance = INSTANCE
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    PostDatabase::class.java,
                    name = "user_ids"
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
                INSTANCE = instance
            }
            return instance
        }
    }
}
