package com.example.a4bb410

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.example.a4bb410.databinding.FragmentSignUpBinding
import com.example.a4bb410.databinding.FragmentSpecialistBinding


/**
 * A simple [Fragment] subclass.
 * Use the [SpecialistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpecialistFragment : Fragment() {

    private var _binding: FragmentSpecialistBinding? = null
    private val binding: FragmentSpecialistBinding get() = _binding!!
    private val args: SpecialistFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSpecialistBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
       if (args.search) {
           binding.specialistFragmentRecyclerSearchLayout.visibility = View.VISIBLE
           binding.specialistFragmentRecyclerTitle.visibility = View.GONE
           binding.specialistFragmentTitle.text = getString(R.string.specilist_title)
           binding.specialistFragmentSubtitle.text = getString(R.string.specilist_subtitle)
       } else {
           binding.specialistFragmentRecyclerSearchLayout.visibility = View.GONE
           binding.specialistFragmentRecyclerTitle.visibility = View.VISIBLE
           binding.specialistFragmentTitle.text = args.name
           binding.specialistFragmentSubtitle.text = args.description
       }
    }


}

