package com.example.demoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demoapp.databinding.ActivityFeedAppBinding

class Feed_App : AppCompatActivity() {

    private lateinit var binding: ActivityFeedAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

}