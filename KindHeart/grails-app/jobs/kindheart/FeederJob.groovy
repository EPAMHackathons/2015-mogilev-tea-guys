package kindheart

import org.springframework.social.twitter.api.SearchParameters
import org.springframework.social.twitter.api.SearchResults
import org.springframework.social.twitter.api.Twitter
import org.tea.heart.RecordProcessorService


class FeederJob {

    Twitter twitter
    RecordProcessorService recordProcessorService

    static triggers = {
      simple repeatInterval: 10000l // execute job once in 10 seconds
    }

    def execute() {

        log.info("Executed!!!!")
        println "execsuted!!"

        SearchParameters searchParameters = new SearchParameters("#ДОБРАЕСЭРЦА")

        SearchResults searchResults = twitter.searchOperations().search(searchParameters)

        recordProcessorService.process(searchResults)
    }
}
