import org.springframework.social.twitter.api.impl.TwitterTemplate

// Place your Spring DSL code here
beans = {


    twitter(TwitterTemplate, grailsApplication.config.twitter.consumerKey,
            grailsApplication.config.twitter.consumerSecret,
            grailsApplication.config.twitter.accessToken,
            grailsApplication.config.twitter.accessTokenSecret) {
    }
}
