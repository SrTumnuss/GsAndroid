package comSrTummnuss.com.github.listadecompras

import android.os.Bundle

import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import comSrTummnuss.com.github.rm92892.viewmodel.TipsAdapter
import comSrTummnuss.com.github.rm92892.viewmodel.TipsViewModel
import comSrTummnuss.com.github.rm92892.viewmodel.TipsViewModelFactory


import github.comsrtummnuss.rm92892.R

/**
 * A activity principal da aplicação.
 * Esta activity é responsável por exibir a lista de itens e fornecer uma interface para adicionar novos itens à lista.
 * A activity usa um `ItemsViewModel` para interagir com o banco de dados.
 *
 * @property viewModel O ViewModel usado para interagir com o banco de dados.
 * @author Ewerton Carreira
 * @version 1.0
 * @since 2023-02-01
 */
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: TipsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Dicas de Economia de Energia"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val tipsAdapter = TipsAdapter { tip ->
            Toast.makeText(this, "Detalhes: ${tip.description}", Toast.LENGTH_SHORT).show()
            // Ou abrir um link com mais detalhes:
            // val intent = Intent(Intent.ACTION_VIEW, Uri.parse(tip.link))
            // startActivity(intent)
        }
        recyclerView.adapter = tipsAdapter

        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Realizar pesquisa e atualizar RecyclerView
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Atualizar a lista com as dicas filtradas
                return false
            }
        })

        val viewModelFactory = TipsViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(TipsViewModel::class.java)

        viewModel.tipsLiveData.observe(this) { tips ->
            tipsAdapter.updateTips(tips)
        }
    }
}
