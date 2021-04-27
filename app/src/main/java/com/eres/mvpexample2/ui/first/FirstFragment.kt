package com.eres.mvpexample2.ui.first

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.eres.mvpexample2.R
import com.eres.mvpexample2.databinding.FirstFragmentBinding
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class FirstFragment : MvpAppCompatFragment(R.layout.first_fragment), FirstView {
    private var _binding: FirstFragmentBinding? = null
    private val binding get() = _binding!!

    @InjectPresenter
    lateinit var presenter: FirstPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FirstFragmentBinding.bind(view)

        binding.searchBtn.setOnClickListener {

            val month = binding.monthInput.text.toString()
            val year = binding.yearInput.text.toString()
            val method = binding.methodInput.text.toString()
            if (month.isNotEmpty() && year.isNotEmpty() && method.isNotEmpty()) {
                navigateToBooks(
                    month.toInt(), year.toInt(), method.toInt()
                )
            }

        }

    }

    fun navigateToBooks(month: Int, year: Int, method: Int) {
        val action =
            FirstFragmentDirections.actionFirstFragmentToSecondFragment(month, year, method)
        findNavController().navigate(action)

    }

    override fun showToast(toastMessage: String) {

        println("on activity")
        Toast.makeText(requireContext(), toastMessage, Toast.LENGTH_SHORT).show()

    }

}