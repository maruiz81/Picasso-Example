package com.maruiz.picassoexample.data.api

import com.maruiz.picassoexample.data.model.BookModel
import retrofit2.Call
import retrofit2.http.GET

interface BookApi {
    @GET("BookList.json")
    fun getBooks(): Call<List<BookModel>>
}