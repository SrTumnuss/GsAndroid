package comSrTummnuss.com.github.rm92892.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TipsViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    /**
     * Cria uma nova instância do ViewModel especificado (TipsViewModel).
     * Esse método é necessário para passar o contexto da aplicação para o ViewModel.
     *
     * @param modelClass A classe do ViewModel a ser instanciada.
     * @return Uma nova instância do ViewModel.
     * @throws IllegalArgumentException Se a classe do ViewModel não for `TipsViewModel`.
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TipsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TipsViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
