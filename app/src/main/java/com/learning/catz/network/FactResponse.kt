package com.learning.catz.network

import com.google.gson.annotations.SerializedName

data class FactResponse(
    @SerializedName("_id")
    val id: String?,
    @SerializedName("text")
    val content: String?,
    @SerializedName("updatedAt")
    val updatedDate: String?
)