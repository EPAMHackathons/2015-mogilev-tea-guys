package org.tea.heart

class Record {
	
	long id
	
	def origialTwitt
	
	def message
	
	static hasMany = [hashTags: HashTag]

    static constraints = {
    }
	
}
