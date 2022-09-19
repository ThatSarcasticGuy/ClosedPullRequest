package com.example.closedpullrequests.apis

import com.example.closedpullrequests.utils.HEADER_ACCEPT
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val nRequest = request.newBuilder()
            .addHeader(HEADER_ACCEPT, "application/vnd.github+json")
            .build()
        return chain.proceed(nRequest)
    }
}