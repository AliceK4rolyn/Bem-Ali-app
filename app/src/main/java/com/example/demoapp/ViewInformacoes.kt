package com.example.demoapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoapp.databinding.ActivityViewInformacoesBinding

class ViewInformacoes : AppCompatActivity() {

    private lateinit var binding: ActivityViewInformacoesBinding

    private val viewModel: CommentViewModel by viewModels {
        CommentsViewModelFactory(applicationContext)
    }

    private val commentAdapter = CommentAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewInformacoesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView = binding.recyclerView
        recyclerView.adapter = commentAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        viewModel.commentLiveData.observe(this) { items ->
            commentAdapter.updateComment(items)
        }

        binding.textComoChegar.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/PZxMtQvFdhwz2BVQ6"))
            startActivity(i)
        }

        binding.buttonAddCom.setOnClickListener {
            salvar(binding.textAdicionar.text.toString())
            binding.textAdicionar.text.clear()

        }
        binding.buttonHome.setOnClickListener {
            irParaInicio()
        }

        binding.buttonFavoritos.setOnClickListener {
            irParaFavoritos()
        }

        binding.buttonPerfil.setOnClickListener {
            irParaPerfil()
        }

    }

    private fun irParaInicio(){
        val inicio = Intent(this, Feed_App::class.java)
        startActivity(inicio)
    }

    private fun irParaFavoritos(){
        val irFavoritos = Intent(this,Favoritos::class.java)
        startActivity(irFavoritos)
    }

    private fun irParaPerfil(){
        val irPerfil = Intent(this, Perfil::class.java)
        startActivity(irPerfil)
    }

    private fun salvar(comment: String) {
        viewModel.addItem(comment)
    }
}


