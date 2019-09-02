package com.maruiz.picassoexample.presentation.di

import com.maruiz.picassoexample.data.api.BookApi
import com.maruiz.picassoexample.domain.usecase.GetBooks
import com.maruiz.picassoexample.presentation.adapter.BooksAdapter
import com.maruiz.picassoexample.presentation.viewmodel.BooksViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(getProperty<String>("base_url"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(BookApi::class.java) }
    single { GetBooks(get()) }
    factory { BooksAdapter() }
    viewModel { BooksViewModel(get()) }
}