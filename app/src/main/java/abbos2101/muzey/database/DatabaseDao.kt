package abbos.uzeu.database

import abbos2101.Stroitelstvo.database.model.MainModel
import androidx.room.*

@Dao
interface DatabaseDao {
    @Query("select * from content")
    fun loadMainList(): MutableList<MainModel>

    @Query("update content set count_view=:c_view where _id=:id")
    fun setUpCountView(id: Int, c_view: Int)
}