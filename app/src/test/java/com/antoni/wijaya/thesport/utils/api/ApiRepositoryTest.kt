package com.antoni.wijaya.thesport.utils.api

import org.junit.Test
import org.mockito.Mockito

class ApiRepositoryTest {

    @Test
    fun testDoRequest() {
        val apiRepository = Mockito.mock(ApiRepository::class.java)
        val url =
            "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English%20Premier%20League"
        apiRepository.doAsyncRequestAsync(url)
        Mockito.verify(apiRepository).doAsyncRequestAsync(url)
    }

}