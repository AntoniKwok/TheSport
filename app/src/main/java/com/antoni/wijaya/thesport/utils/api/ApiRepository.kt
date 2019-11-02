package com.antoni.wijaya.thesport.utils.api

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import java.net.URL

class ApiRepository {

    fun doAsyncRequestAsync(url : String) : Deferred<String> = GlobalScope.async{
        URL(url).readText()
    }

}