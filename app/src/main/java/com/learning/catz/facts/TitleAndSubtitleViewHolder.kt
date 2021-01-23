package com.learning.catz.facts

import androidx.recyclerview.widget.RecyclerView
import com.learning.catz.databinding.RowTitleSubtitleBinding

class TitleAndSubtitleViewHolder(
    private val binding: RowTitleSubtitleBinding
) : RecyclerView.ViewHolder(binding.root) {

    var title: String = ""
        set(value) {
            field = value
            binding.title.text = value
        }

    var subtitle: String = ""
        set(value) {
            field = value
            binding.subtitle.text = value
        }
}