package org.tea.heart

class Record {

    Date createdAt

    String message

    String userPhotoUrl

    String userProfileUrl

    String userName

    String source

    Long sinceId // meta

    String recordPhotoUrl

//    static mapWith = "neo4j"
    static hasMany = [hashTags: HashTag]
    static mapping = {
        hashTags cascade: 'all-delete-orphan'
    }
    static constraints = {
        recordPhotoUrl nullable: true
        source nullable: true
        userName nullable: true
        userProfileUrl nullable: true
        userPhotoUrl nullable: true
        message nullable: true
        createdAt nullable: true
    }

    def getMainTags() {
        hashTags.findAll {
            LinkedTagsEnum.values()*.name.contains(it.name)
        }
    }
}
