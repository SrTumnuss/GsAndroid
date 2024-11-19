package comSrTummnuss.com.github.rm92892.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import github.comsrtummnuss.rm92892.R
import github.comsrtummnuss.rm92892.model.TipModel

class TipsAdapter(private val onItemClicked: (TipModel) -> Unit) :
    RecyclerView.Adapter<TipsAdapter.TipViewHolder>() {

    private var tips = listOf<TipModel>()

    inner class TipViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView = view.findViewById<TextView>(R.id.textViewTitle)
        val descriptionTextView = view.findViewById<TextView>(R.id.textViewDescription)

        fun bind(tip: TipModel) {
            titleTextView.text = tip.title
            descriptionTextView.text = tip.description
            itemView.setOnClickListener { onItemClicked(tip) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(view)
    }

    override fun getItemCount(): Int = tips.size

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tips[position]
        holder.bind(tip)
    }

    fun updateTips(newTips: List<TipModel>) {
        tips = newTips
        notifyDataSetChanged()
    }
}
