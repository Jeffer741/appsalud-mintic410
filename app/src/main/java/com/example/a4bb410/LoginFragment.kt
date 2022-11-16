package com.example.a4bb410

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a4bb410.databinding.FragmentLoginBinding


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@Suppress("UNREACHABLE_CODE")
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
       return binding.root
    }

    override fun onStart() {
       super.onStart()
        binding.fragmentLoginForgotButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotFragment)
        }

        binding.fragmentLoginLabel2.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
        binding.loginFragmentLoginButtom?.setOnClickListener {
            if (!binding.loginFragmentEmail.text.toString().isValidEmail()){
                binding.loginFragmentEmailLayout.error = "Correo electronico incorrecto"
            } else {
                binding.loginFragmentEmailLayout.error = null
            }

            if (!binding.loginFragmentPassword.text.toString().isValidPassword()){
                binding.loginFragmentPasswordLayout.error = "Contraseña incorrecta"
            } else {
                binding.loginFragmentPasswordLayout.error = null
            }
        }
    }



}