package com.rensystem.a04_androidintermedio.ui.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavArgs
import androidx.navigation.navArgs
import com.rensystem.a04_androidintermedio.R
import com.rensystem.a04_androidintermedio.databinding.ActivityHoroscopeDetailBinding
import com.rensystem.a04_androidintermedio.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding

    private val horocopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    private val argsReceived: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        argsReceived.type
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horocopeDetailViewModel.state.collect() {
                    when (it) {
                        is HoroscopeDetailState.Error -> errorState()
                        HoroscopeDetailState.Loading -> loadingState()

                        is HoroscopeDetailState.Success -> successState()
                    }
                }
            }
        }
    }

    private fun errorState() {
        TODO("Not yet implemented")
    }

    private fun successState() {
        TODO("Not yet implemented")
    }

    private fun loadingState() {
        binding.progressBar.isVisible = true
    }




}



