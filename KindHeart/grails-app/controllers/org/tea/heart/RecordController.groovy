package org.tea.heart

import grails.converters.JSON
import org.springframework.social.twitter.api.SearchParameters
import org.springframework.social.twitter.api.Twitter

class RecordController {

    Twitter twitter

    def getAll() {

        SearchParameters searchParameters = new SearchParameters("#ДОБРАЕСЭРЦА")
//        searchParameters
//        searchParameters.geoCode(GeoCode)
//        searchParameters.

        def searchResults = twitter.searchOperations().search(searchParameters)

        render searchResults as JSON;
    }

    def getStoredRecords() {

        def result = [success:true, model: Record.getAll()]

        render result as JSON
    }
}
