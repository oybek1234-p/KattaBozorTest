package com.example.ui.connection

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.lifecycle.MutableLiveData

//Обсервер для интернета
class ConnectionObserver(activity: Activity) {

    var connectionState = MutableLiveData<NetworkState>()

    private val manager =
        activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private val request: NetworkRequest by lazy {
        NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()
    }

    fun startUpdate() {
        manager.requestNetwork(request, networkCallback)
    }

    fun pauseUpdate() {
        manager.unregisterNetworkCallback(networkCallback)
    }

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {

        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            connectionState.postValue(NetworkState.ACTIVE)
        }

        override fun onCapabilitiesChanged(
            network: Network,
            networkCapabilities: NetworkCapabilities
        ) {
            super.onCapabilitiesChanged(network, networkCapabilities)
            val hasInternet =
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            connectionState.postValue(if (hasInternet) NetworkState.ACTIVE else NetworkState.CONNECTING)
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            connectionState.postValue(NetworkState.LOST)
        }
    }
}