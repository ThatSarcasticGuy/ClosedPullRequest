package com.example.closedpullrequests.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.closedpullrequests.adapters.ClosedPullRequestPagingSource
import com.example.closedpullrequests.apis.GithubResponse
import com.example.closedpullrequests.model.ClosedPullRequest
import com.example.closedpullrequests.utils.PAGE_SIZE
import javax.inject.Inject

class Repository @Inject constructor(
    private val network: GithubResponse
) {
    fun getPullRequests(): Pager<Int, ClosedPullRequest> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false
            )
        ) {
            ClosedPullRequestPagingSource(network)
        }
    }
}
