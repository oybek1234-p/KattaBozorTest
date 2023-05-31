package com.example.ui.features.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.commons.visibleOrGone
import com.example.ui.databinding.FeedFragmentBinding
import com.example.ui.features.feed.adapter.PostsAdapter
import com.example.ui.features.feed.adapter.postDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FeedFragment : Fragment() {

    private val viewModel: FeedViewModel by viewModels()
    private var binding: FeedFragmentBinding? = null

    private var productsAdapter = lazy {
        PostsAdapter(LayoutInflater.from(requireContext())) { }
    }

    private fun initObservers() {
        binding?.apply {
            viewModel.apply {
                products.observe(viewLifecycleOwner) {
                    if (loading.value == false) {
                        text.text = if (it.isEmpty()) "Нет продуктов" else ""
                    }
                    productsAdapter.value.submitList(it)
                }
                loading.observe(viewLifecycleOwner) {
                    progressBar.visibleOrGone(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FeedFragmentBinding.inflate(inflater).apply {
            recyclerView.apply {
                addItemDecoration(postDecoration)
                layoutManager = StaggeredGridLayoutManager(
                    2,
                    StaggeredGridLayoutManager.VERTICAL
                )
            }
            initObservers()
            lifecycleScope.launch {
                viewModel.loadProducts()
            }
        }
        return binding?.root
    }

}