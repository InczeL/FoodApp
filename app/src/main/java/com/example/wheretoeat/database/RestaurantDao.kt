package com.example.wheretoeat.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RestaurantDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRestaurant(restaurant : Restaurant)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addUser(user : User)

    /*@Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addUserRestaurantCrossRef(userRestaurantCrossRef: UserRestaurantCrossRef)*/

   /*@Transaction
    @Query("SELECT * FROM user_table WHERE name = :userName")
    suspend fun getFavorits(userName :String):LiveData<List<UserRestaurants>>*/

    /*@Transaction
    @Query("SELECT * FROM user_table WHERE name = :userName")
    suspend fun getUser(userName :String): LiveData<User>*/
}