package com.antoni.wijaya.thesport.ui.team.search

import com.antoni.wijaya.thesport.model.team.TeamResult
import com.antoni.wijaya.thesport.model.team.TeamValue
import com.antoni.wijaya.thesport.ui.match.search.SearchTeamView
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

class SearchTeamPresenterTest {

    @Test
    fun getTeamTestData() {
        val events: MutableList<TeamValue> = mutableListOf()
        val response = TeamResult(events)
        val str = "arsenal"

        runBlocking {
            Mockito.`when`(apiRepository.doAsyncRequestAsync(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)

            Mockito.`when`(apiResponse.await()).thenReturn("")

            Mockito.`when`(
                gson.fromJson(
                    "",
                    TeamResult::class.java
                )
            ).thenReturn(response)

            matchPresenter.getTeamData(str)


            Mockito.verify(view).showSearchedTeamData(events)
        }
    }

    @Mock
    private lateinit var view: SearchTeamView

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var apiResponse: Deferred<String>

    @Mock
    private lateinit var gson: Gson

    private lateinit var matchPresenter: SearchTeamPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        matchPresenter = SearchTeamPresenter(view, apiRepository, gson, TestContextProvider())
    }

}