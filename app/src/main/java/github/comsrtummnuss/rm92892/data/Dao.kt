package comSrTummnuss.com.github.rm92892.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import github.comsrtummnuss.rm92892.model.TipModel


@Dao
interface TipDao {
    @Insert
    suspend fun insert(tip: TipModel): Long // Retorna o ID do novo item inserido

    @Query("SELECT * FROM tips")
    fun getAllTips(): LiveData<List<TipModel>> // Retorna LiveData
}