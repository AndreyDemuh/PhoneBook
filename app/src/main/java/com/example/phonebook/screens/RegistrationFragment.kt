package com.example.phonebook.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.phonebook.R
import com.example.phonebook.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding
    private val viewModelAuth: AuthorisationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRegistration.setOnClickListener {
            viewModelAuth.registrationUser(
                binding.login.text.toString(),
                binding.password.text.toString(),
                {
                    findNavController().navigate(R.id.action_registrationFragment_to_homeFragment)
                }, {
                    binding.errorText.text = it.toString()
                }
            )
        }
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}