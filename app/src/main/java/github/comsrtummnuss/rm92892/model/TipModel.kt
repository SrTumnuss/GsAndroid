package github.comsrtummnuss.rm92892.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tips") // Nome da tabela no banco de dados
data class TipModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String
)