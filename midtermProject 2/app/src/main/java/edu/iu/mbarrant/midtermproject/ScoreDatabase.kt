package edu.iu.mbarrant.midtermproject

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [User::class], version = 1)
abstract class ScoreDatabase : RoomDatabase() {
//    abstract fun playerScoreDao(): ScoreDao
//
//    abstract val scoreDao : ScoreDao
//    companion object {
//        @Volatile
//        private var INSTANCE: ScoreDatabase? = null
//
//        fun getInstance(context: Context): ScoreDatabase {
//            synchronized(this) {
//                var instance = INSTANCE
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        ScoreDatabase::class.java,
//                        "Score_database" // Change this to your database name
//                    ).build()
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
//    }
}

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val name: String,
    val score: Int // You can use this field to store the user's total guesses
)