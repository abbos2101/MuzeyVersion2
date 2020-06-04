package abbos2101.Stroitelstvo.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "content")
data class MainModel(
    @PrimaryKey(autoGenerate = true)
    val _id: Int = 0,
    val uz_title: String,
    val uz_description: String,
    val uz_text: String,
    val ru_title: String,
    val ru_description: String,
    val ru_text: String,
    val en_title: String,
    val en_description: String,
    val en_text: String,
    val item_image: String,
    var count_view: Int
)