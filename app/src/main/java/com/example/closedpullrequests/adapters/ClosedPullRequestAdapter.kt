package com.example.closedpullrequests.adapters

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.closedpullrequests.model.ClosedPullRequest

class ClosedPullRequestAdapter :
    PagingDataAdapter<ClosedPullRequest, ClosedPullRequestListItemViewHolder>(ClosedPullRequest.CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClosedPullRequestListItemViewHolder {
        return ClosedPullRequestListItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ClosedPullRequestListItemViewHolder, position: Int) {
        getItem(position)?.let(holder::bind)
    }
}
