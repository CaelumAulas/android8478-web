package br.com.caelum.twittelumappweb.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.SearchView
import android.view.*
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.adapter.TweetAdapter
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import kotlinx.android.synthetic.main.fragment_lista_tweets.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class BuscadorDeTweetsFragment : Fragment() {

    private val viewModel: TweetViewModel by sharedViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_lista_tweets, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_buscar_fragment, menu)

        val itemBusca = menu.findItem(R.id.menuBusca)

        val searchView = itemBusca.actionView as SearchView


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(texto: String): Boolean = true
            override fun onQueryTextChange(texto: String): Boolean {

                val tweets = viewModel.filtraTweets(texto)

                listaTweets.adapter = TweetAdapter(tweets)

                return true
            }
        })

    }


}