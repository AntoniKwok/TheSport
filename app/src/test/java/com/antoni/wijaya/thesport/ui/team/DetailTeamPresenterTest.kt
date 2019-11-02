package com.antoni.wijaya.thesport.ui.team

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

class DetailTeamPresenterTest {

    @Test
    fun getTestTestData() {
        val events: MutableList<TeamValue> = mutableListOf()
        val response = TeamResult(events)
        val league = "133604"

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

            presenter.getDetailData(league)


            Mockito.verify(view).getTeamData(events)
//            Mockito.verify(view).loadHomeTeamLogo(teams)
//            Mockito.verify(view).showDetailMatchData(teams)
        }
    }

    @Mock
    private lateinit var view: DetailTeamView

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var apiResponse: Deferred<String>

    @Mock
    private lateinit var gson: Gson

    private lateinit var presenter: DetailTeamPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailTeamPresenter(view, apiRepository, gson, TestContextProvider())
    }
}