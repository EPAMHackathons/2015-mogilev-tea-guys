package org.tea.heart

class Record {
	
	Date createdAt

	String message

	String userPhotoUrl

	String userProfileUrl

	String userName

	String source

	Long sinceId // meta
	
static mapWith = "neo4j"
	static hasMany = [hashTags: HashTag]

    static constraints = {
		source nullable: true
		userName nullable: true
		userProfileUrl nullable: true
		userPhotoUrl nullable: true
		message nullable: true
		createdAt nullable: true
    }
	
}
