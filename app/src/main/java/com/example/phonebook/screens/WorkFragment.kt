package com.example.phonebook.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phonebook.R
import com.example.phonebook.adapter.PhoneBookAdapter
import com.example.phonebook.databinding.FragmentWorkBinding
import com.example.phonebook.repository.AuthorisationRepository
import com.example.phonebook.repository.FirebaseRepository

class WorkFragment : Fragment() {

    private lateinit var binding: FragmentWorkBinding
    private val viewModelAuth: AuthorisationViewModel by viewModels()
    private val authorisationRepository = AuthorisationRepository()
    private val firebaseRepository = FirebaseRepository()
    private lateinit var adapter: PhoneBookAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWorkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PhoneBookAdapter()

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        firebaseRepository.getContact {
            adapter.submitList(it)
        }

        binding.userEmail.text = authorisationRepository.getEmail()

        binding.btnLogout.setOnClickListener {
            viewModelAuth.logout()
            findNavController().navigate(R.id.action_homeFragment_to_logInFragment)
        }
        binding.btnSave.setOnClickListener {
            firebaseRepository.addContact(
                binding.textName.text.toString(),
                binding.textPhoneNumber.text.toString()
            )
        }
    }
}