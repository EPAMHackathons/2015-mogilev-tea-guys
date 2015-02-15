import grails.converters.JSON
import org.tea.heart.HashTag
import org.tea.heart.Record

class BootStrap {

    def init = { servletContext ->

        JSON.registerObjectMarshaller(HashTag) {
            return [
                    id: it?.id,
                name: it?.name
            ]
        }

        JSON.registerObjectMarshaller(Record) {
            return  [
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
    }
    def destroy = {
    }
}
