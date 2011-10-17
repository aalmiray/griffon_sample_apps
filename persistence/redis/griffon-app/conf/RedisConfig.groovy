datasource {
    password = null
    timeout = 2000
    port = 6379
    database = 0
    pool {
        testWhileIdle = true
        minEvictableIdleTimeMillis = 60000
        timeBetweenEvictionRunsMillis = 30000
        numTestsPerEvictionRun = -1        
    }
}
environments {
    development {
        datasource {
            host = 'localhost'
        }
    }
    test {
        datasource {
            host = 'localhost'
        }
    }
    production {
        datasource {
            host = 'localhost'
        }
    }
}
