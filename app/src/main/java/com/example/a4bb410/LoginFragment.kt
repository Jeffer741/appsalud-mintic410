package com.example.a4bb410

import android.content.Intent
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
                binding.loginFragmentEmailLayout.error = getString(R.string.email_error)
            } else {
                binding.loginFragmentEmailLayout.error = null
            }

            if (!binding.loginFragmentPassword.text.toString().isValidPassword()){
                binding.loginFragmentPasswordLayout.error = getString(R.string.password_error)
            } else {
                binding.loginFragmentPasswordLayout.error = null
            }

            if (binding.loginFragmentEmail.text.toString().isValidEmail() && binding.loginFragmentPassword.text.toString().isValidPassword()){
                val intent = Intent(requireContext(), HomeActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }

        }
    }



}