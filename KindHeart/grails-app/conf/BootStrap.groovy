import grails.converters.JSON
import org.tea.heart.HashTag

class BootStrap {

    def init = { servletContext ->

        log.info "troltdofodfog"
        JSON.registerObjectMarshaller(HashTag) {
            return [
                name: it?.name
            ]
        }
    }
    def destroy = {
    }
}
