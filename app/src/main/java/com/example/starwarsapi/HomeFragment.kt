package com.example.starwarsapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starwarsapi.characters.ui.fragment.CharactersFragment
import com.example.starwarsapi.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.seeMore.setOnClickListener {

            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
                .menu.getItem(1).isChecked = true

            parentFragmentManager.beginTransaction()
                .replace(R.id.rootFragmentContainerView, CharactersFragment())
                .commit()
        }
    }

}