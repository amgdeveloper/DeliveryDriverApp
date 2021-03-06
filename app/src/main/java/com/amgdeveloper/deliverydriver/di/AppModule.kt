package com.amgdeveloper.deliverydriver.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Created by amgdeveloper
 */

@Module
class AppModule {

    @Provides
    fun coroutineDispatcher(): CoroutineDispatcher = Dispatchers.Main
}