package com.example.phonebook.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.phonebook.R
import com.example.phonebook.databinding.FragmentLoginBinding

class LogInFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: AuthorisationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            viewModel.logInUser(
                binding.login.text.toString(),
                binding.password.text.toString(), {
                    findNavController().navigate(R.id.action_logInFragment_to_homeFragment)
                }) {
                binding.errorText.text = it.toString()
            }
        }

        binding.btnRegistration.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_registrationFragment)
        }
    }
}
