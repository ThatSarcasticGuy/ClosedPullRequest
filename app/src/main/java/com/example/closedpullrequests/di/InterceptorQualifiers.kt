package com.example.closedpullrequests.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Header

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Logger
