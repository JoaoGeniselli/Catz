package com.learning.catz.network

import com.google.gson.annotations.SerializedName

data class FactResponse(
    @SerializedName("_id")
    val id: String?,
    @SerializedName("text")
    val content: String?,
    @SerializedName("updatedAt")
    val updatedDate: String? // example: "2018-01-04T01:10:54.673Z"
)