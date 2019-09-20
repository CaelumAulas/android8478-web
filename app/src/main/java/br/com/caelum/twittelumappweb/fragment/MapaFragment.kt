package br.com.caelum.twittelumappweb.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.android.viewmodel.ext.android.sharedViewModel

class MapaFragment : SupportMapFragment() {


    private val viewModel: TweetViewModel by sharedViewModel()


    override fun onResume() {
        super.onResume()

        getMapAsync { map: GoogleMap ->

            viewModel.getTweets().observe(this, Observer { tweets ->

                tweets?.let {

                    tweets.forEach { tweet ->


                        val marcador = MarkerOptions()
                        val latLng = LatLng(tweet.latitude, tweet.longitude)
                        marcador.position(latLng)

                        marcador.title(tweet.usuario.nome)
                        marcador.snippet(tweet.mensagem)


                        map.addMarker(marcador)
                    }


                }

            })


        }
    }

}