package com.antoni.wijaya.thesport.ui.match.search

import com.antoni.wijaya.thesport.model.event.EventValue
import com.antoni.wijaya.thesport.model.event.SearchResult
import com.antoni.wijaya.thesport.utils.api.ApiRepository
import com.antoni.wijaya.thesport.utils.provider.TestContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class SearchMatchPresenterTest {

    @Test
    fun getMatchTestData() {
        val events: MutableList<EventValue> = mutableListOf()
        val response = SearchResult(events)
        val str = "arsenal"

        runBlocking {
            Mockito.`when`(apiRepository.doAsyncRequestAsync(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)

            Mockito.`when`(apiResponse.await()).thenReturn("")

            Mockito.`when`(
                gson.fromJson(
                    "",
                    SearchResult::class.java
                )
            ).thenReturn(response)

            matchPresenter.getMatchData(str)


            Mockito.verify(view).showSearchData(events)
        }
    }

    @Mock
    private lateinit var view: SearchMatchView

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var apiResponse: Deferred<String>

    @Mock
    private lateinit var gson: Gson

    private lateinit var matchPresenter: SearchMatchPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        matchPresenter = SearchMatchPresenter(view, apiRepository, gson, TestContextProvider())
    }

}