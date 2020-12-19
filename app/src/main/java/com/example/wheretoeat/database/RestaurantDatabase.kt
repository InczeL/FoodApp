package com.example.wheretoeat.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Restaurant::class , User::class],version = 2)
abstract class RestaurantDatabase :RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao
    companion object{
        @Volatile
        private var INSTANCE : RestaurantDatabase? = null

        fun getDatabese(context: Context): RestaurantDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return  tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RestaurantDatabase::class.java,
                    "restaurant_database"
                ).build()
                INSTANCE = instance
                return  instance
            }
        }
    }
}