package com.example.demoapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView

class CommentAdapter : RecyclerView.Adapter<CommentAdapter.ItemViewHolder>() {

    private var comments = listOf<CommentModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comentario_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val local = comments[position]
        holder.bind(local)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateComment(newComment: List<CommentModel>) {
        comments = newComment
        // Avisa a lista que houve alteração nos itens e que ela deve recarregar
        notifyDataSetChanged()
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textUserName = view.findViewById<TextView>(R.id.textUserName)
        private val textComentario = view.findViewById<TextView>(R.id.textComentario)
        private val  imageUser = view.findViewById<ImageView>(R.id.imageUser)

        // Receber os dados e exibi-los na tela
        fun bind(comment: CommentModel) {
            textComentario.text = comment.comment

            textComentario.typeface = ResourcesCompat.getFont(itemView.context, R.font.fraunces_extrabold)

        }
    }
}