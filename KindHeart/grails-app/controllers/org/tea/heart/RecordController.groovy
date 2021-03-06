package org.tea.heart

import grails.converters.JSON
import org.springframework.social.twitter.api.SearchParameters
import org.springframework.social.twitter.api.Twitter

class RecordController {

    Twitter twitter
    RecordProcessorService recordProcessorService
    HashTagsService hashTagsService

    def getAll() {

        SearchParameters searchParameters = new SearchParameters("#ДОБРАЕСЭРЦА")

        //searchParameters.geoCode(GeoCode)
//        searchParameters.

        def searchResults = twitter.searchOperations().search(searchParameters)

        render searchResults as JSON;
    }

    def getStoredRecords() {

        def result = [success:true, model: Record.getAll()]

        render result as JSON
    }

    def getPredifineModel() {
        def  model = [
                createdAt: "2015-02-15T07:47:18Z",
                msg: '',
                photoUrl:'',
                hashTags: [ text:'ДобраеСэрца',
                            text:'Сабачка'],
                location : 'Магилеу',
                user:[  name: 'asd',
                        profileUrl:'http://twitter.com/AnimalAngel47',
                        profile_image_url: 'https://pbs.twimg.com/profile_images/560601273519865856/zVW7NNJX_normal.jpeg'],
                source: 'Twitter'
        ];
        def results =[]
        def answer = [success : true, model: model, message : 'test message']
        results.add(answer)
        answer =  [success : false, model: model, message : 'test message']
        results.add(answer)

        render results as JSON;
    }

    def getByTagIds(){

        def allParams = params + request.JSON

        log.debug("allParams" + allParams)
        def results = recordProcessorService.searchByTags(allParams.names)

        render results as JSON;
    }

    def getLinkedRecords() {

        def allParams = params + request.JSON

        assert allParams.mainTag
        assert allParams.associatedTags

        def mainTag = allParams.mainTag as String
        def associatedTags = []
        if (allParams.associatedTags instanceof String) {
            associatedTags.add(allParams.associatedTags)
        } else {
            associatedTags = allParams.associatedTags
        }
        allParams.associatedTags as List

        def result = recordProcessorService.getLinkedRecords(mainTag, associatedTags)

        render result as JSON
    }

    def getTopTags() {
        render hashTagsService.getTopTags() as JSON
    }

    def sendTwittMessage() {

        def allParams = params + request.JSON

        //twitter.

    }
}
