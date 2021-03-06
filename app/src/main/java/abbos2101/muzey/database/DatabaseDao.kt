package abbos.uzeu.database

import abbos2101.Stroitelstvo.database.model.MainModel
import androidx.room.*

@Dao
interface DatabaseDao {
    @Query("select * from content")
    fun loadMainList(): MutableList<MainModel>

    @Update
    fun updateMainList(model: MainModel)
}