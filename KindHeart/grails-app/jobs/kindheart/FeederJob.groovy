package kindheart

import org.springframework.social.twitter.api.SearchParameters
import org.springframework.social.twitter.api.SearchResults
import org.springframework.social.twitter.api.Twitter
import org.tea.heart.Record
import org.tea.heart.RecordProcessorService


class FeederJob {

    Twitter twitter
    RecordProcessorService recordProcessorService

    static triggers = {
      simple repeatInterval: 120000l // execute job once in 10 seconds
    }

    def execute() {

        Long curSinceId = 0
        Record.withTransaction {
            curSinceId = Record.createCriteria().get {
                projections {
                    max "sinceId"
                }
            } as Long
        }

        curSinceId = curSinceId ?: 0
        log.debug("curSinceId is $curSinceId ")

        SearchParameters searchParameters = new SearchParameters("#ДОБРАЕСЭРЦА")
        searchParameters.sinceId = curSinceId + 1

        SearchResults searchResults = twitter.searchOperations().search(searchParameters)

        recordProcessorService.process(searchResults)
    }
}
