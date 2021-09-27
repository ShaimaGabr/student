package com.example.studentes

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.studentes.databinding.CorseitemBinding
import com.example.studentes.databinding.ShowoneattendBinding

class coursesAdapter ( private val movies: List<ModelnameItem>,val viewModel: ProfileViewModel,val context: Context): RecyclerView.Adapter<MainViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = CorseitemBinding.inflate(inflater, parent, false)

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]

        holder.binding.nam.text=movie.coursename
        holder.binding.linear.setOnClickListener {

            //Toast.makeText(context,movie.id,Toast.LENGTH_SHORT).show()
            viewModel.img.value=null
            viewModel. selectattcourse(movie.id,context)
        }


    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

class MainViewHolder(val binding: CorseitemBinding) : RecyclerView.ViewHolder(binding.root) {

}