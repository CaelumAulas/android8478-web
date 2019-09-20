package br.com.caelum.twittelumappweb.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.fragment.BuscadorDeTweetsFragment
import br.com.caelum.twittelumappweb.fragment.ListaTweetFragment
import br.com.caelum.twittelumappweb.fragment.MapaFragment
import br.com.caelum.twittelumappweb.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottomNavigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.itemLista -> exibe(ListaTweetFragment())
                R.id.itemBusca -> exibe(BuscadorDeTweetsFragment())
                R.id.itemMapa -> exibe(MapaFragment())
            }

            return@setOnNavigationItemSelectedListener true

        }

        bottomNavigation.selectedItemId = R.id.itemLista

        fab.setOnClickListener {
            startActivity(Intent(this, TweetActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menuSair -> {

                viewModel.desloga()

                finish()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }

        return true
    }

    private fun exibe(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame, fragment)
                .commit()

    }
}

















