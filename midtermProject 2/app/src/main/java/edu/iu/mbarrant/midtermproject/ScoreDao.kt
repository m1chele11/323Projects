package edu.iu.mbarrant.midtermproject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface ScoreDao {


    @Query("SELECT * FROM user_table")
    suspend fun getAllPlayerScores(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Delete
    fun delete(user: User)

    @Insert
    suspend fun insert(user: User)

}