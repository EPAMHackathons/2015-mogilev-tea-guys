package org.tea.heart

class HashTag {
	
//	static mapWith = "neo4j"

	String name

    static hasMany = [records : Record]
    static belongsTo = Record
    static constraints = {
    }
	
}
