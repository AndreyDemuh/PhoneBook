package com.example.phonebook.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.phonebook.R
import com.example.phonebook.databinding.FragmentStartBinding
import com.example.phonebook.repository.AuthorisationRepository

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    private val authorisationRepository = AuthorisationRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEnter.setOnClickListener {
            if (authorisationRepository.isUserLogin()) {
                findNavController().navigate(R.id.action_startFragment_to_homeFragment)
            } else {
                findNavController().navigate(R.id.action_startFragment_to_logInFragment)
            }
        }
    }
}

