package com.rensystem.a04_androidintermedio.ui.horoscope

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.rensystem.a04_androidintermedio.databinding.FragmentHoroscopeBinding
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo.*
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeModel
import com.rensystem.a04_androidintermedio.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()//se conecta el fragmnt con el viewmodel
    private lateinit var horoscopeAdapter: HoroscopeAdapter

    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initSetUpRVList()
        initUIState()
    }

    private fun initSetUpRVList() {
        horoscopeAdapter = HoroscopeAdapter() { onItemSelectedMe(it) }

        binding.rvHoroscope.apply {
//            layoutManager = LinearLayoutManager(requireContext())....o (context)
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = horoscopeAdapter
        }

    }

    private fun onItemSelectedMe(horoscopeInfo: HoroscopeInfo) {
//        Toast.makeText(context, getString(horoscopeInfo.name), Toast.LENGTH_LONG).show()
        val type = when(horoscopeInfo){
            Aquarius -> HoroscopeModel.Aquarius
            Aries -> HoroscopeModel.Aries
            Cancer -> HoroscopeModel.Cancer
            Capricorn -> HoroscopeModel.Capricorn
            Gemini -> HoroscopeModel.Gemini
            Leo -> HoroscopeModel.Leo
            Libra -> HoroscopeModel.Libra
            Pisces -> HoroscopeModel.Pisces
            Sagittarius -> HoroscopeModel.Sagittarius
            Scorpio -> HoroscopeModel.Scorpio
            Taurus -> HoroscopeModel.Taurus
            Virgo -> HoroscopeModel.Virgo
        }
        findNavController().navigate(
            //Se agrega el argumento
            HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(type)
        )
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                //Nos suscribimos al STATEFLOW
                horoscopeViewModel.horoscope.collect() {
                    //Siempre se que modifique el valor de ViewModel se llama a esto
                    Log.i("Renato", it.toString())
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}