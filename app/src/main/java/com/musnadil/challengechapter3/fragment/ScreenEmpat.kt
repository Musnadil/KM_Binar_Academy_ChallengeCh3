package com.musnadil.challengechapter3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.musnadil.challengechapter3.R
import com.musnadil.challengechapter3.RumusLimas
import com.musnadil.challengechapter3.databinding.FragmentScreenEmpatBinding

class ScreenEmpat : Fragment() {
    private var _binding: FragmentScreenEmpatBinding? = null
    private val binding get() = _binding!!


    companion object {
        const val HASIL = "HASIL PERHITUNGAN LIMAS"
        const val PANJANG = "PANJANG_ALAS"
        const val LEBAR = "LEBAR_ALAS"
        const val TINGGI = "TINGGI_LIMAS"

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentScreenEmpatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBackToScreen3.setOnClickListener {
            if (binding.etPanjangAlas.text.isNullOrEmpty()) {
                binding.wrapEtPanjangAlas.error = "Kolom panjang alas harus diisi"
            } else if (binding.etLebarAlas.text.isNullOrEmpty()) {
                binding.wrapEtLebarAlas.error = "Kolom lebar alas harus diisi"
            } else if (binding.etTinggiLimas.text.isNullOrEmpty()) {
                binding.wrapEtTinggiLimas.error = "Kolom tinggi limas harus diisi"
            } else {
                val nama = arguments?.getString(ScreenDua.NAMA)
                val rumus = RumusLimas()
                val hasil = rumus.limasSegiEmpat(
                    binding.etPanjangAlas.text.toString().toDouble(),
                    binding.etLebarAlas.text.toString().toDouble(),
                    binding.etTinggiLimas.text.toString().toDouble()
                )

                val bundleScreenEmpat = Bundle().apply {
                    putDouble(HASIL, hasil)
                    putString(PANJANG, binding.etPanjangAlas.text.toString())
                    putString(LEBAR, binding.etLebarAlas.text.toString())
                    putString(TINGGI, binding.etTinggiLimas.text.toString())
                    putString(ScreenDua.NAMA, nama)

                }
                findNavController().navigate(
                    R.id.action_screenEmpat_to_screenTiga,
                    bundleScreenEmpat
                )
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
