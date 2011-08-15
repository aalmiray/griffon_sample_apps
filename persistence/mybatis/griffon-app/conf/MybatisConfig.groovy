sessionFactory {
    // specify any properties from org.apache.ibatis.session.Configuration
    lazyLoadingEnabled = false
}

/*
sessionFactories {
    someName {
        someConfigurationProperty = someValue
    }
}
*/

environments {
    development {
        sessionFactory {
            lazyLoadingEnabled = false
        }
    }
    test {
        sessionFactory {
            lazyLoadingEnabled = false
        }
    }
    production {
        sessionFactory {
            lazyLoadingEnabled = true
        }
    }
}
