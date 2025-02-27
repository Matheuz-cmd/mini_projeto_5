package com.example.projeto_5

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_5.adapters.ActivityAdapter
import com.example.projeto_5.models.ActivityModel
import com.example.projeto_5.dialogs.ActivityDetailsDialog

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonCadastrar: Button
    private lateinit var editTextNome: EditText
    private lateinit var editTextResponsavel: EditText
    private lateinit var editTextData: EditText
    private lateinit var editTextDescricao: EditText
    private val atividadesList = mutableListOf<ActivityModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewAtividades)
        buttonCadastrar = findViewById(R.id.buttonCadastrar)
        editTextNome = findViewById(R.id.editTextNome)
        editTextResponsavel = findViewById(R.id.editTextResponsavel)
        editTextData = findViewById(R.id.editTextData)
        editTextDescricao = findViewById(R.id.editTextDescricao)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ActivityAdapter(atividadesList) { activity ->
            val dialog = ActivityDetailsDialog(activity)
            dialog.show(supportFragmentManager, "ActivityDetails")
        }

        buttonCadastrar.setOnClickListener {
            val nome = editTextNome.text.toString()
            val responsavel = editTextResponsavel.text.toString()
            val data = editTextData.text.toString()
            val descricao = editTextDescricao.text.toString()

            if (nome.isEmpty() || responsavel.isEmpty() || data.isEmpty() || descricao.isEmpty()) {
                Toast.makeText(this, "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show()
            } else {
                val atividade = ActivityModel(nome, responsavel, data, descricao)
                atividadesList.add(atividade)
                recyclerView.adapter?.notifyDataSetChanged()
            }
        }
    }
}
