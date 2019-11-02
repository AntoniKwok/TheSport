package com.antoni.wijaya.thesport.ui.detail.fragment.info

import com.antoni.wijaya.thesport.model.league.LeagueResult
import com.antoni.wijaya.thesport.model.league.LeagueValue
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

class InfoLeaguePresenterTest {

    @Test
    fun getDetailTestData() {
        val leagues: MutableList<LeagueValue> = mutableListOf()
        val response = LeagueResult(leagues)
        val league = "4328"

        runBlocking {
            Mockito.`when`(apiRepository.doAsyncRequestAsync(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)

            Mockito.`when`(apiResponse.await()).thenReturn("")

            Mockito.`when`(
                gson.fromJson(
                    "",
                    LeagueResult::class.java
                )
            ).thenReturn(response)

            presenter.getMatchDetailData(league)
            Mockito.verify(view).showDetailData(leagues)
        }

    }

    @Mock
    private lateinit var view: InfoLeagueView

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var apiResponse: Deferred<String>

    @Mock
    private lateinit var gson: Gson

    private lateinit var presenter: InfoLeaguePresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = InfoLeaguePresenter(view, apiRepository, gson, TestContextProvider())
    }

}