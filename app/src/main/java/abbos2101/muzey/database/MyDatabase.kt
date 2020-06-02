package abbos.uzeu.database

import abbos2101.Stroitelstvo.database.model.*
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        MainModel::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}