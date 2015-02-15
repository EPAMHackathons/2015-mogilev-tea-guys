package org.tea.heart

import com.google.common.collect.Maps
import com.google.common.collect.Sets

import grails.transaction.Transactional

@Transactional
class HashTagsService {

    def Set<HashTag> getTopTags() {

        Map<HashTag, Integer> topHashTags = Maps.newHashMap()
        Set<HashTag> finalTopTags = Sets.newTreeSet()

        HashTag.getAll().each { hashTag ->

            topHashTags.put(hashTag, hashTag.records.size())

        }

        topHashTags?.sort { a,b -> a.value <=> b.value }

        topHashTags.each { HashTag tag, Integer count ->
            finalTopTags.add(tag)
            if (finalTopTags.size() >= 10) return false
        }

        finalTopTags

    }
}
