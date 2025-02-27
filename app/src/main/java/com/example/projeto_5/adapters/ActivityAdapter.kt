package com.example.projeto_5.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_5.databinding.ItemActivityBinding
import com.example.projeto_5.models.ActivityModel

class ActivityAdapter(private val activities: List<ActivityModel>, private val onClick: (ActivityModel) -> Unit) : RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        // Use o ViewBinding para inflar o layout
        val binding = ItemActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActivityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val activity = activities[position]
        holder.bind(activity)
        holder.itemView.setOnClickListener {
            onClick(activity)
        }
    }

    override fun getItemCount() = activities.size

    inner class ActivityViewHolder(private val binding: ItemActivityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(activity: ActivityModel) {
            // Usando o binding para configurar as views
            binding.textViewNome.text = activity.nome
            binding.textViewResponsavel.text = activity.responsavel
            binding.textViewData.text = activity.data
        }
    }
}

