package br.com.caelum.twittelumappweb.gps

import android.content.Context
import android.location.Location
import com.google.android.gms.location.*

class GPS(context: Context) : LocationCallback() {

    private val client: FusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(context)

    private var localizacao: Location? = null


    fun fazBusca() {

        val requisicao = LocationRequest()

        requisicao.apply {
            smallestDisplacement = 10.0F
            interval = 1000 * 10
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }


        client.requestLocationUpdates(requisicao, this, null)
    }


    override fun onLocationResult(result: LocationResult) {

        localizacao = result.lastLocation
    }

    fun getCoordenadas(): Pair<Double, Double> {

        val latitude = localizacao?.latitude ?: 0.0
        val longitude = localizacao?.longitude ?: 0.0

        return Pair(latitude, longitude)

    }
}