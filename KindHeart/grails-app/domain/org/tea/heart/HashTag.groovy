package org.tea.heart

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class HashTag implements Comparable {
	
//	static mapWith = "neo4j"

	String name

    static hasMany = [records : Record]
    static belongsTo = Record
    static constraints = {
    }

    static mapping = {
        sort "name"
    }

    int compareTo(obj) {
        name.compareToIgnoreCase(obj.name)
    }
	
}
