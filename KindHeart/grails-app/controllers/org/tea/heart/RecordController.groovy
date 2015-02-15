package org.tea.heart

import grails.converters.JSON
import org.springframework.social.twitter.api.SearchParameters
import org.springframework.social.twitter.api.Twitter

class RecordController {

    Twitter twitter
    RecordProcessorService recordProcessorService

    def getAll() {

        SearchParameters searchParameters = new SearchParameters("#ДОБРАЕСЭРЦА")

        //searchParameters.geoCode(GeoCode)
//        searchParameters.

        def searchResults = twitter.searchOperations().search(searchParameters)

        searchResults.tweets.each { it ->

            it.getEntities().each { hashTagEntity ->

                hashTagEntity.hashTags.each { hashTag ->
                    HashTag newTag = new HashTag()
                    newTag.name = hashTag.text

//                    newTag.save()
                }
            }
        }

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

    def getByTagIds(ids){
        def results = recordProcessorService.searchByTags(ids)
        render results as JSON;
    }
}
