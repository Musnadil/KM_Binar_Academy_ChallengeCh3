package com.musnadil.challengechapter3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.musnadil.challengechapter3.R
import com.musnadil.challengechapter3.databinding.FragmentScreenSatuBinding

class ScreenSatu : Fragment() {
    private var _binding : FragmentScreenSatuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentScreenSatuBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGoToScreen2.setOnClickListener {
            findNavController().navigate(R.id.action_screenSatu_to_screenDua)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}