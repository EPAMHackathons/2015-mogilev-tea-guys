package org.tea.heart

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
                    record.addToHashTags(exist)
                } else {
                    record.addToHashTags(new HashTag(name: hashTagEntity.text))
                }
            }

            record.save()
        }
    }

    def List<Record> searchByTags(def ids){

        def result = Record.createCriteria().list() {
            hashTags {
                'in' ("name", ["белая"])
            }
        }

        log.info "resultresult " + result

        return result
    }

    def List<Record> getLinkedRecords(String mainTag, List associatedTags) {

        def result = []

//        HashTag mainHashTag = HashTag.findByName(mainTag)

        String linkedTag = LinkedTagsEnum.findByName(mainTag)

        log.debug("Found linkedTag $linkedTag for main tag $mainTag")

        HashTag hashTag = HashTag.findByName(linkedTag)


//        Record.createCriteria().list() {
//            hashTags {
//                'in' ("id", ids.collect{it as Long}.toList())
//            }
//        }

        return hashTag.records
    }
}
