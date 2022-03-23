package com.musnadil.challengechapter3.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.musnadil.challengechapter3.R
import com.musnadil.challengechapter3.databinding.FragmentScreenTigaBinding

class ScreenTiga : Fragment() {
    private var _binding: FragmentScreenTigaBinding? = null
    private val binding get() = _binding!!

    val args: ScreenTigaArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentScreenTigaBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nama = args.recieveResult?.nama.toString()
        binding.tvNama.text = nama

        binding.btnGoToScreen4.setOnClickListener {
            val actionToFragmentScreenEmpat =
                ScreenTigaDirections.actionScreenTigaToScreenEmpat(nama)
            findNavController().navigate(actionToFragmentScreenEmpat)
        }

        val hasil = args.recieveResult?.hasil
        val tinggiLimas = args.recieveResult?.tinggiLimas
        val panjangAlas = args.recieveResult?.panjangAlas
        val lebarAlas = args.recieveResult?.lebarAlas


        if (hasil != null && tinggiLimas != null && lebarAlas != null && panjangAlas != null) {
            binding.tvPanjangAlas.text = "$panjangAlas cm"
            binding.tvLebarAlas.text = "$lebarAlas cm"
            binding.tvTinggiLimas.text = "$tinggiLimas cm"
            binding.tvHasilPerhitungan.text =
                "Halo $nama, Hasil perhitungan limas segi empat diatas adalah $hasil cm³"
            binding.tvNama.text = null
            binding.btnGoToScreen4.visibility = View.GONE
        } else {
            binding.tvNama.text = "Selamat Datang $nama"
            binding.imgLimas.background = null
            binding.tvHasilPerhitungan.visibility = View.GONE
            binding.tvPanjangAlas.visibility = View.GONE
            binding.tvLebarAlas.visibility = View.GONE
            binding.tvTinggiLimas.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}