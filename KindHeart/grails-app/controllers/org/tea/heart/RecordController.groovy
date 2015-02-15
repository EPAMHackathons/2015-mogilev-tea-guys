package org.tea.heart

import grails.converters.JSON
import org.springframework.social.twitter.api.GeoCode
import org.springframework.social.twitter.api.SearchParameters
import org.springframework.social.twitter.api.Twitter

class RecordController {

    Twitter twitter

    def getAll() {

        SearchParameters searchParameters = new SearchParameters("#ДобраеСэрца")
        //searchParameters.geoCode(GeoCode)
//        searchParameters.

        def searchResults = twitter.searchOperations().search(searchParameters)

        render searchResults as JSON;
    }
    def getPredifineModel() {
        def  model = [
                createdAt: "2015-02-15T07:47:18Z",
                msg: '',
                photoUrl:'',
                hashTags: [ text:'ДобраеСэрца',
                            text:'Сабачка'],
                location : 'Могиле',
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
}
