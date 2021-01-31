package com.learning.catz.facts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.learning.catz.commons.DateFormatter
import com.learning.catz.databinding.RowTitleSubtitleBinding

class FactsAdapter(
    factDiffCallback: FactDiffCallback
) : ListAdapter<Fact, TitleAndSubtitleViewHolder>(factDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleAndSubtitleViewHolder {
        val binding = RowTitleSubtitleBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TitleAndSubtitleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TitleAndSubtitleViewHolder, position: Int) {
        val fact = getItem(position)
        holder.apply {
            title = fact.content
            subtitle = DateFormatter().format(fact.updatedDate)
        }
    }
}