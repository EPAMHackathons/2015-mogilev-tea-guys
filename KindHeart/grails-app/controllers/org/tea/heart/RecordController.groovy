package org.tea.heart

import grails.converters.JSON
import org.springframework.social.twitter.api.SearchParameters
import org.springframework.social.twitter.api.Twitter

class RecordController {

    Twitter twitter

    def getAll() {

        SearchParameters searchParameters = new SearchParameters("#lost-pets")
//        searchParameters.geoCode(GeoCode)

        def searchResults = twitter.searchOperations().search(searchParameters)

        render "searchResults " + (searchResults as JSON);
    }
}
