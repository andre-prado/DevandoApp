package br.com.andreprado.devandoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class LivroAdapter(
    val livros: List<Livro>,
    val onClick: (Livro) -> Unit): RecyclerView.Adapter<LivroAdapter.LivrosViewHolder>() {

    class LivrosViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImg: ImageView
        var cardProgress: ProgressBar
        var cardView: CardView

        init {
            cardNome = view.findViewById(R.id.cardNome)
            cardImg = view.findViewById(R.id.cardImg)
            cardProgress = view.findViewById(R.id.cardProgress)
            cardView = view.findViewById(R.id.card_livros)
        }
    }

    override fun getItemCount() = this.livros.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivrosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_livro,
            parent, false)

        val holder = LivrosViewHolder(view)

        return holder
    }

    override fun onBindViewHolder(holder: LivrosViewHolder, posicao: Int) {
        val livro = this.livros[posicao]

        holder.cardNome.text = livro.titulo
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(holder.itemView.context).load(livro.foto).fit().into(holder.cardImg,
            object: com.squareup.picasso.Callback {
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            })

        holder.itemView.setOnClickListener {onClick(livro)}
    }
}