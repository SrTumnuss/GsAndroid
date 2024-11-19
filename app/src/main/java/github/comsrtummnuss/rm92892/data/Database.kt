package comSrTummnuss.com.github.rm92892.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import github.comsrtummnuss.rm92892.model.TipModel


@Database(entities = [TipModel::class], version = 1, exportSchema = false)
abstract class TipDatabase : RoomDatabase() {

    abstract fun tipDao(): TipDao

    companion object {
        @Volatile
        private var INSTANCE: TipDatabase? = null

        fun getDatabase(context: Context): TipDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TipDatabase::class.java,
                    "tips_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}