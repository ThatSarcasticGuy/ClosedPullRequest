package com.example.closedpullrequests.adapters

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.closedpullrequests.apis.GithubResponse
import com.example.closedpullrequests.model.ClosedPullRequest
import com.example.closedpullrequests.repository.Exceptions
import com.example.closedpullrequests.utils.PAGE_SIZE
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ClosedPullRequestPagingSource @Inject constructor(
    private val network: GithubResponse
) : PagingSource<Int, ClosedPullRequest>() {
    override fun getRefreshKey(state: PagingState<Int, ClosedPullRequest>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ClosedPullRequest> {
        return try {
            val nextPageKey = params.key ?: 1
            val prevPage = if (nextPageKey == 1) null else nextPageKey

            val requests = network.getPullRequests(
                owner = "Gautham245",
                repo = "Gautham245.github.io",
                page = nextPageKey,
                pageSize = PAGE_SIZE
            )
            if (requests.isEmpty()) {
                LoadResult.Page(requests, prevPage, null)
            } else {
                LoadResult.Page(requests, prevPage, nextPageKey + 1)
            }
        } catch (e: HttpException) {
            LoadResult.Error(Exceptions.Generic)
        } catch (e: IOException) {
            LoadResult.Error(Exceptions.NoInternet)
        } catch (e: Exception) {
            LoadResult.Error(Exceptions.Generic)
        }
    }
}
