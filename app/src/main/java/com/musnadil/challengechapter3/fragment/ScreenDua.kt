package com.musnadil.challengechapter3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.musnadil.challengechapter3.databinding.FragmentScreenDuaBinding

class ScreenDua : Fragment() {
    private var _binding : FragmentScreenDuaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentScreenDuaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGoToScreen3.setOnClickListener {
            if (binding.etNama.text.isNullOrEmpty()){
                binding.wrapEtNama.error = "Kolom nama masih kosong"
            }else{
                val hasilPerhitungan = LimasSegiEmpat(
                    binding.etNama.text.toString()
                )
                val actionFragmentDua = ScreenDuaDirections.actionScreenDuaToScreenTiga(hasilPerhitungan)
                findNavController().navigate(actionFragmentDua)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}