ebeanServer {
    // specify any properties from com.avaje.ebean.config.ServerConfig
    debugLazyLoad = true
}

/*
ebeanServers {
    someName {
        someConfigurationProperty = someValue
    }
}
*/

environments {
    development {
        ebeanServer {
            debugSql = true
        }
    }
    test {
        ebeanServer {
            debugSql = true
        }
    }
    production {
        ebeanServer {
            debugSql = false
        }
    }
}
