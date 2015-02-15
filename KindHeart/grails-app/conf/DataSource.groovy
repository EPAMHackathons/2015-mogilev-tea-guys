dataSource {
    pooled = true
    driverClassName = "org.neo4j.jdbc.Driver"
    // use impermanent graph db, this requires an additional dependency in BuildConfig.groovy:
    // runtime(group:"org.neo4j", name:"neo4j-kernel", version:neo4jVerison, classifier:"tests")
    // url = "jdbc:neo4j:mem"
    // uncomment for embedded usage
    //url = "jdbc:neo4j:instance:test"
    // use remote database
    url = "jdbc:neo4j://localhost:7474/"
    // disabling autoCommit is crucial!
    properties = [
            defaultAutoCommit: false
    ]
    // username = "sa"
    // password = ""
}
//hibernate {
//    cache.use_second_level_cache = true
//    cache.use_query_cache = false
////    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
//    singleSession = true // configure OSIV singleSession mode
//    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
//}

grails {
	neo4j {
		type = "rest"
		location = "http://localhost:7474/db/data/"
	}
}

//neo4j {
//	// url = "jdbc:neo4j:instance:dummy"
//	// type = "rest"
//	type="rest"
//	location = "http://localhost:7474/db/data/"
//	//url = "jdbc:neo4j://localhost:7474"
//	// url = 'jdbc:neo4j:instance://localhost:7474'
//}

// environment specific settings
//environments {
//    development {
//        dataSource {
//            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
//            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
//        }
//    }
//    test {
//        dataSource {
//            dbCreate = "update"
//            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
//        }
//    }
//    production {
//        dataSource {
//            dbCreate = "update"
//            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
//            properties {
//               // See http://grails.org/doc/latest/guide/conf.html#dataSource for documentation
//               jmxEnabled = true
//               initialSize = 5
//               maxActive = 50
//               minIdle = 5
//               maxIdle = 25
//               maxWait = 10000
//               maxAge = 10 * 60000
//               timeBetweenEvictionRunsMillis = 5000
//               minEvictableIdleTimeMillis = 60000
//               validationQuery = "SELECT 1"
//               validationQueryTimeout = 3
//               validationInterval = 15000
//               testOnBorrow = true
//               testWhileIdle = true
//               testOnReturn = false
//               jdbcInterceptors = "ConnectionState"
//               defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
//            }
//        }
//    }
//}
