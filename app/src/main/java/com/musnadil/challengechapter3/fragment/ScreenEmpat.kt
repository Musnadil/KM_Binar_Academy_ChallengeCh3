package com.musnadil.challengechapter3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.musnadil.challengechapter3.RumusLimas
import com.musnadil.challengechapter3.databinding.FragmentScreenEmpatBinding

class ScreenEmpat : Fragment() {
    private var _binding: FragmentScreenEmpatBinding? = null
    private val binding get() = _binding!!
    val args:ScreenEmpatArgs by navArgs()


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
                val nama = args.recieveNama
                val hasil = RumusLimas().limasSegiEmpat(
                    binding.etPanjangAlas.text.toString().toDouble(),
                    binding.etLebarAlas.text.toString().toDouble(),
                    binding.etTinggiLimas.text.toString().toDouble()
                )
                val dataLimas = LimasSegiEmpat(
                    nama,
                    hasil,
                    binding.etPanjangAlas.text.toString(),
                    binding.etLebarAlas.text.toString(),
                    binding.etTinggiLimas.text.toString()
                )

                val actionToFragmentScreenTiga = ScreenEmpatDirections.actionScreenEmpatToScreenTiga(dataLimas)
                findNavController().navigate(actionToFragmentScreenTiga)
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
