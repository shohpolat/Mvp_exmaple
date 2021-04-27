package com.eres.mvpexample2.ui.third

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.eres.kutubxonasample.model.ResponseData
import com.eres.kutubxonasample.model.ResponseData2
import com.eres.kutubxonasample.model.SampleResponse
import com.eres.kutubxonasample.model.SampleResponse2
import com.eres.mvpexample2.Application.AppApplication
import com.eres.mvpexample2.R
import com.eres.mvpexample2.databinding.SecondFragmentBinding
import com.eres.mvpexample2.databinding.ThirdFragmentBinding
import com.eres.mvpexample2.model.Timings
import com.eres.mvpexample2.ui.second.SecondFragmentArgs
import com.eres.mvpexample2.ui.second.SecondPresenter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class ThirdFragment : MvpAppCompatFragment(R.layout.third_fragment), ThirdView {

    private var _binding: ThirdFragmentBinding? = null
    private val binding get() = _binding!!

    @InjectPresenter
    lateinit var presenter: ThirdPresenter

    @ProvidePresenter
    fun providePresenter(): ThirdPresenter = ThirdPresenter()

    private val args by navArgs<ThirdFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ThirdFragmentBinding.bind(view)

        presenter.getTimings(args.timestamp, args.method)

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

    override fun showPrayerTimes(responseData2: ResponseData2) {

        val timings = responseData2.times!!

        val meta = responseData2.meta!!.method!!

        val string = " Bomdot : ${timings.bomdot} \n" +
                " Quyosh : ${timings.quyosh} \n" +
                " Peshin : ${timings.peshin} \n" +
                " Asr : ${timings.asr} \n" +
                " Quyosh Botishi : ${timings.quyosh_botishi} \n" +
                " Shom : ${timings.shom} \n" +
                " Xufton : ${timings.xufton} \n" +
                " Imsak : ${timings.imsak} \n" +
                " Tun yarmi : ${timings.tun_yarmi} \n\n\n" +
                " MethodName : ${meta.name} \n" +
                " MethodID : ${meta.id}"

        binding.text.text = string

    }

    override fun showNotFoundUI() {

        binding.progressBar.isVisible = false
        val text2 = "ushbu nomli kitob topilmadi!"
        binding.text.isVisible = false
        binding.text1.text = text2
        binding.notFoundContainer.isVisible = true

    }

    override fun showProgressBar() {

        binding.progressBar.isVisible = true
        binding.text.isVisible = false

    }

    override fun hideProgressBar() {
        binding.progressBar.isVisible = false
        binding.text.isVisible = true
    }

}