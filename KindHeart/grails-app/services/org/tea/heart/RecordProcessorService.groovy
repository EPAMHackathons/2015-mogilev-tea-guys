package org.tea.heart

import grails.converters.JSON
import grails.transaction.Transactional
import org.springframework.social.twitter.api.HashTagEntity
import org.springframework.social.twitter.api.SearchResults
import org.springframework.social.twitter.api.Tweet

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
                HashTag exist = HashTag.findByName(hashTagEntity.text)
                if (exist) {
                    exist.addToRecords(record)
                    record.addToHashTags(exist)
                } else {
                    def newTag = new HashTag(name: hashTagEntity.text)
                    newTag.addToRecords(record)
                    record.addToHashTags(newTag)
                }
            }

            record.save()
        }
    }

    def searchByTags(def names){

        def result = Record.createCriteria().list() {
            hashTags {
                'in' ("name", names)
            }
        }

        log.info "resultresult " + result

        return result
    }

    def List<Record> getLinkedRecords(String mainTag, List associatedTags) {

        def result = []

//        HashTag mainHashTag = HashTag.findByName(mainTag)

        String linkedTag = LinkedTagsEnum.findByName(mainTag).linkedName

        log.debug("Found linkedTag $linkedTag for main tag $mainTag")

        HashTag hashTag = HashTag.findByName(linkedTag)

        log.debug("hashTaghashTagdsda " + hashTag.records)
        def records = hashTag.records?.toList()

        def parsed = records.collect {
            [
                    id: it.id,
                    createdAt: it.createdAt,
             message: it.message,
             userPhotoUrl: it.userPhotoUrl,
             userProfileUrl: it.userProfileUrl,
             userName: it.userName,
             sinceId: it.sinceId,
                    source: it.source,
                    hashTags: it.hashTags
            ]
        }
//        Record.createCriteria().list() {
//            hashTags {
        log.debug("hashTaghashTagdd" + records)
//                'in' ("id", ids.collect{it as Long}.toList())
//            }
//        }
        log.debug "recordsrecords " + (parsed as JSON)

        return parsed
    }
}
