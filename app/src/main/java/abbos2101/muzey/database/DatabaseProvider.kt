package abbos.uzeu.database

import android.content.Context
import androidx.room.Room

class DatabaseProvider {
    companion object {
        private var instance: MyDatabase? = null
        fun instance(ctx: Context): MyDatabase {
            if (instance == null) {
                val baseName = "muzey.db"
                instance = Room.databaseBuilder(ctx, MyDatabase::class.java, "$baseName")
                    .createFromAsset("$baseName")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }
    }
}