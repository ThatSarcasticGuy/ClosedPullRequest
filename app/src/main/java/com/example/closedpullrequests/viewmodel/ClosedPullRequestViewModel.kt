package com.example.closedpullrequests.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.closedpullrequests.model.ClosedPullRequest
import com.example.closedpullrequests.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ClosedPullRequestViewModel @Inject constructor(
    repository: Repository
) : ViewModel() {
    private val _requests = repository.getPullRequests()
        .flow
        .cachedIn(viewModelScope)
    val requests: Flow<PagingData<ClosedPullRequest>>
        get() = _requests
}