package com.antoni.wijaya.thesport.ui.match

import com.antoni.wijaya.thesport.model.event.EventResult
import com.antoni.wijaya.thesport.model.event.EventValue
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

class DetailMatchPresenterTest {

    @Test
    fun getMatchTestData() {
        val events: MutableList<EventValue> = mutableListOf()
        val response = EventResult(events)
        val league = "4328"

        runBlocking {
            Mockito.`when`(apiRepository.doAsyncRequestAsync(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)

            Mockito.`when`(apiResponse.await()).thenReturn("")

            Mockito.`when`(
                gson.fromJson(
                    "",
                    EventResult::class.java
                )
            ).thenReturn(response)

            presenter.getMatchData(league)


            Mockito.verify(view).showDetailMatchData(events)
//            Mockito.verify(view).loadHomeTeamLogo(teams)
//            Mockito.verify(view).showDetailMatchData(teams)
        }
    }
//
//    @Test
//    fun loadHomeTeamLogo(){
//        val teams: MutableList<TeamValue> = mutableListOf()
//        val response = MatchResult(teams)
//        val match = "602285"
//
//        runBlocking {
//            Mockito.`when`(apiRepository.doAsyncRequestAsync(ArgumentMatchers.anyString()))
//                .thenReturn(apiResponse)
//
//            Mockito.`when`(apiResponse.await()).thenReturn("")
//
//            Mockito.`when`(
//                gson.fromJson(
//                    "",
//                    MatchResult::class.java
//                )
//            ).thenReturn(response)
//
//            presenter.getHomeTeamLogo()
//            presenter.getAwayTeamLogo(events[0].awayTeamId)
//        }
//    }

    @Mock
    private lateinit var view: DetailMatchView

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var apiResponse: Deferred<String>

    @Mock
    private lateinit var gson: Gson

    private lateinit var presenter: DetailMatchPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailMatchPresenter(view, apiRepository, gson, TestContextProvider())
    }

}