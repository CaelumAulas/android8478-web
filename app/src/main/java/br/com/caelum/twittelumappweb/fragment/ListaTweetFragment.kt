package br.com.caelum.twittelumappweb.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.adapter.TweetAdapter
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import kotlinx.android.synthetic.main.fragment_lista_tweets.view.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class ListaTweetFragment : Fragment() {

    private val viewModel: TweetViewModel by sharedViewModel()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

        viewModel.buscaTweets()

        val view = inflater.inflate(R.layout.fragment_lista_tweets, container, false)


        view.swipe.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_purple,
                android.R.color.holo_red_light
        )

        view.swipe.setOnRefreshListener {

            viewModel.buscaTweets()

        }


        viewModel.getTweets().observe(this, Observer { tweets ->

            view.swipe.isRefreshing = false

            tweets?.let {
                view.listaTweets.adapter = TweetAdapter(it)
            }
        })



        return view
    }

}