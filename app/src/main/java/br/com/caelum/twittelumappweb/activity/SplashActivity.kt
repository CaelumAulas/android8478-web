package br.com.caelum.twittelumappweb.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.viewmodel.SplashViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            var intent = Intent(this, LoginActivity::class.java)

            if (viewModel.estaLogado()) {
                intent = Intent(this, MainActivity::class.java)
            }

            startActivity(intent)
            finish()
        }, 1000)
    }
}