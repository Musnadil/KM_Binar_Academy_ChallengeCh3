package com.musnadil.challengechapter3.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.musnadil.challengechapter3.R
import com.musnadil.challengechapter3.databinding.FragmentScreenTigaBinding

class ScreenTiga : Fragment() {
    private var _binding: FragmentScreenTigaBinding? = null
    private val binding get() = _binding!!


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

        val nama = arguments?.getString(ScreenDua.NAMA)
        binding.tvNama.text = nama

        binding.btnGoToScreen4.setOnClickListener {
            val bundle = Bundle().apply {
                putString(ScreenDua.NAMA,nama)
            }
            findNavController().navigate(R.id.action_screenTiga_to_screenEmpat,bundle)
        }

        val hasil = arguments?.getDouble(ScreenEmpat.HASIL).toString()
        val tinggiLimas = arguments?.getString(ScreenEmpat.TINGGI)
        val panjangAlas = arguments?.getString(ScreenEmpat.PANJANG)
        val lebarAlas = arguments?.getString(ScreenEmpat.LEBAR)


        if (hasil != null && tinggiLimas != null && lebarAlas != null && panjangAlas != null) {
            binding.tvPanjangAlas.text = "$panjangAlas cm"
            binding.tvLebarAlas.text = "$lebarAlas cm"
            binding.tvTinggiLimas.text = "$tinggiLimas cm"
            binding.tvHasilPerhitungan.text = "Halo $nama, Hasil perhitungan limas segi empat diatas adalah $hasil cm³"
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