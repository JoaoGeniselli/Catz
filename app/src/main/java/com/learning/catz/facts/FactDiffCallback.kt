package com.learning.catz.facts

import androidx.recyclerview.widget.DiffUtil

class FactDiffCallback : DiffUtil.ItemCallback<Fact>() {

    override fun areItemsTheSame(oldItem: Fact, newItem: Fact): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Fact, newItem: Fact): Boolean =
        oldItem.id == newItem.id &&
                oldItem.content == newItem.content &&
                oldItem.updatedDate == newItem.updatedDate
}