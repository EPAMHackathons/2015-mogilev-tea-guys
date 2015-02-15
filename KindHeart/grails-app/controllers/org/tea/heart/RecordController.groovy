package org.tea.heart

import grails.converters.JSON
import org.springframework.social.twitter.api.GeoCode
import org.springframework.social.twitter.api.SearchParameters
import org.springframework.social.twitter.api.Twitter

class RecordController {

    Twitter twitter

    def getAll() {

        SearchParameters searchParameters = new SearchParameters("#ДОБРОЕСЕРДЦЕ")
//        searchParameters
//        searchParameters.geoCode(GeoCode)
//        searchParameters.

        def searchResults = twitter.searchOperations().search(searchParameters)

        searchResults.tweets.each { it ->

            it.getEntities().each { hashTagEntity ->

                hashTagEntity.hashTags.each { hashTag ->
                    HashTag newTag = new HashTag()
                    newTag.name = hashTag.text

//                    newTag.save()
//                }
            }
        }

        render searchResults as JSON;
    }
}
