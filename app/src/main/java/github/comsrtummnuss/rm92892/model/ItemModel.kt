package comSrTummnuss.com.github.rm92892.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ItemModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String
)
