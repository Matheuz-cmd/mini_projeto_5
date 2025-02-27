package com.example.projeto_5.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.projeto_5.databinding.DialogDetailsBinding
import com.example.projeto_5.models.ActivityModel

class ActivityDetailsDialog(private val activity: ActivityModel) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DialogDetailsBinding.inflate(inflater, container, false)

        binding.textViewNome.text = activity.nome
        binding.textViewResponsavel.text = activity.responsavel
        binding.textViewData.text = activity.data
        binding.textViewDescricao.text = activity.descricao

        return binding.root
    }
}
