package com.example.demoapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.demoapp.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonEntrar2.setOnClickListener {

            val usuario = binding.editUsuario.text.toString()
            val senha = binding.editSenha.text.toString()

            when{
                usuario.isEmpty()->{
                    mensagem(it,"Coloque o seu nome de usuário!")
                }
                senha.isEmpty()->{
                    mensagem(it, "Preencha a senha!")
                }
                senha.length <=5->{
                    mensagem(it, "A senha deve ter mais de 5 caracteres")
                }
                else -> {
                    irParaFeedApp(usuario)
                }
            }
        }

        binding.buttonNaoTenhoCadastro.setOnClickListener {
            irParaCadastro()
        }
    }



    private fun mensagem(view: View, mensagem: String){
        val snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"))
        snackbar.setTextColor(Color.parseColor("FFFFFF"))
        snackbar.show()
    }

    private fun irParaFeedApp(usuario: String){
        val feedApp = Intent(this, Feed_App::class.java)
        intent.putExtra("usuario", usuario)
        startActivity(feedApp)
    }

    private fun irParaCadastro(){
        val novoCadastro = Intent(this,Cadastro::class.java)
        startActivity(novoCadastro)
    }
}