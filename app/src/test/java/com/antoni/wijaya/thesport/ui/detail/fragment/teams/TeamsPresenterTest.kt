package com.antoni.wijaya.thesport.ui.detail.fragment.teams

import com.antoni.wijaya.thesport.model.team.TeamResult
import com.antoni.wijaya.thesport.model.team.TeamValue
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

class TeamsPresenterTest {

    @Test
    fun getTeamTestData() {
        val teams: MutableList<TeamValue> = mutableListOf()
        val response = TeamResult(teams)
        val league = "4328"

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

            presenter.getTeamData(league)


            Mockito.verify(view).showTeamList(teams)
        }

    }

    @Mock
    private lateinit var view: TeamsView

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var apiResponse: Deferred<String>

    @Mock
    private lateinit var gson: Gson

    private lateinit var presenter: TeamsPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = TeamsPresenter(view, apiRepository, gson, TestContextProvider())
    }

}