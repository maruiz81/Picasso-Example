package com.maruiz.picassoexample.domain.usecase

import arrow.core.Either
import arrow.core.None
import com.maruiz.picassoexample.data.api.BookApi
import com.maruiz.picassoexample.data.error.Failure
import com.maruiz.picassoexample.data.extensions.makeRequest
import com.maruiz.picassoexample.data.model.BookModel

class GetBooks(private val bookApi: BookApi) : UseCase<List<BookModel>, None>() {
    override suspend fun run(params: None): Either<Failure, List<BookModel>> =
        bookApi.getBooks().makeRequest().map { it ?: emptyList() }
}
