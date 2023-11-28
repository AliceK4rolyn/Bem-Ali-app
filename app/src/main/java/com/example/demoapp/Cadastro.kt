package com.example.demoapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.demoapp.databinding.ActivityCadastroBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class Cadastro : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCadastrar2.setOnClickListener {view->

            val nome = binding.editNome.text.toString()
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if(email.isEmpty() || senha.isEmpty()){
                val snackbar = Snackbar.make(view, "Preencha todos os campos", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }else{
                auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener { cadastro ->
                    if(cadastro.isSuccessful){
                        val snackbar = Snackbar.make(view, "Cadastro reallizado com sucesso", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.BLUE)
                        snackbar.show()
                    }
                }.addOnFailureListener{

                }
            }
        }

//        binding.buttonCadastrar2.setOnClickListener {
//
//            val usuario = binding.editNome.text.toString()
//            val email = binding.editEmail.text.toString()
//            val senha = binding.editSenha.text.toString()
//
//
//            when{
//                usuario.isEmpty() -> {
//                    mensagem(it,"Coloque o seu nome de usuário!")
//                }email.isEmpty() -> {
//                    mensagem(it, "Preencha o email")
//                }senha.isEmpty() -> {
//                    mensagem(it, "Preencha a senha!")
//                }senha.length <=5 -> {
//                    mensagem(it, "A senha deve ter mais de 5 caracteres")
//                }else -> {
//                        irParaFeedApp(usuario)
//                }
//            }
//        }

        binding.buttonJaTenhoCadastro.setOnClickListener{
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