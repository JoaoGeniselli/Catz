package com.learning.catz.facts

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.learning.catz.databinding.ActivityFactsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FactsActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: FactsViewModel

    @Inject
    lateinit var adapter: FactsAdapter

    private lateinit var binding: ActivityFactsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecycler()
        bindToViewModel()
    }

    private fun setupRecycler() {
        binding.recyclerView.apply {
            this.adapter = this@FactsActivity.adapter
            addItemDecoration(
                DividerItemDecoration(this@FactsActivity, RecyclerView.VERTICAL)
            )
        }
    }

    private fun bindToViewModel() {
        lifecycle.addObserver(viewModel)
        with(viewModel) {
            facts.observe(
                this@FactsActivity,
                Observer { updateFactsList(it) }
            )
            startLoading.observe(
                this@FactsActivity,
                Observer { startLoading() }
            )
            stopLoading.observe(
                this@FactsActivity,
                Observer { stopLoading() }
            )
        }
    }

    private fun updateFactsList(facts: List<Fact>) = adapter.submitList(facts)

    private fun updateLoadingState(isLoading: Boolean) =
        if (isLoading) startLoading() else stopLoading()

    private fun startLoading() {
        binding.apply {
            recyclerView.isClickable = false
            progressBar.visibility = View.VISIBLE
        }
    }

    private fun stopLoading() {
        binding.apply {
            recyclerView.isClickable = true
            progressBar.visibility = View.GONE
        }
    }
}
