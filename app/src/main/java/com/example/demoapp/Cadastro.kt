package com.example.demoapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.demoapp.databinding.ActivityCadastroBinding
import com.google.android.material.snackbar.Snackbar

class Cadastro : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCadastrar2.setOnClickListener {

            val usuario = binding.editTextUsuario.text.toString()
            val senha = binding.editTextSenha.text.toString()
            val email = binding.editEmail.toString()

            when{
                usuario.isEmpty() -> {
                    mensagem(it,"Coloque o seu nome de usuário!")
                }senha.isEmpty() -> {
                    mensagem(it, "Preencha a senha!")
                }email.isEmpty() -> {
                    mensagem(it, "Preencha o email")
                }senha.length <=5 -> {
                    mensagem(it, "A senha deve ter mais de 5 caracteres")
                }else -> {
                    irParaFeedApp(usuario)
                }
            }
        }
        binding.buttonJaTenhoCadastro.setOnClickListener {
            irParaLogin()
        }
    }

    private fun mensagem(view: View, mensagem: String){
        val snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#ff0000"))
        snackbar.setTextColor(Color.parseColor("#FFFFFFFF"))
        snackbar.show()
    }

    private fun irParaFeedApp(usuario: String){
        val feedApp = Intent(this, Feed_App::class.java)
        intent.putExtra("usuario", usuario)
        startActivity(feedApp)
    }

    private fun irParaLogin(){
        val temCadastro = Intent(this,Login::class.java)
        startActivity(temCadastro)
    }

}