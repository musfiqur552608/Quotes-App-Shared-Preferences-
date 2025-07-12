package com.freedu.myfavoritequotes.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.freedu.myfavoritequotes.R
import com.freedu.myfavoritequotes.databinding.ActivityMainBinding
import com.freedu.myfavoritequotes.model.Quote
import com.freedu.myfavoritequotes.viewmodel.QouteViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: QouteViewModel by viewModels()
    private lateinit var adapter: QouteAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = QouteAdapter(
            mutableListOf(),
            onClick = {
                Toast.makeText(this, "\"${it.text}\" by ${it.author}", Toast.LENGTH_SHORT).show()
            },
            onLongClick = {
                AlertDialog.Builder(this)
                    .setTitle("Delete Quote")
                    .setMessage("Are you sure you want to delete this quote?")
                    .setPositiveButton("Delete") { _, _ -> viewModel.deleteQuote(it) }
                    .setNegativeButton("Cancel", null)
                    .show()
            }
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        viewModel.qoutes.observe(this, Observer {
            adapter.updateQuotes(it)
        })

        binding.fab.setOnClickListener {
            showAddQouteDialog()
        }
    }

    private fun showAddQouteDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Add Quote")

        val view = layoutInflater.inflate(R.layout.dialog_add_quote, null)
        builder.setView(view)

        val quoteEditText = view.findViewById<android.widget.EditText>(R.id.inputQuote)
        val authorEditText = view.findViewById<android.widget.EditText>(R.id.inputAuthor)

        builder.setPositiveButton("Add") { _, _ ->
            val quote = quoteEditText.text.toString()
            val author = authorEditText.text.toString()
            if(quote.isNotEmpty() && author.isNotEmpty()) {
                viewModel.addQuote(Quote(text = quote, author = author))
            }
        }

        builder.setNegativeButton("Cancel", null)

        builder.show()
    }
}