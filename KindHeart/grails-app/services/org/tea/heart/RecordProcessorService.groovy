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
            if (tweet.hasMedia()) {
                record.recordPhotoUrl = tweet.entities.media.get(0).mediaUrl
            }

            tweet.getEntities().hashTags.each { HashTagEntity hashTagEntity ->
                HashTag exist = HashTag.findByName(hashTagEntity.text)
                if (exist) {
//                    exist.addToRecords(record)
                    record.addToHashTags(exist)
                } else {
                    def newTag = new HashTag(name: hashTagEntity.text)
//                    newTag.addToRecords(record)
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
                    id            : it.id,
                    createdAt     : it.createdAt,
                    message       : it.message,
                    userPhotoUrl  : it.userPhotoUrl,
                    userProfileUrl: it.userProfileUrl,
                    userName      : it.userName,
                    sinceId       : it.sinceId,
                    source        : it.source,
                    hashTags      : it.hashTags,
                    recordPhotoUrl: it.recordPhotoUrl,
                    mainTags: it.mainTags
            ]
        }

//        associatedTags.each { tag ->
//
//        }
        log.debug "recordsrecords " + (parsed as JSON)

        def sortedRecords = []
        parsed.each { parsedEntry ->
//            parsedEntry.hashTags.values()
            Integer matchesNumber = 0
            parsedEntry.hashTags.each {
                log.info "itititit " + it.name + " containsed " + associatedTags
                if (associatedTags.contains(it.name)) {
                    matchesNumber++
                }
            }

            sortedRecords.push(parsedEntry + [matchesNumber: matchesNumber])
        }

log.info "sortedRecords.sort { a,b -> a.matchesNumber <=> b.matchesNumber } " + sortedRecords.sort { a,b -> a.matchesNumber <=> b.matchesNumber }.collect{it.matchesNumber}
        return sortedRecords.sort { a,b -> b.matchesNumber <=> a.matchesNumber }
    }
}
