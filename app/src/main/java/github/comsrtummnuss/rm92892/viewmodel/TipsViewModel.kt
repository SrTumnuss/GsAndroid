package comSrTummnuss.com.github.rm92892.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import comSrTummnuss.com.github.rm92892.data.TipDao
import comSrTummnuss.com.github.rm92892.data.TipDatabase
import github.comsrtummnuss.rm92892.model.TipModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TipsViewModel(application: Application) : AndroidViewModel(application) {

    private val tipDao: TipDao
    val tipsLiveData: LiveData<List<TipModel>>

    init {
        val database = TipDatabase.getDatabase(application)
        tipDao = database.tipDao()
        tipsLiveData = tipDao.getAllTips()
    }

    fun addTip(title: String, description: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val newTip = TipModel(title = title, description = description)
            tipDao.insert(newTip) // Chama o insert, sem retorno esperado
        }
    }
}