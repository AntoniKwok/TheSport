package com.antoni.wijaya.thesport.ui.detail.fragment.matches.fragment

import com.antoni.wijaya.thesport.model.match.MatchValue

interface MatchView {
    fun showMatchData(data: List<MatchValue>)
}