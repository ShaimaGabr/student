package com.example.studentes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentes.databinding.ShowoneattendBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class AdapterAttDip(private val dataset:List<DiplomaAttendItem>,val viewModel: ProfileViewModel) :
    RecyclerView.Adapter<ViewHold>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHold {
        val inflater = LayoutInflater.from(parent.context)

        val bindin = ShowoneattendBinding.inflate(inflater, parent, false)

        return ViewHold(bindin)
    }

    override fun onBindViewHolder(holder: ViewHold, position: Int) {
        val movie = dataset[position]
        // viewModel.name(movie.course_id)
        //viewModel.vis.value=movie.course_id
        CoroutineScope(Dispatchers.IO).async {
            val response            =ConnectionAttendance.Retrofit_connection().coursename(movie.course_id)
            CoroutineScope(Dispatchers.Main).async {
                if(response.isSuccessful){
                    holder.bindin.text1.text=response.body()!![0].coursename
                }else{

                }


            }}

        holder.bindin.text2.text=movie.date


    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
class ViewHold(val bindin: ShowoneattendBinding) : RecyclerView.ViewHolder(bindin.root) {

}