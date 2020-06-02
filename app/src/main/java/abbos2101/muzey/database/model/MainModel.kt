package abbos2101.Stroitelstvo.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "content")
data class MainModel(
    @PrimaryKey(autoGenerate = true)
    val _id: Int = 0,
    val language_id: Int,
    val title: String,
    val description: String,
    val item_image: String,
    val data_text: String,
    val data_image: String,
    val data_gallery: String,
    val count_view: Int,
    val count_like: Int,
    val count_dislike: Int
)