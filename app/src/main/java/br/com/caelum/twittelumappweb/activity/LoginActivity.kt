package br.com.caelum.twittelumappweb.activity

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.modelo.Usuario
import br.com.caelum.twittelumappweb.viewmodel.UsuarioViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel: UsuarioViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        viewModel.getUsuario().observe(this, Observer {

            val vaiParaMain = Intent(this, MainActivity::class.java)
            startActivity(vaiParaMain)
            finish()
        })

        viewModel.getError().observe(this, Observer {
            Toast.makeText(this, "${it?.message}", Toast.LENGTH_LONG).show()
        })


        login_criar.setOnClickListener {

            val usuario = pegaUsuarioDaTela()

            viewModel.criar(usuario)
        }

        login_entrar.setOnClickListener {
            val usuario = pegaUsuarioDaTela()

            viewModel.autenticar(usuario)
        }
    }


    private fun pegaUsuarioDaTela(): Usuario {

        val nome = login_campoNome.text.toString()
        val username = login_campoUsername.text.toString()
        val senha = login_campoSenha.text.toString()


        return Usuario(nome = nome, username = username, senha = senha)
    }
}