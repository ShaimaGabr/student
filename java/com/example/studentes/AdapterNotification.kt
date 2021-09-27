package com.example.studentes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentes.databinding.NotiItemBinding
import com.example.studentes.databinding.ShowoneattendBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class AdapterNotification (private val dataset:List<notificationModelItem>,val viewModel: ProfileViewModel) :
RecyclerView.Adapter<ViewHol>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHol {
        val inflater = LayoutInflater.from(parent.context)

        val bindi = NotiItemBinding.inflate(inflater, parent, false)

        return ViewHol(bindi)
    }

    override fun onBindViewHolder(holder: ViewHol, position: Int) {
        val movie = dataset[position]
        // viewModel.name(movie.course_id)
        //viewModel.vis.value=movie.course_id


        holder.bindi.notific.text=movie.message


    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
class ViewHol(val bindi: NotiItemBinding) : RecyclerView.ViewHolder(bindi.root) {

}