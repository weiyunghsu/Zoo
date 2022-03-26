package com.weiyung.zoo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.weiyung.zoo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private var binding: FragmentHomeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)
        binding?.lifecycleOwner = this
        val recyclerView = binding?.root?.findViewById<RecyclerView>(R.id.home_recyclerview)

        val adapter = HomeAdapter(HomeAdapter.OnClickListener{})

        recyclerView?.adapter = adapter
        return binding?.root
    }
}