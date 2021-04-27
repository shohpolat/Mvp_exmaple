package com.eres.mvpexample2.ui.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eres.kutubxonasample.model.ResponseData
import com.eres.kutubxonasample.model.SingleDate
import com.eres.mvpexample2.databinding.SingleBookBinding
import com.eres.mvpexample2.model.Timings

class DatesAdapter(val list: List<ResponseData>) :
    RecyclerView.Adapter<DatesAdapter.ViewHolder>() {

    lateinit var listener: OnItemClickListener

    inner class ViewHolder(val view: SingleBookBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(index: Int) {
            val currentBook = list[index]
            view.apply {

                name.text = currentBook.singleDate?.date

                view.root.setOnClickListener {
                    if (currentBook.singleDate?.timestamp != null) {
                        listener.onClick(currentBook.singleDate.timestamp,currentBook.singleDate.date!!)
                    }
                }

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = SingleBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        view.root.layoutParams.height = parent.resources.displayMetrics.heightPixels / 15
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickListener {
        fun onClick(timestamp: String,date:String)
    }

    fun setOnClickListener(onItemClickListener: OnItemClickListener) {
        this.listener = onItemClickListener
    }

}