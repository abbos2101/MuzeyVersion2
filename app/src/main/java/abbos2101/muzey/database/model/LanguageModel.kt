package abbos2101.muzey.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "language")
data class LanguageModel(
    @PrimaryKey(autoGenerate = true)
    val _id: Int = 0,
    val language_name: String,
    val menu_title: String
)