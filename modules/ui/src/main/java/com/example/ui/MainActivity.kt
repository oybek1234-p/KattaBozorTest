package com.example.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.ui.connection.ConnectionObserver
import com.example.ui.connection.NetworkState
import com.example.ui.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    @Inject
    lateinit var connectionObserver: ConnectionObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navigation_graph) as NavHostFragment

        connectionObserver.startUpdate()
        connectionObserver.connectionState.observeForever {
            updateConnectionView(it)
        }
    }

    private fun updateConnectionView(networkState: NetworkState) {
        //Показать статус интернета
    }
}