package org.tea.heart

import grails.transaction.Transactional
import org.springframework.social.twitter.api.SearchResults
import org.springframework.social.twitter.api.Tweet

@Transactional
class RecordProcessorService {

    def process(SearchResults searchResults) {

        log.info("searchResultssearchResults processed!: " + searchResults)
        searchResults.getTweets().each { Tweet tweet ->

            tweet.getEntities().hashTags
        }
    }
}
