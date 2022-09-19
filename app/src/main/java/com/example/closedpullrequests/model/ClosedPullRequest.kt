package com.example.closedpullrequests.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class ClosedPullRequest(
    val id: Long,
    val title: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("closed_at") val closedAt: String,
    val user: RepoOwner
) {
    companion object {
        val CALLBACK = object : DiffUtil.ItemCallback<ClosedPullRequest>() {
            override fun areItemsTheSame(oldItem: ClosedPullRequest, newItem: ClosedPullRequest): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ClosedPullRequest, newItem: ClosedPullRequest): Boolean {
                return oldItem == newItem
            }
        }
    }
}

data class RepoOwner(
    val id: Long,
    @SerializedName("login")
    val userName: String,
    @SerializedName("avatar_url")
    val userImageUrl: String
)
