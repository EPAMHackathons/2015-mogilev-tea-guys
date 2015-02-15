class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/records"(controller: "record", action: "getStoredRecords")
        "/model"(controller: "record", action: "getPredifineModel")
        "/records/tags"(controller: "record", action: "getByTagIds")
        "/records/linked"(controller: "record", action: "getLinkedRecords")

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
