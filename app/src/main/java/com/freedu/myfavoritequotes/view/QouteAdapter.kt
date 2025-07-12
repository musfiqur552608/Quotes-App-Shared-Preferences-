package com.freedu.myfavoritequotes.view

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.freedu.myfavoritequotes.R
import com.freedu.myfavoritequotes.model.Quote

class QouteAdapter(
    private val qoutes: MutableList<Quote>,
    private val onClick: (Quote) -> Unit,
    private val onLongClick: (Quote) -> Unit
) : RecyclerView.Adapter<QouteAdapter.QouteViewHolder>() {
    class QouteViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val text:TextView = view.findViewById(R.id.quoteText)
        val author :TextView = view.findViewById(R.id.quoteAuthor)
    }

    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): QouteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_qoute, parent, false)
        return QouteViewHolder(view)
    }

    override fun onBindViewHolder(holder: QouteViewHolder, position: Int) {
        val quote = qoutes[position]
        holder.text.text = quote.text
        holder.author.text = "- ${quote.author}"
        holder.itemView.setOnClickListener { onClick(quote) }
        holder.itemView.setOnLongClickListener {
            onLongClick(quote)
            true
        }
    }

    override fun getItemCount(): Int = qoutes.size

    fun updateQuotes(newQuotes: List<Quote>) {
        qoutes.clear()
        qoutes.addAll(newQuotes)
        notifyDataSetChanged()
    }
}