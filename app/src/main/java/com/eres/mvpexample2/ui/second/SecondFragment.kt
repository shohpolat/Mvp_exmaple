package com.eres.mvpexample2.ui.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.eres.kutubxonasample.model.ResponseData
import com.eres.kutubxonasample.model.SampleResponse
import com.eres.mvpexample2.Application.AppApplication
import com.eres.mvpexample2.R
import com.eres.mvpexample2.databinding.SecondFragmentBinding
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class SecondFragment : MvpAppCompatFragment(R.layout.second_fragment), SecondView {

    private var _binding: SecondFragmentBinding? = null
    private val binding get() = _binding!!

    @InjectPresenter
    lateinit var presenter: SecondPresenter

    @ProvidePresenter
    fun providePresenter(): SecondPresenter = SecondPresenter()

    private val args by navArgs<SecondFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = SecondFragmentBinding.bind(view)

        presenter.getSearchedText(args.month, args.year, args.method)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (requireActivity().application as AppApplication).appComponent.getActivityComponentFactory()
            .create().inject(this)

        (requireActivity().application as AppApplication).appComponent.getActivityComponentFactory()
            .create().inject(presenter)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun showBooks(data: SampleResponse<ResponseData>) {


        binding.recyclerView.apply {
            adapter = data.data?.let {
                DatesAdapter(it).apply {
                    setOnClickListener(object : DatesAdapter.OnItemClickListener {
                        override fun onClick(timestamp: String, date: String) {

                            navigateToThirdFragment(timestamp, date)

                        }

                    })
                }
            }
            setHasFixedSize(true)
        }
    }

    private fun navigateToThirdFragment(timestamp: String, date: String) {

        val action =
            SecondFragmentDirections.actionSecondFragmentToThirdFragment(timestamp, date, args.method)
        findNavController().navigate(action)

    }

    override fun showProgressBar() {
        binding.progressBar.isVisible = true
        binding.recyclerView.isVisible = false
    }

    override fun hideProgressBar() {
        binding.progressBar.isVisible = false
        binding.recyclerView.isVisible = true
    }

    override fun showNotFoundUI() {

        binding.progressBar.isVisible = false
        val text2 = "ushbu nomli kitob topilmadi!"
        binding.recyclerView.isVisible = false
        binding.text1.text = text2
        binding.notFoundContainer.isVisible = true

    }


}