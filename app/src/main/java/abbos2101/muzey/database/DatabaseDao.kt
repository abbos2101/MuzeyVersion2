package abbos.uzeu.database

import abbos2101.Stroitelstvo.database.model.MainModel
import androidx.room.*

@Dao
interface DatabaseDao {
    @Query("select * from content where language_id=:lang_id")
    fun loadMainList(lang_id: Int): MutableList<MainModel>
}