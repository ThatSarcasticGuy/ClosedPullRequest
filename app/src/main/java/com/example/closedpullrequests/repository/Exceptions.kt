package com.example.closedpullrequests.repository

import com.example.closedpullrequests.utils.ErrorMessages

sealed class Exceptions(errorMessage: String) : Exception(errorMessage) {
    object NoInternet : Exceptions(ErrorMessages.NO_INTERNET)
    object Generic : Exceptions(ErrorMessages.DEFAULT_MESSAGE)
}