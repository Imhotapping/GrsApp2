package com.example.grsapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.grsapp2.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submitButton.setOnClickListener {
            val name = binding.nameEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()

            if (name.isEmpty()) {
                binding.nameInputLayout.error = getString(R.string.error_name)
                binding.resultTextView.visibility = View.GONE
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.passwordInputLayout.error = getString(R.string.error_password)
                binding.nameInputLayout.error = null
                binding.resultTextView.visibility = View.GONE
                return@setOnClickListener
            }

            binding.nameInputLayout.error = null
            binding.passwordInputLayout.error = null
            binding.resultTextView.text = getString(R.string.result_format, name)
            binding.resultTextView.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}