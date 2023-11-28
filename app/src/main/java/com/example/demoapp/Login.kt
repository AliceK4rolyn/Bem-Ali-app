package com.example.demoapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.demoapp.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonEntrar2.setOnClickListener {view ->

            val email = binding.editUsuario.text.toString()
            val senha = binding.editSenha.text.toString()

           if(email.isEmpty() || senha.isEmpty()){
               val snackbar = Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_SHORT)
               snackbar.setBackgroundTint(Color.RED)
               snackbar.show()
           }else{
               auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener {autenticacao ->
                   if(autenticacao.isSuccessful){
                       irParaFeedApp()
                   }
               }.addOnFailureListener{
                   val snackbar = Snackbar.make(view, "Erro no login", Snackbar.LENGTH_SHORT)
                   snackbar.setBackgroundTint(Color.RED)
                   snackbar.show()
               }
           }
        }

        binding.buttonNaoTenhoCadastro.setOnClickListener {
            irParaCadastro()
        }
    }

    private fun irParaFeedApp(){
        val feedApp = Intent(this, Feed_App::class.java)
        startActivity(feedApp)
    }

    private fun irParaCadastro(){
        val novoCadastro = Intent(this,Cadastro::class.java)
        startActivity(novoCadastro)
    }

    override fun onStart() {
        super.onStart()

        val usuarioAtual = FirebaseAuth.getInstance().currentUser

        if(usuarioAtual != null){
            irParaFeedApp()
        }
    }
}