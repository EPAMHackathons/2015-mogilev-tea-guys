class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/records"(controller: "record", action: "getAll")
        "/model"(controller: "record", action: "getPredifineModel")
        "/getbytagids"(controller: "record", action: "getByTagIds")

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
