package com.antoni.wijaya.thesport.ui.home.activity

import com.antoni.wijaya.thesport.ui.home.HomeView
import com.antoni.wijaya.thesport.utils.DataDummy
import com.antoni.wijaya.thesport.utils.provider.TestContextProvider
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class HomePresenterTest {

    @Test
    fun getLeagueTestData() {
        runBlocking {
            presenter.getLeagueData()
            Mockito.verify(view).showListLeague(DataDummy.generateDummyLeague())
        }
    }

    @Mock
    private lateinit var view: HomeView

    private lateinit var presenter: HomePresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = HomePresenter(view, TestContextProvider())
    }


}