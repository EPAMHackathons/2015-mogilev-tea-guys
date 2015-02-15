package org.tea.heart

import grails.transaction.Transactional
import org.springframework.social.twitter.api.HashTagEntity
import org.springframework.social.twitter.api.SearchResults
import org.springframework.social.twitter.api.Tweet

import static org.tea.heart.Record.*

@Transactional
class RecordProcessorService {

    def process(SearchResults searchResults) {

        searchResults.getTweets().each { Tweet tweet ->

            Record record = new Record()
            record.createdAt = tweet.getCreatedAt()
            record.message = tweet.unmodifiedText
            record.source = "twitter"
            record.userName = tweet.getUser().name
            record.userPhotoUrl = tweet.getUser().profileImageUrl
            record.userProfileUrl = tweet.getUser().profileUrl
            record.sinceId = searchResults.getSearchMetadata().maxId

            tweet.getEntities().hashTags.each { HashTagEntity hashTagEntity ->
                record.addToHashTags(new HashTag(name: hashTagEntity.text))
            }

            record.save()
        }
    }

    def List<Record> searchByTags(def ids){

        def result = Record.createCriteria().list() {
            hashTags {
                'in' ("id", ids.collect{it as Long}.toList())
            }
        }

        return result
    }

    def List<Record> getLinkedRecords(String mainTag, List associatedRecords) {

        def result = []

//        HashTag mainTag = HashTag.findByName()

        return result
    }
}
