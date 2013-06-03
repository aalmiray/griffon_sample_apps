database {
    // driverClassName = 'org.h2.Driver'
    username = 'sa'
    password = ''
}
environments {
    development {
        database {
            url = 'jdbc:h2:mem:ormlite-sample-dev'
        }
    }
    test {
        database {
            url = 'jdbc:h2:mem:ormlite-sample-test'
        }
    }
    production {
        database {
            url = 'jdbc:h2:mem:ormlite-sample-prod'
        }
    }
}
