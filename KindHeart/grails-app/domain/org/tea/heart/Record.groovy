package org.tea.heart

class Record {
	
	static mapWith = "neo4j"
	
	//long id
	
	def origialTwitt
	
	def message
	
	static hasMany = [hashTags: HashTag]

    static constraints = {
    }
	
}
