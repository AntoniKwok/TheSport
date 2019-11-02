package com.antoni.wijaya.thesport.ui.match.search

import com.antoni.wijaya.thesport.model.event.EventValue

interface SearchMatchView {
    fun showSearchData(data: List<EventValue>)
}