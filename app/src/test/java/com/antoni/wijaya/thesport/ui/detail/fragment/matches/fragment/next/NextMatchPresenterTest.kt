package com.antoni.wijaya.thesport.ui.detail.fragment.matches.fragment.next

import com.antoni.wijaya.thesport.model.match.MatchResult
import com.antoni.wijaya.thesport.model.match.MatchValue
import com.antoni.wijaya.thesport.ui.detail.fragment.matches.fragment.MatchView
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


class NextMatchPresenterTest {

    @Test
    fun getTestListMatches() {
        val matches: MutableList<MatchValue> = mutableListOf()
        val response = MatchResult(matches)
        val league = "4328"

        runBlocking {
            Mockito.`when`(apiRepository.doAsyncRequestAsync(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)

            Mockito.`when`(apiResponse.await()).thenReturn("")

            Mockito.`when`(
                gson.fromJson(
                    "",
                    MatchResult::class.java
                )
            ).thenReturn(response)

            presenter.getListMatches(league)


            Mockito.verify(view).showMatchData(matches)
        }

    }

    @Mock
    private lateinit var view: MatchView

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var apiResponse: Deferred<String>

    @Mock
    private lateinit var gson: Gson

    private lateinit var presenter: NextMatchPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = NextMatchPresenter(view, apiRepository, gson, TestContextProvider())
    }
}