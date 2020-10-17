package com.maruiz.picassoexample.presentation.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maruiz.picassoexample.R
import com.maruiz.picassoexample.presentation.extensions.inflate
import com.maruiz.picassoexample.presentation.extensions.loadImage
import com.maruiz.picassoexample.presentation.presentationmodel.BookPresentationModel
import kotlinx.android.synthetic.main.row_book.view.*
import kotlin.properties.Delegates
import kotlin.time.ExperimentalTime
import kotlin.time.TimeSource

class BooksAdapter : RecyclerView.Adapter<BooksAdapter.ViewHolder>() {
    var renderables: List<BookPresentationModel> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    @OptIn(ExperimentalTime::class)
    private val totalMark by lazy { TimeSource.Monotonic.markNow() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.row_book))

    override fun getItemCount(): Int = renderables.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(renderables[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: BookPresentationModel) {
            itemView.image.loadImage(model.image, totalMark)
        }
    }
}