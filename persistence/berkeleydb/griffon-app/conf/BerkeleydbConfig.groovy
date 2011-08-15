environment {
    transactional = true
    allowCreate = true
}
entityStores {
    person {
        transactional = true
        allowCreate = true
    }
}
environments {
    development {
        environment {
            home = 'berkeleydb-sample-dev'
        }
    }
    test {
        environment {
            home = 'berkeleydb-sample-test'
        }
    }
    production {
        environment {
            home = 'berkeleydb-sample-prod'
        }
    }
}
