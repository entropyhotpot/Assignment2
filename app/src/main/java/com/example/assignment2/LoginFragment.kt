package com.example.assignment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.assignment2.databinding.FragmentLoginBinding
import com.example.assignment2.ui.LoginViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {

    // initialize the binding variable
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    // initialize the view model
    private val loginViewModel: LoginViewModel by viewModels()

    // initialize the snackbar
    private var snackbar: Snackbar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            // Get the username and password from the edit text fields
            val username = binding.loginUsername.editText?.text.toString()
            val password = binding.loginPassword.editText?.text.toString()

            // Dismiss the snackbar if it is showing
            snackbar?.dismiss()
            loginViewModel.login(username, password)
        }

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    loginViewModel.loginResponse.collect { response ->
                        if (response != null && !loginViewModel.hasNavigatedToDashboard) { // Navigate to the dashboard
                            loginViewModel.hasNavigatedToDashboard = true
                            findNavController().navigate(
                                LoginFragmentDirections.actionLoginFragmentToDashboardFragment(
                                    login = response
                                )
                            )
                        }
                    }
                }
                launch {
                    loginViewModel.error.collect { error ->
                        if (error != null) { // Show the error message
                            snackbar = Snackbar.make(binding.root, "Error: $error", Snackbar.LENGTH_LONG)
                            snackbar?.show()
                        }
                    }
                }
            }
        }


    }

    override fun onResume() {
        super.onResume()
        // Reset the navigation state
        loginViewModel.hasNavigatedToDashboard = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}