package com.example.demoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demoapp.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonCadastrar.setOnClickListener{

            IrParaCadastro()

        }

        binding.buttonEntrar.setOnClickListener{
            IrParaLogin()
        }

        binding.
    }


    private fun IrParaCadastro(){

        val tela_cadastro = Intent(this, Cadastro::class.java)

        startActivity(tela_cadastro)
    }

    private fun IrParaLogin(){
        val tela_login = Intent(this, Login::class.java)
        startActivity(tela_login)
    }
}